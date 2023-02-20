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
	public BoardVo boardDetail(int id) {
		BoardVo vo = null;
		Connection conn = getConnection();
		vo = new BoardDao().boardDetail(conn, id);
		return vo;
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
	
	//그거 >>next 하고싶어서.. 
	public int getLastPageNumber() {
		   BoardDao dao = new BoardDao();
		   Connection conn = getConnection();
		   int totalRowCount = dao.selectTotalRowCount(conn);
		   int mod = (totalRowCount % 5 ) == 0 ? 0 : 1; //여기 5도 임의로 정한 상태
		   int pageCount = (totalRowCount / 5) + mod;
		   return pageCount;
	}
	
	
	//글 작성해서 등록하기.. 아 안되네.. 
	public boolean write(BoardVo vo, String userId){
		int result = -1;
		Connection conn = getConnection();
		result = new BoardDao().write(conn, vo, userId);
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
	//글 수정하기
	public boolean update(BoardVo vo, int id){
		int result = -1;
		Connection conn = getConnection();
		result = new BoardDao().update(conn, vo, id);
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
	
	//글 삭제하기
	public boolean delete(BoardVo vo, int id){
		int result = -1;
		Connection conn = getConnection();
		result = new BoardDao().delete(conn, vo, id);
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
	
	
	//글삭할때 그 글 주인인지 확인하고싶음..
	public String deleteChkUser(int id) {
		String originalUser = null;
		Connection conn = getConnection();
		originalUser = new BoardDao().deleteChkUser(conn,id);
		close(conn);
		return originalUser;
	
	}
	
	//조회수 올리기
	public int readCount(int id) {
		int readCnt = -1;
		Connection conn = getConnection();
		readCnt = new BoardDao().readCount(conn,id);
		close(conn);
		return readCnt;
}
}