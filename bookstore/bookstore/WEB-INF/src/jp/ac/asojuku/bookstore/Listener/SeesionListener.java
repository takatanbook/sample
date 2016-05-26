package jp.ac.asojuku.bookstore.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SeesionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//セッションが生成された時に行う処理
		System.out.println("create session");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//セッションが破棄された時に行う処理
		  
		//セッションを取得
		System.out.println("destoyed session");
		//ログアウト処理などのビジネスロジックを記載
	}

}
