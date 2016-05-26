package jp.ac.asojuku.bookstore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExFilterServlet implements Filter {
	public void init(FilterConfig conf) throws ServletException {}

	  //doFilterメソッドにフィルタ処理を記載します。
	  public void doFilter(ServletRequest req, 
	              ServletResponse res, FilterChain chain) 
	              throws ServletException, IOException {
		Logger logger = LoggerFactory.getLogger(ExFilterServlet.class);
		
	    //getRequestURLメソッドでアクセスがあったURLを表示します。
		logger.info(((HttpServletRequest) req).getRequestURL() + 
	                      "：" + new java.util.Date());
	    /*System.out.println(((HttpServletRequest) req).getRequestURL() + 
	    *                  "：" + new java.util.Date());
	    */
	    /**
	     * doFilterメソッドで、連続するフィルタがある場合は、次のフィ
	     * ルタを呼び出します。連続するフィルタがない場合は、元々要求
	     * されていたプログラムを呼び出します。
	     * 
	     */
	    
	    chain.doFilter(req, res);

	  }

	  public void destroy() {}

	

}
