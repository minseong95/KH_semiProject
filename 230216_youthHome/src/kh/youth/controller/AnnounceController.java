package kh.youth.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.board.model.service.BoardService;
import kh.youth.model.service.YouthService;

/**
 * Servlet implementation class AnnounceController
 */
@WebServlet("/annoucne")
public class AnnounceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnounceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징
				String pageNumber = request.getParameter("p");//pNum은 사용자가 요청한 현재페이지..
				int pNum;
				if(pageNumber == null || pageNumber.isEmpty()) {
					pNum = 1;
				}else {
					pNum = Integer.parseInt(pageNumber);
				}
		
				request.setAttribute("selectList",new YouthService().selectPage(pNum));
				List<Integer>pageList = new YouthService().getPageList();
				request.setAttribute("pageList", pageList);
				
				
				
				
		request.getRequestDispatcher("WEB-INF/view/youth/announce.jsp").forward(request, response);
	}


}
