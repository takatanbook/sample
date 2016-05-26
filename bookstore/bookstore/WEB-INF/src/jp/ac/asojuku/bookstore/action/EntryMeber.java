package jp.ac.asojuku.bookstore.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.asojuku.bookstore.check.MemberCheck;
import jp.ac.asojuku.bookstore.dto.MemberDTO;
import jp.ac.asojuku.bookstore.error.CodeError;
import jp.ac.asojuku.bookstore.error.ErrorsAction;
import jp.ac.asojuku.bookstore.exception.BookStoreSystemErrorException;
import jp.ac.asojuku.bookstore.param.RequestConst;
import jp.ac.asojuku.bookstore.param.SessionConst;
import jp.ac.asojuku.bookstore.security.SecutityUtil;
import sun.misc.BASE64Encoder;
public class EntryMeber extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	private static final int BYTE_LEN = 256;
	/** 乱数生成アルゴリズム */
	private static final String ALG = "SHA1PRNG";

    public EntryMeber() {
        super();
    }
	/* 会員登録の処理（入力チェック）
	 * (非 Javadoc)
	 * @author tanaka
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPostMain(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,BookStoreSystemErrorException {
		// TODO 自動生成されたメソッド・スタブ
		//HttpSession session = request.getSession(false);
		//String MemberToken1 = "";
		//MemberToken1 = (String)session.getAttribute("MemberToken1");
		
		try{
			
		
			if(checkToken(request)){
				
				HttpSession se = request.getSession(false);
				//token再生成用のセッション変数
				HttpSession session = request.getSession(true);
				//セッションからトークンを取得
				String namae = (String)se.getAttribute("MemberToken1");
				//System.out.println(namae +"llllllllllll");
				MemberDTO member = getMemerDTOform(request);
				//System.out.print(member.getPrefecture());
				//System.out.print(member.getAddres1());
				ErrorsAction errs = MemberCheck(member, request);
				
				if(errs.isHasErr()){
					//トークンセッションの再生成
					session.setAttribute(SessionConst.SESSION_MEMBER_TOKEN1, getToken());
					Errorjump(request,response,errs,member);
				} else{
					//se.removeAttribute(SessionConst.SESSION_MEMBER_TOKEN1);
					//session情報保持
					SessionSet(request,member);
					//会員入力確認画面
					Confirmation(request,response,member);
				}
			}else{
				
					//System.out.println("kk");
					//不正なアクセスがある場合にシステムエラーペースに遷移
					RequestDispatcher rd = request.getRequestDispatcher("view/systemerror.jsp");
					rd.forward(request, response);
			}
			
		} catch (Exception e){
			
		}
	}


	/*登録画面で入力された情報をDTOに保持
	 * return member
	 * requst
	 * */
	private MemberDTO getMemerDTOform(HttpServletRequest request){
		MemberDTO member = new MemberDTO();
		member.setName_sei(request.getParameter("name1"));
		member.setName_mei(request.getParameter("name2"));
		member.setName_hurigana_sei(request.getParameter("name3"));
		member.setName_hurigana_mei(request.getParameter("name4"));
		member.setNickname(request.getParameter("nickname"));
		member.setYuubinNo(request.getParameter("yuubinno"));
		member.setPrefecture(request.getParameter("pref"));
		member.setAddres1(request.getParameter("addr1"));
		member.setAddres2(request.getParameter("addr2"));
		member.setTel1(request.getParameter("tel1"));
		member.setTel2(request.getParameter("tel2"));
		member.setTel3(request.getParameter("tel3"));
		member.setMail1(request.getParameter("email"));
		member.setMail2(request.getParameter("email2"));
		member.setSex(request.getParameter("sex"));
		return member;
	}
	
	/*登録画面から入力された情報を判定処理
	 *return errs ・リストです。
	 * 
	 * */
	private ErrorsAction MemberCheck(MemberDTO member,HttpServletRequest request) throws BookStoreSystemErrorException{
		ErrorsAction errs = new ErrorsAction();
		CodeError Errcode;
		//名前の姓のチャックする
		Errcode = MemberCheck.CheckNameSei(member.getName_mei());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//名前の名をチャックする
		Errcode = MemberCheck.CheckNameMei(member.getName_mei());
		if ( Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//名前の姓のふりがなをチャックする
		Errcode = MemberCheck.CheckNameHuriganaSei(member.getName_hurigana_sei());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//名前の名のふりがなをチャックする
		Errcode = MemberCheck.CheckNameHuriganaMei(member.getName_hurigana_mei());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//ニックネームをチェックする
		Errcode = MemberCheck.CheckNickname(member.getNickname());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//郵便番号をチャックする
		Errcode = MemberCheck.CheckPostnumber(member.getYuubinNo());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//都道府県のチャックする
		Errcode = MemberCheck.CheckPrefecture(member.getPrefecture());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//会員の市町村をチャックする
		Errcode = MemberCheck.CheckADDRES1(member.getAddres1());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//会員の番地やマンション名または建物名チェックする
		Errcode = MemberCheck.CheckADDRES2(member.getAddres2());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//電話番号をチェックする
		Errcode = MemberCheck.CheckNomber(member.getTel1(), member.getTel2(), member.getTel3());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//メールアドレスをチェックする
		Errcode = MemberCheck.CheckMail(member.getMail1(), member.getMail2());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		//パスワードをチェックする
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		Errcode = MemberCheck.CheckPassword(password, password2);
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		if (Errcode == Errcode.SUCCESS ){
			//パスワードをハッシュ化（仕組みは、パスワードとメールアドレスを結合して暗号化）
			String pass = password + member.getMail1();
			//ハッシュ化したものをDTOに保持（本当は、やらないほうが良い）
			member.setHashpassword(SecutityUtil.ecryptStr(pass));
		}
		//性別をチェックする
		Errcode = MemberCheck.CheckSex(member.getSex());
		if (Errcode != Errcode.SUCCESS){
			errs.add(Errcode);
		}
		
		return errs;


	}
	//会員情報をセッションに保持
	private void SessionSet(HttpServletRequest request,MemberDTO member){
		//セッションの設定
		HttpSession session = request.getSession(true);
		//会員情報をセッションセッティング
		session.setAttribute(SessionConst.SESSION_MEMBER_INFO, member);
	}
	private void Errorjump(HttpServletRequest request, HttpServletResponse response,ErrorsAction errs,MemberDTO member) throws ServletException, IOException{
		//会員情報を保持
		request.setAttribute(RequestConst.REQUEST_MEMBER_INFO,member );
		//エラー情報を保持
		request.setAttribute(RequestConst.REQUEST_ERRORS,errs );
		
		//再入力画面へ
		RequestDispatcher rd = request.getRequestDispatcher("view/NewMember.jsp");
		rd.forward(request, response);
	}
	private void Confirmation(HttpServletRequest request, HttpServletResponse response,MemberDTO member) throws ServletException, IOException{
		
		//会員情報を保持
		request.setAttribute(RequestConst.REQUEST_MEMBER_INFO,member );
		//token2 生成
		HttpSession session = request.getSession(true);
		session.setAttribute(SessionConst.SESSION_MEMBER_TOKEN2, getToken());
		//確認画面へ遷移する
		RequestDispatcher rd = request.getRequestDispatcher("view/confirmmember.jsp");
		rd.forward(request, response);
	}
	/**
	 * トークンが正しいかどうか確認
	 * @param request
	 * @return
	 */
	private boolean checkToken(HttpServletRequest request){
		//System.out.println("sss");
		
		//セッションの取得
		HttpSession session = request.getSession(false);
		
		//System.out.println("1");
		//System.out.println("@"+session.getAttribute(SessionConst.SESSION_MEMBER_TOKEN1)+ "@");
		
		//サーバー側から送られてきたトークンがnullではないか判定
		if( session.getAttribute("MemberToken1") == null ){
			return false;
		}
		//クライアント側から送られてきたトークン取得
		String clientToken = (String)request.getParameter("Member_CSRFToken");
		
		if(clientToken == null){
			//System.out.println("book");
			return false;
		}
		try {
			
			//トークンをデコードする
			clientToken = URLDecoder.decode(clientToken,"UTF-8");
			//System.out.println("OK");
			
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//System.out.println("2");
		//System.out.println("@"+clientToken+"@");
		
		//サーバー側から送られてきたトークンを取得
		String serverToken = (String)session.getAttribute(SessionConst.SESSION_MEMBER_TOKEN1);
		
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
				//tokenセッションを削除する
				session.removeAttribute(SessionConst.SESSION_MEMBER_TOKEN1);
				return true;
			}
		}
		return false;
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
