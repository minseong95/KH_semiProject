package kh.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kh.board.model.service.BoardService;
import kh.board.model.vo.BoardVo;

/**
 * Servlet implementation class BoardWriteController
 */
@WebServlet("/write") // 글 작성하기
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteController() {
        super();
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		BoardVo vo = new BoardVo();
//		String context = request.getParameter("context");
//		String subject = request.getParameter("subject");
//		vo.setContext(context);
//		vo.setSubject(subject);
//		
//		boolean result = new BoardService().write(vo);
//		
//		if(result) {
//		response.sendRedirect(request.getContextPath()+"/board");
//	} else {
//		System.out.println("등록 실패");
		//request.getRequestDispatcher("WEB-INF/view/fail.jsp").forward(request, response);
	//}
		request.getRequestDispatcher("WEB-INF/view/board/write.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVo vo = new BoardVo();
		String context = request.getParameter("context");
		String subject = request.getParameter("subject");
		vo.setContext(context);
		vo.setSubject(subject);
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		System.out.println(userId); // 될까..?
		
		request.setAttribute("userId", userId);
		
		
		boolean result = new BoardService().write(vo,userId);
		if(result) {
		response.sendRedirect(request.getContextPath()+"/board");
	} else {
		System.out.println("등록 실패");
		//request.getRequestDispatcher("WEB-INF/view/fail.jsp").forward(request, response);
	}
	}
}
