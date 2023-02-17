package kh.member.model.vo;
/**
 * document로 만들 수 있는 주석 : javadoc 주석이라고 함. 
 * 
 * @author minseong
 * 0. 첫화면("/") header - 로그인(login Get)/로그아웃(logout Get) 버튼 토글, nav - 내정보보기(myinfo get) 버튼
 * 로그인 화면 - 로그인(login post)/ 회원가입(enroll get)버튼 
 * 1. 회원가입("/enroll") - get enroll.jsp , post 회원가입 DB 다녀와서 / 첫화면으로 이동
 * 회원가입 화면 - 회원가입(enroll post) 버튼
 * 2. 로그인("/login.lo") - Get login.jsp로 forward , post 로그인확인DB 다녀와서 session("lgnss")등록(이름, email, id), 첫 이동
 * 3. 로그아웃("/logout") - Get 세션만료 후 첫 이동 
 * 4. 내 정보 보기("/myinfo") - Get myinfo.jsp
 * 내 정보보기 화면에서 하단에 수정("/infoupdate" get), 탈퇴 버튼
 * 5. 내 정보 수정하기("/infoupdate") 
 * 내 정보보가 수정 화면에서 (infoupdate post)
 * 흐름을 알 수 있게 그림으로 그려놓는 것도 괜찮아(화면설계서)
 */
public class MemberVo {
	//Entity에 가깝게 만든다. 
//  desc test_member;
//	------ -------- ------------ 
//	ID     NOT NULL VARCHAR2(15) 
//	PASSWD NOT NULL VARCHAR2(15) 
//	NAME   NOT NULL VARCHAR2(20) 
//	EMAIL           VARCHAR2(30) 
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
