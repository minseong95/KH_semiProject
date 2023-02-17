package kh.board.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.board.model.dao.BoardDao;
import kh.board.model.vo.BoardVo;
import static kh.common.jdbc.JDBCTemplate.*;

public class BoardService {
	public ArrayList<BoardVo> boardShow() {
		ArrayList<BoardVo> list = null;
		Connection conn = getConnection();
		list = new BoardDao().boardShow(conn);
		return list;
	}
	
	
	//게시글 하나 보기
	public ArrayList<BoardVo> boardDetail(int id) {
		ArrayList<BoardVo> list = null;
		Connection conn = getConnection();
		list = new BoardDao().boardDetail(conn, id);
		return list;
	}
	
	//페이지 옵션 선택에 따른..
	public ArrayList<BoardVo> selectPage(int pNum){
		ArrayList<BoardVo> selectList = null;
		Connection conn = getConnection();
		selectList = new BoardDao().selectPage(conn, pNum);
		return selectList;
	}
	
	//그 하단에 페이징 구현할 차례..졸려죽겟다
	public List<Integer> getPageList(){
		   BoardDao dao = new BoardDao();
		   Connection conn = getConnection();
		   int totalRowCount = dao.selectTotalRowCount(conn);
		   int mod = (totalRowCount % 5 ) == 0 ? 0 : 1; //여기 5도 임의로 정한 상태
		   int pageCount = (totalRowCount / 5) + mod;
		   
		   List<Integer> pageList = new ArrayList<Integer>();
		   for(int i = 1; i<=pageCount; i++){
		       pageList.add(i);
		      }
		      return pageList;
		   }
	
	
	//글 작성해서 등록하기.. 아 안되네.. 
	public boolean write(BoardVo vo){
		int result = -1;
		Connection conn = getConnection();
		result = new BoardDao().write(conn, vo);
		if(result ==1) {
			return true;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
 }
}
