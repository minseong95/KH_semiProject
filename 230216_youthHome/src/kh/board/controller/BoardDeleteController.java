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
		if(session.getAttribute("lgnss") != null) {
		
		BoardVo vo = new BoardVo();
		int id = Integer.parseInt(request.getParameter("id"));
		
		boolean result = new BoardService().delete(vo,id);
		if(result) {
		response.sendRedirect(request.getContextPath()+"/board");
	} else {
		System.out.println("삭제 실패");
	}
	}
	else {System.out.println("로그인해라");
	response.sendRedirect(request.getContextPath()+"/login");
}
		
	}
}
