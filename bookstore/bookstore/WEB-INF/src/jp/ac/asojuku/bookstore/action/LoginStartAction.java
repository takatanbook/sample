package jp.ac.asojuku.bookstore.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.asojuku.bookstore.param.SessionConst;
import sun.misc.BASE64Encoder;

public class LoginStartAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final int BYTE_LEN = 256;
	/** 乱数生成アルゴリズム */
	private static final String ALG = "SHA1PRNG";

    public LoginStartAction() {
        super();
    }

	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession(true);
		//トークンをセッションで管理
		session.setAttribute(SessionConst.SESSION_LOGUIN_TOKEN1, getToken());
		//String CSRF =(String)session.getAttribute("CSRFToken");
		//request.setAttribute("Pegecsrf", CSRF);
		//System.out.println("FAST"+session.getAttribute("CSRFToken"));
		
		RequestDispatcher rd = request.getRequestDispatcher("view/login.jsp");
		rd.forward(request, response);
	}
	
	/*protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("view/login.jsp");
		// TODO 自動生成されたメソッド・スタブ
		rd.forward(req, resp);
	}*/
	/**
	 * トークン生成
	 * @return
	 *Java の 暗号論的擬似乱数生成器 で乱数を作成できるクラスは、
	 *java.security.SecureRandom クラスになります。
	 *(暗号論的に安全な疑似乱数生成器、CSPRNG）とは、暗号技術での利用に適した特性を持つ擬似乱数生成器 (PRNG) である。
	 *
	 *
	 *疑似乱数は、ある一定の計算式で出てくる値なので、
	 *全く同じ計算をすれば出てくる数字は毎回同じパターンになります。
     *seedと言うのは、このパターンを変えるためのものです。
     *ゲーム等、毎回異なる乱数パターンが必要な場合は、タイムスタンプやチックタイムなど、
     *毎回変わる値をseedにすることで、乱数のパターンが固定化されないようにするのが一般的ですね。
	 */
	public String getToken(){
		SecureRandom random;
		byte[] buf = new byte[BYTE_LEN];
		
		try {
			//getInstance の呼び出しによって SecureRandom を取得したあと
			//指定された乱数ジェネレータ (RNG) アルゴリズムを実装した SecureRandom オブジェクトを返します。
			random = SecureRandom.getInstance(ALG);
			//指定されたバイト数のシードバイトを返します。
			byte[] seed = random.generateSeed(BYTE_LEN);
			// 指定された long seed に含まれている 8 バイトを使用して、この乱数オブジェクトを再シードします。
			random.setSeed(seed);
			//ユーザーが指定したバイト数の乱数バイト数を生成します。
			//nextBytes を呼び出して乱数バイトを生成できます。
			random.nextBytes(buf);
		} catch (NoSuchAlgorithmException e) {
			log(e.getLocalizedMessage(), e);
		}

		//BASE64エンコードしてトークンを生成
		String token = (new BASE64Encoder()).encodeBuffer(buf);
		return token;
	}
}
