package kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;

/**
 * Servlet implementation class DupIdChkController
 */
@WebServlet("/dupid.lo")
public class DupIdChkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupIdChkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mservice = new MemberService();
		 int result = mservice.dupIdChk(request.getParameter("id"));
		 //System.out.println(result); 여기도 1... 
		 PrintWriter out = response.getWriter();
		 
		 if(result == 1) { //위에서 선언한 result를 쓰려면 이렇게 해야되는구만
			 out.append("fail");
		 } else{
			 out.append("ok");//왜 다 사용가능하대???? 아 여기서 ajax로 보내는게 잘못됐는데.. 
		 }
		 out.flush();
		 out.close();
	}


}
