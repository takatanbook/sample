package jp.ac.asojuku.bookstore.action;
import java.io.IOException;
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
import jp.ac.asojuku.bookstore.dto.LoginInfoDTO;
import jp.ac.asojuku.bookstore.exception.DBConnectException;
import jp.ac.asojuku.bookstore.param.SessionConst;

public class LogoutAction extends HttpServlet{

	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		doPost(req, resp);
	}

	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		
		HttpSession session = req.getSession(false);
		LoginInfoDTO member;
		LoginLog logininfo = new LoginLog();
		int num;
		
		DateTime dt = new DateTime(DateTimeZone.forID("Asia/Tokyo"));
		String date = dt.toString(DateTimeFormat.mediumDateTime());
		
		if( session != null ){
			
			member = (LoginInfoDTO)session.getAttribute(SessionConst.SESSION_LOGININFO);
			
			if(member == null){
				System.out.println("member is null");
			}
			
			//String name = (String)member.getMemb_id();
			
			//ログオン情報の削除
			session.removeAttribute(SessionConst.SESSION_LOGININFO);
			
			//セッションの破棄
			session.invalidate();
			//System.out.println(name + "null");
			
			try {
				
				num = logininfo.setLogoutDate(member, date);
				
				
				if(num == 0 ){
					RequestDispatcher rd = req.getRequestDispatcher("view/systemerror.jsp");
					rd.forward(req, resp);
				}
				
			} catch (DBConnectException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
		}


		//トップ画面へ遷移（リダイレクト）
		resp.sendRedirect(req.getContextPath()+"/top");
	}
	
	
}
