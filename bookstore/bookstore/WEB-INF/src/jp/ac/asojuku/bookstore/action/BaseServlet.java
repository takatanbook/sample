package jp.ac.asojuku.bookstore.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.ac.asojuku.bookstore.exception.BookStoreSystemErrorException;

public abstract class BaseServlet extends HttpServlet{
	
	/* (非 Javadoc)
	 * @author tanaka
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			doGetMain(req,resp);
		} catch (BookStoreSystemErrorException e) {
			fowardSystemError(req,resp,e);
		}
	}
	
	/* (非 Javadoc)
	 * @author tanaka
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			doPostMain(req,resp);
		} catch (BookStoreSystemErrorException e) {
			fowardSystemError(req,resp,e);
		}
	}
	
	/**
	 * システムエラー画面を表示する
	 * @author tanaka
	 * @param req
	 * @param resp
	 * @param e
	 * @throws ServletException
	 * @throws IOException
	 */
	private void fowardSystemError(HttpServletRequest req,HttpServletResponse resp,BookStoreSystemErrorException e) throws ServletException, IOException{
	
		Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
		logger.error("システムエラーが発生しました:",e);
		RequestDispatcher rd = req.getRequestDispatcher("view/systemerror.jsp");
		rd.forward(req, resp);
	}
	
	
	protected void doGetMain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,BookStoreSystemErrorException
	{
		//TODO:405エラーチック名画面へ遷移
		
	}
	
	protected void doPostMain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,BookStoreSystemErrorException
	{
		//TODO:405エラーチック名画面へ遷移
	
	}
	
}