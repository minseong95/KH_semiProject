package kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVo;

/**
 * Servlet implementation class EnrollController
 */
@WebServlet("/enroll") //회원가입
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/enroll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//request.setCharacterEncoding("UTF-8");//한글 인코딩 //필터 처리했으니까 지워도 됨
			//1. 전달받은 데이터 읽어 변수에 담기
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd"); //변수이름은 최대한 vo에 지어놓은 이름과 동일하게 하는게 좋음-> 자동완성 개이득
			String name = request.getParameter("name"); //jsp의 form 양식에 있는 name도 마찬가지
			String email = request.getParameter("email");
			MemberVo vo = new MemberVo();
			vo.setEmail(email);
			vo.setId(id);
			vo.setName(name);
			vo.setPasswd(passwd);
			System.out.println("Ctrl param : " + vo);
			//2. DB *여기서부턴 순서를 잘 지키는 것이 중요
			int result = new MemberService().enroll(vo);
			
			if(result < 1) {
				System.out.println("회원가입 실패");
				request.setAttribute("msg","회원가입에 실패했습니다. 다시 시도해주세요." );
				request.getRequestDispatcher("/WEB-INF/msgAlert.jsp").forward(request,response);
			} else {
				System.out.println("회원가입 성공");
				response.sendRedirect(request.getContextPath()+"/"); //이렇게 해야 성공하면 홈으로 간다
			}
	 
		}
	}

