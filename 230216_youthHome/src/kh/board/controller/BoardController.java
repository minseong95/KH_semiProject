package kh.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kh.board.model.service.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board")
public class BoardController extends HttpServlet { //게시판컨트롤러
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		if(!session.getAttribute("lgnss").equals("result")) {
//			response.sendRedirect(request.getContextPath()+"/login");
//		} 로그인해야 게시판으로 들어가게 하고 싶은데..
//		
		HttpSession session = request.getSession();
		if(session.getAttribute("lgnss") != null) { //이렇게 해야 되는구만
			//이걸 필터로 적용이 안되나??필터파일에서 왜 겟세션 임포트가 안되지..
		
		//페이징
		String pageNumber = request.getParameter("p");//pNum은 사용자가 요청한 현재페이지..
		int pNum;
		if(pageNumber == null || pageNumber.isEmpty()) {
			pNum = 1;
		}else {
			pNum = Integer.parseInt(pageNumber);
		}
		
		//이 pNum을 여태 만든 메서드들에게 인자로 넘겨줘야 해.. 
		request.setAttribute("selectList",new BoardService().selectPage(pNum));
		request.setAttribute("board", new BoardService().boardShow());//아 이건 지워도됨 페이지처리때문에.. 
		
		List<Integer>pageList = new BoardService().getPageList();
		//int lastPageNumber = new BoardService().getLastPageNumber(); 존나 모르겠음..ㅜㅜ
		request.setAttribute("pageList", pageList);
		

		request.getRequestDispatcher("WEB-INF/view/board/board.jsp").forward(request, response);
	
		} else {
		System.out.println("로그인해라");
		response.sendRedirect(request.getContextPath()+"/login");
	}

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
