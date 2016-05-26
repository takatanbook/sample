package jp.ac.asojuku.bookstore.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.asojuku.bookstore.check.CheckSecurity;
import jp.ac.asojuku.bookstore.check.RdioCheck;

public class BookResearchAction extends BaseServlet{

	/* (非 Javadoc)
	 * @author tanaka
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGetMain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		doPostMain(req,resp);
	}

	/* (非 Javadoc)
	 * @author tanaka
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPostMain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> errList = new ArrayList<String>();
		String err= "";
		//検索フォームの内容を変数に代入
		String bookname = req.getParameter("booksearch");
		//入力値を検査
		if(CheckSecurity.isEmpty(bookname) == false){
			err = "入力されていません。";
		}else if(RdioCheck.Check4(bookname) == false){
			err = "あ行からワ行で入力してください。";
		} else if(bookname.length() != 1){
			err = "一文字で入力してください。";
		}
		errList.add(err);
		if(errList != null && errList.size() != 0){
			RequestDispatcher rd = req.getRequestDispatcher("view/systemerror.jsp");
			rd.forward(req, resp);
			return;
		}
		
		
		
	}
	
	
	

}
