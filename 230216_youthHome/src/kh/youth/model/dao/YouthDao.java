package kh.youth.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static kh.common.jdbc.JDBCTemplate.*;

import kh.board.model.vo.BoardVo;
import kh.youth.model.vo.YouthVo;

public class YouthDao {
	// 공고 내역 다 보여주기
	public ArrayList<YouthVo> announceList(Connection conn){
		ArrayList<YouthVo> list = new ArrayList<YouthVo>();
		String sql = "select idx, division, annName, annDate, applyDate, manager from ann_table";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
				try {
					pstmt= conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						YouthVo vo = new YouthVo();
						vo.setAnnDate(rs.getDate("annDate"));
						vo.setAnnName(rs.getString("annName"));
						vo.setApplyDate(rs.getDate("applyDate"));
						vo.setDivision(rs.getString("division"));
						vo.setIdx(rs.getInt("idx"));
						vo.setManager(rs.getString("manager"));
						list.add(vo);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(rs);
				}
				
		return list;
	}
	
	//페이지 목록 옵션에 따른.. 
		public ArrayList<YouthVo> selectPage(Connection conn, int pNum){
			ArrayList<YouthVo> selectList = new ArrayList<YouthVo>();
			String sql = "select idx, division, annName, annDate, applyDate, manager "; 
			       sql += " FROM (select * from ann_table order by idx) ";
			       sql += " WHERE idx BETWEEN ? AND ?";
	        PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,(pNum-1)*5 +1); //임의로 5개 목록 수... 
				pstmt.setInt(2, pNum*5); //여기서 5이 옵션으로 선택한다는 건데..
				rs = pstmt.executeQuery(); //셀렉트니까.. 
				
				while(rs.next()) {
					YouthVo vo = new YouthVo();
					vo.setAnnDate(rs.getDate("annDate"));
					vo.setAnnName(rs.getString("annName"));
					vo.setApplyDate(rs.getDate("applyDate"));
					vo.setDivision(rs.getString("division"));
					vo.setIdx(rs.getInt("idx"));
					vo.setManager(rs.getString("manager"));
					selectList.add(vo);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			
			       
			return selectList;
		}
		
		//그 하단에 페이징 구현할 차례..졸려죽겟다
		public int selectTotalRowCount(Connection conn) {
			int count = 0;
			String sql ="SELECT COUNT(*) FROM ann_table";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}	
				
			return count;
		}
}
