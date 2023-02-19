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
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login post");
		
		//1 
		MemberVo vo = new MemberVo(); //vo 그릇에 담기
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		//String id = request.getParameter("id");
		//String passwd = request.getParameter("passwd");
		
		//2 DB 다녀오기
		MemberVo result = new MemberService().login(vo);
		if(result != null) {//로그인 성공
			System.out.println("로그인성공");
			request.getSession().setAttribute("userId", request.getParameter("id"));
			request.getSession().setAttribute("lgnss", result);
		}else {// null이면 로그인 실패
			System.out.println("로그인실패");
		}
		
		//3 페이지 이동 및 데이터전달
		// 마지막 줄에는 무조건 3-1 response.sendRedirect(request.getContextPath()+"url");
		// 데이터 전달할거면 3-2 request.setAttribute("name1", "값1");
		//  3-2 request.getRequestDispatcher("xxx.jsp").forward(request, response);
		// 혹은 ajax 방식으로 3-3 out.println(값); out.flush(); out.close();
		// 이 셋 중 하나로 메소드를 꼭 끝내야 함. 생략할 수 없음. 
		response.sendRedirect(request.getContextPath()+"/"); //홈 화면으로 이동
	}
}