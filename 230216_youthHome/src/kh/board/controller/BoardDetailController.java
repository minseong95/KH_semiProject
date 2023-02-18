package kh.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.board.model.service.BoardService;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/boardDetail")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
			//상세 게시글 가기 위한..
			int id = Integer.parseInt(request.getParameter("id"));
	
			request.setAttribute("id", id);
			request.setAttribute("detail", new BoardService().boardDetail(id)); //이걸 넘겨서 jsp에서 사용..아닌가
			//System.out.println(new BoardService().boardDetail(id));//확인용
			request.getRequestDispatcher("WEB-INF/view/board/boardDetail.jsp").forward(request, response);
	
            return;
 }
}
