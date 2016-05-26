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

public class MemberRegistrationAction extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final int BYTE_LEN = 256;
	/** 乱数生成アルゴリズム */
	private static final String ALG = "SHA1PRNG";

    public MemberRegistrationAction() {
        super();
    }
	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		doPost(req,resp);
	}

	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		//トークンをセッションで管理
		HttpSession session = req.getSession(true);
		session.setAttribute(SessionConst.SESSION_MEMBER_TOKEN1, getToken());
		RequestDispatcher rd = req.getRequestDispatcher("view/NewMember.jsp");
		rd.forward(req, resp);
		
		
	}
	/**
	 * トークン生成
	 * @return
	 */
	public String getToken(){
		SecureRandom random;
		byte[] buf = new byte[BYTE_LEN];
		
		try {
			
			random = SecureRandom.getInstance(ALG);
			byte[] seed = random.generateSeed(BYTE_LEN);
			random.setSeed(seed);
			
			//乱数バイトを生成
			random.nextBytes(buf);
		} catch (NoSuchAlgorithmException e) {
			log(e.getLocalizedMessage(), e);
		}

		//BASE64エンコードしてトークンを生成
		String token = (new BASE64Encoder()).encodeBuffer(buf);
		return token;
	}
}
