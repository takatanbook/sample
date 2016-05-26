package jp.ac.asojuku.bookstore.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderResponseServlet extends HttpServlet{

	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String header = req.getHeader("X-Forwarded-For");
		//To Do調べたいヘッダーをDIする。
		resp.setContentType("text/plain");
		resp.setHeader("Cache-Control", "no-chache");
		PrintWriter out = resp.getWriter();
		out.write(header);
		System.out.println(header);

		
	}
	

}
