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
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("id", id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String userId = (String)session.getAttribute("userId");
		String originalUser= new BoardService().deleteChkUser(id);
		
		
		if(session.getAttribute("lgnss") != null && userId.equals(originalUser)) {
		
		BoardVo vo = new BoardVo();
		
		boolean result = new BoardService().delete(vo,id);
		if(result) {
		response.sendRedirect(request.getContextPath()+"/board");
	} 
//		else {
//		System.out.println("삭제 실패");
//	}
		}else {
			request.setAttribute("msg","해당 글에 대한 접근 권한이 없습니다. " );
			request.getRequestDispatcher("/WEB-INF/msgAlert_board.jsp").forward(request,response);
}
		
	}
}
