package kh.youth.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import kh.board.model.dao.BoardDao;
import kh.board.model.vo.BoardVo;
import kh.youth.model.dao.YouthDao;
import kh.youth.model.vo.YouthVo;
import static kh.common.jdbc.JDBCTemplate.*;

public class YouthService {
	public ArrayList<YouthVo> announceList(){
		ArrayList<YouthVo> list = null;
		Connection conn = getConnection();
		list = new YouthDao().announceList(conn);
		close(conn);
		return list;
	}
	
	//페이지 옵션 선택에 따른..
		public ArrayList<YouthVo> selectPage(int pNum){
			ArrayList<YouthVo> selectList = null;
			Connection conn = getConnection();
			selectList = new YouthDao().selectPage(conn, pNum);
			return selectList;
		}
		
		//그 하단에 페이징 구현할 차례..졸려죽겟다
		public List<Integer> getPageList(){
			   YouthDao dao = new YouthDao();
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
		
}
