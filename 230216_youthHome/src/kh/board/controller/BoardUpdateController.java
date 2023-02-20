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
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update") // 글 수정하기..
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String context = request.getParameter("context");
		String subject = request.getParameter("subject");
		
//		request.setAttribute("context", context);
//		request.setAttribute("subject", subject); //음.. placeholder처럼 하고싶었는데.. 
		
		request.setAttribute("id", id);
		
		request.getRequestDispatcher("WEB-INF/view/board/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVo vo = new BoardVo();
		int id = Integer.parseInt(request.getParameter("id"));
		String context = request.getParameter("context");
		String subject = request.getParameter("subject");
		
		//그 작성자인지 확인..delete에서 했던거 복붙함
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String originalUser= new BoardService().deleteChkUser(id);
		
		if(session.getAttribute("lgnss") != null && userId.equals(originalUser)) {
		//
		vo.setContext(context);
		vo.setSubject(subject);
		
		boolean result = new BoardService().update(vo,id);
		if(result) {
		response.sendRedirect(request.getContextPath()+"/boardDetail?id="+id); //근데 이게 맞나
	} 
		}
		else {
			request.setAttribute("msg","해당 글에 대한 접근 권한이 없습니다. " );
			request.getRequestDispatcher("/WEB-INF/msgAlert_board.jsp").forward(request,response);
		//System.out.println("등록 실패");
	}

	}
}