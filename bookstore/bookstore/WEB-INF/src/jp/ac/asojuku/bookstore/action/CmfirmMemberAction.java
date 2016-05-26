package jp.ac.asojuku.bookstore.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.asojuku.bookstore.bao.EntlyMemberDao;
import jp.ac.asojuku.bookstore.bao.LoginLog;
import jp.ac.asojuku.bookstore.config.MessageProperty;
import jp.ac.asojuku.bookstore.dto.MemberDTO;
import jp.ac.asojuku.bookstore.dto.SystemError;
import jp.ac.asojuku.bookstore.error.CodeError;
import jp.ac.asojuku.bookstore.exception.BookStoreSystemErrorException;
import jp.ac.asojuku.bookstore.exception.DBConnectException;
import jp.ac.asojuku.bookstore.param.RequestConst;
import jp.ac.asojuku.bookstore.param.SessionConst;


public class CmfirmMemberAction extends BaseServlet {
	
	
	
	
	@Override
	protected void doPostMain(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException,BookStoreSystemErrorException {
		try{
			
		
			if(checkToken(request)){
				
			
				MemberDTO member = getMemberINFOform(request);
				LoginLog logininfo = new LoginLog();
				
				//会員情報がない場合
				if(member == null){
					System.out.print("到達1");
					fowardError(request,resp);
					return;
				}
				System.out.print("到達2");
				try{
					//データベースにデータを挿入するクラスのインスタンスを生成
					EntlyMemberDao dao =  new EntlyMemberDao();
					//システムエラーが起きた時にエラー情報を保持するクラスのインスタンスを生成
					SystemError system = new SystemError();
					//メールアドレスが既にとうろくされているか？
					if(dao.getMail(member.getMail1()) != null){
						//登録されていた時にシステムエラー画面へ遷移
						system.setMailError("既にメールアドレスが使用されさています。別のメールアドレスを使用してください。");
						//エラーメッセージをセッションに保持
						SessionSet(request,system);
						System.out.println("meail tooooooooo");
						RequestDispatcher rd = request.getRequestDispatcher("view/systemerror.jsp");
						rd.forward(request, resp);
						return;
					}
					//会員登録する処理
					int err = dao.setMember(member);
					//登録できなかった場合の処理
					if (err == 0){
						//システムエラー画面へ遷移
						System.out.println("meail toooooooooqqqqqqqqqqqqqqqquit");
						system.setSystemError("システムに問題が発生しました。管理者に連絡してください。");
						SessionSetSystem(request,system);
						RequestDispatcher rd = request.getRequestDispatcher("view/systemerror.jsp");
						rd.forward(request, resp);
						return;
					}
					logininfo.setLoginlog(member);
					//会員登録完了画面へ遷移
					RequestDispatcher rd = request.getRequestDispatcher("view/CompletionOfRegistration.jsp");
					rd.forward(request, resp);
					
					
				} catch (SQLException e){
					System.out.print(e);
				} catch (DBConnectException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} finally{
					//会員情報のセッションを削除する
					removeSessionMember(request);
				}
			}
		}catch(Exception e){
			
		}
	}
	
	
	
	//会員情報のセッションの取得
	private MemberDTO getMemberINFOform(HttpServletRequest request){
		MemberDTO memberinfo = null;
		//session　get
		HttpSession session = request.getSession(false);
		if( session != null){
			memberinfo =
					(MemberDTO)session.getAttribute(SessionConst.SESSION_MEMBER_INFO);
		}
		return memberinfo;
		
	}
	/*
	 * 会員情報がない場合。
	 * エラーメッセージをセッションに保持
	 *
	 * 
	 */
	private void fowardError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, BookStoreSystemErrorException{
		//error message set
		String errMsg = MessageProperty.getInstance().getErrorMsgFromErrCode(CodeError.ERROR_SESSION_INVLIDATE);
		request.setAttribute(RequestConst.LOGIN_ERR_MSG,errMsg);
		
		//forward 
		RequestDispatcher rd = request.getRequestDispatcher("view/confirmmember.jsp");
		rd.forward(request, response);
	}
	
	
	//メールアドレスが既に登録されていた場合にエラーメッセージをセッションに保持
	private void SessionSet(HttpServletRequest request, SystemError syserror){
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();

		}
		session = request.getSession(true);
		//ログイン時と似てる処理
		session.setAttribute(SessionConst.SESSION_MAEIL_MERROR_INFO,syserror);
	}
	
	
	//データベースにINSERTをしようとしたらシステムエラーが起きた場合にセッションにエラーメッセージを保持
	private void SessionSetSystem(HttpServletRequest request, SystemError syserror){
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();

		}
		session = request.getSession(true);
		//ログイン時と似てる処理
		session.setAttribute(SessionConst.SESSION_SYSTEM_MERROR_INFO,syserror);
	}
	
	//会員情報を削除する
	private void removeSessionMember(HttpServletRequest request){
		MemberDTO memberinfo = null;
		
		//セッション取得
		HttpSession session = request.getSession(false);
		if( session != null ){
			session.removeAttribute(SessionConst.SESSION_MEMBER_INFO);
		}
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
		
		System.out.println("1");
		System.out.println("@"+session.getAttribute(SessionConst.SESSION_MEMBER_TOKEN2)+ "@");
		
		//サーバー側から送られてきたトークンがnullではないか判定
		if( session.getAttribute(SessionConst.SESSION_MEMBER_TOKEN2) == null ){
			return false;
		}
		//クライアント側から送られてきたトークン取得
		String clientToken = (String)request.getParameter("Member_CSRFToken");
		
		if(clientToken == null){
			System.out.println("book");
		}
		try {
			
			//トークンをデコードする
			clientToken = URLDecoder.decode(clientToken,"UTF-8");
			System.out.println("OK");
			
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		System.out.println("2");
		System.out.println("@"+clientToken+"@");
		
		//サーバー側から送られてきたトークンを取得
		String serverToken = (String)session.getAttribute(SessionConst.SESSION_MEMBER_TOKEN2);
		
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
		System.out.println(msg);
		if(clientToken != null && !"".equals(clientToken)){
			
			if(serverToken.equals(clientToken)){
				System.out.println("トークンチェックOK");
				//session.removeAttribute(SessionConst.SESSION_MEMBER_TOKEN2);
				return true;
			}
		}
		return false;
	}
	
	
	

}
