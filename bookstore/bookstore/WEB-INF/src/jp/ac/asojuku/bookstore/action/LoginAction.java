package jp.ac.asojuku.bookstore.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import jp.ac.asojuku.bookstore.bao.LoginLog;
import jp.ac.asojuku.bookstore.bo.LoginBo;
import jp.ac.asojuku.bookstore.bo.impl.LoginBoImpl;
import jp.ac.asojuku.bookstore.config.MessageProperty;
import jp.ac.asojuku.bookstore.dto.LoginInfoDTO;
import jp.ac.asojuku.bookstore.exception.BookStoreSystemErrorException;
import jp.ac.asojuku.bookstore.exception.DBConnectException;
import jp.ac.asojuku.bookstore.exception.LoginFailureException;
import jp.ac.asojuku.bookstore.param.RequestConst;
import jp.ac.asojuku.bookstore.param.SessionConst;

public class LoginAction extends HttpServlet{
	

	/* ログイン処理
	 * (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBo loginbo = new LoginBoImpl();
		LoginLog logininfo = new LoginLog();
		//jspから値を取得
		String memb_id = request.getParameter("memb_id");
		String password = request.getParameter("password");
		LoginInfoDTO loginInfo;
		DateTime dt = new DateTime(DateTimeZone.forID("Asia/Tokyo"));
		String date = dt.toString(DateTimeFormat.mediumDateTime());
		//System.out.println(date);
		//'yyyy/MM/dd HH:mm:ss'
		try{
			//トークンが正しいか判定
			if(checkToken(request)){
				//ログイン処理を実行する引数に（メールアドレスとパスワード）
				loginInfo = loginbo.login(memb_id, password);
				//ログインが成功判定
				if(loginInfo == null){
					//ログイン失敗時に遷移
					fowardLoginErrDisp(request,response);
					return;
				}
				int num;
				
				try {
					
					num = logininfo.setLoginDate(loginInfo,date);
					if(num == 0){
						RequestDispatcher rd = request.getRequestDispatcher("view/systemerror.jsp");
						rd.forward(request, response);
					}
				} catch (DBConnectException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}catch(SQLException e){
					e.printStackTrace();
				}
				//ログイン情報をセッション保持
				setLoginInfoToSession(request,loginInfo);
				//
				//トップ画面へ遷移
				RequestDispatcher rd = request.getRequestDispatcher("view/top.jsp");
				rd.forward(request, response);
			}else {
				System.out.println("kk");
				//不正なアクセスがある場合にシステムエラーペースに遷移
				RequestDispatcher rd = request.getRequestDispatcher("view/systemerror.jsp");
				rd.forward(request, response);
			}
				
			
			

		} catch (LoginFailureException e){
			fowardLoginErrDisp(request,response);
		}
	}
	/* ログイン失敗時の処理
	 * (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	private void fowardLoginErrDisp(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String errMsg;
		try{
			//プロパティファイルからプロパティの取得する
			errMsg = MessageProperty.getInstance().getProperty(MessageProperty.LOGIN_ERR_LOGINERR);
			//リクエストのエラーメッセージい保持
			request.setAttribute(RequestConst.LOGIN_ERR_MSG,errMsg );
			//ログインページに遷移
			RequestDispatcher rd = request.getRequestDispatcher("view/login.jsp");
			rd.forward(request, response);

		} catch (BookStoreSystemErrorException e){

		}
	}
	private void setLoginInfoToSession(HttpServletRequest request, LoginInfoDTO loginInfo){
		HttpSession session = request.getSession(false);
		if(session != null){
			//セッションの破棄
			session.invalidate();

		}
		//セッションの生成
		session = request.getSession(true);
		//ログイン情報をセッションに保持
		session.setAttribute(SessionConst.SESSION_LOGININFO, loginInfo);
		

	}
	/**
	 * トークンが正しいかどうか確認
	 * @param request
	 * @return
	 */
	private boolean checkToken(HttpServletRequest request){
		System.out.println("sss");
		
		//セッションの取得
		HttpSession session = request.getSession(false);
		
		//System.out.println("1");
		//System.out.println("@"+session.getAttribute(SessionConst.SESSION_LOGUIN_TOKEN1)+ "@");
		
		//サーバー側から送られてきたトークンがnullではないか判定
		if( session.getAttribute(SessionConst.SESSION_LOGUIN_TOKEN1) == null ){
			return false;
		}
		//クライアント側から送られてきたトークン取得
		String clientToken = (String)request.getParameter("_CSRFToken");
		
		if(clientToken == null){
			//System.out.println("book");
			return false;
		}
		try {
			
			//トークンをデコードする
			clientToken = URLDecoder.decode(clientToken,"UTF-8");
			System.out.println("OK");
			
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//System.out.println("2");
		//System.out.println("@"+clientToken+"@");
		
		//サーバー側から送られてきたトークンを取得
		String serverToken = (String)session.getAttribute(SessionConst.SESSION_LOGUIN_TOKEN1);
		
		//クライアント側から送られたトークンの５０文字を取得
		//String str1 = clientToken.substring(0,50);
		//トークン（暗号）の文字数
		int i = clientToken.length();
		int k = serverToken.length();
		//トークンを表示
		System.out.println("クライアントのトークンの文字数は、" + i + "です。");
		System.out.println("サーバーのトークンの文字数は、" + k + "です。");
		//サーバー側で生成したトークを５０文字を取得
		//String str2 = serverToken.substring(0,50);
		
		//トークンのテスト
		boolean  msg = serverToken.equals(clientToken);
		//トークンのテストの結果を表示
		//System.out.println(msg);
		if(clientToken != null && !"".equals(clientToken)){
			
			if(serverToken.equals(clientToken)){
				//System.out.println("トークンチェックOK");
				return true;
			}
		}
		return false;
	}
	

}
