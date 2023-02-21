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
		
		//옵션 선택에 따른 글목록 개수
		Cookie cookie = null;
		Cookie[] cookies = request.getCookies(); // 쿠키를 찾아야 한다..
		for(Cookie c : cookies) {
			if(c.getName().equals("cnt")) {
				cookie = c; // 쿠키를 찾아서 저장하고 브라우저에서 보낸다..
			}
		}
		
		String cnt = request.getParameter("cnt"); //파라미터가 있어도 이게 비워져있는지 아닌지 확인해야 함.
		System.out.println("getParameter로 cnt 가져온거..: "+cnt); //왜 null로 뜨지..
		if( cnt!= null ) { 
			if(cnt.isEmpty()) { //파라미터는 있는데 값은 없는 경우..
				if(cookie != null) {
					cnt = cookie.getValue(); // 쿠키가 있다는 가정하에 쿠키로 초기화..
				}else {
					cnt ="5"; //쿠키가 없으면 5로 초기화하자.. 
				}
			} //아 괄호 잘 확인할 것 여기다 괄호 안넣었고
			} else {
				if(cookie != null) { // 쿠키가 있다!!
					cnt = cookie.getValue(); //그럼 쿠키값 넣어주고
				} else {
				cnt = "5"; //없으면 임의로 5 주자.. 
				}
			 }	
			//여기다 괄호 넣어서 cnt가 null으로 뜨더라.. 
		
		cookie = new Cookie("cnt", cnt);
		cookie.setMaxAge(60*60*24*5); //5일동안 유지하겠어.. 
		response.addCookie(cookie); //응답할 때 같이 전달할라거..
		
		request.setAttribute("cnt", cnt);
		System.out.println("쿠키 작업하고나서cnt 값은...? : " +cnt);
		
		//이 pNum을 여태 만든 메서드들에게 인자로 넘겨줘야 해.. + cnt도 넘겨주기
		request.setAttribute("selectList",new BoardService().selectPage(pNum, Integer.parseInt(cnt)));
		//request.setAttribute("board", new BoardService().boardShow());//아 이건 지워도됨 페이지처리때문에.. 
		
		List<Integer>pageList = new BoardService().getPageList(Integer.parseInt(cnt)); //겟파라미터로 받은건 string이니까 형변환.. 
		int lastPageNumber = new BoardService().getLastPageNumber(Integer.parseInt(cnt)); 
		request.setAttribute("pageList", pageList);
		request.setAttribute("lastPageNumber", lastPageNumber);
		
//		//조회수 올리기.. 왜 아이디가 null값으로 나오는지..?
//		int id = Integer.parseInt(request.getParameter("id"));
//		int readCnt = new BoardService().readCount(id); //여기서 아이디가 글 번호..
//		request.setAttribute("readCnt", readCnt);

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
