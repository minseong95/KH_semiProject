package kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.board.model.vo.BoardVo;
import static kh.common.jdbc.JDBCTemplate.*;

public class BoardDao {
	//게시판 글 다 긁어오기
	public ArrayList<BoardVo> boardShow(Connection conn) { //리스트에 담기
		//BoardVo result = null;
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		String sql ="SELECT idx, writer, subject, createdate, view_cnt FROM BOARD_TABLE";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //ResultSet에 다 담기
			
			while(rs.next()) {
//				result = new BoardVo();
//				result.setIdx(rs.getInt("idx"));
//				result.setWriter(rs.getString("writer"));
//				result.setSubject(rs.getString("subject"));
//				result.setCreatedate(rs.getString("createdate"));
//				result.setView_cnt(rs.getInt("view_cnt"));
				BoardVo vo = new BoardVo();
				vo.setIdx(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setCreatedate(rs.getString(4));
				vo.setView_cnt(rs.getInt(5));
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	
	
	
	//게시글 상세 보기
	public ArrayList<BoardVo> boardDetail(Connection conn, int id ){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		String sql ="SELECT writer, subject, context, createdate ";
		       sql += " FROM BOARD_TABLE WHERE idx=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id); //getIdx를 어떻게 받지...?
			rs = pstmt.executeQuery(); //ResultSet에 다 담기
			
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setWriter(rs.getString(1));
				vo.setSubject(rs.getString(2));
				vo.setContext(rs.getString(3));
				vo.setCreatedate(rs.getString(4));
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	
	
	//페이지 목록 옵션에 따른.. 
	public ArrayList<BoardVo> selectPage(Connection conn, int pNum){
		ArrayList<BoardVo> selectList = new ArrayList<BoardVo>();
		String sql = "SELECT idx, WRITER, SUBJECT, CREATEDATE, view_cnt "; 
		       sql += " FROM (SELECT * FROM BOARD_TABLE ORDER BY idx) ";
		       sql += " WHERE idx BETWEEN ? AND ?";
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,(pNum-1)*5 +1); //임의로 5개 목록 수... 
			pstmt.setInt(2, pNum*5); //여기서 5이 옵션으로 선택한다는 건데..
			rs = pstmt.executeQuery(); //셀렉트니까.. 
			
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setIdx(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setCreatedate(rs.getString(4));
				vo.setView_cnt(rs.getInt(5));
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
		String sql ="SELECT COUNT(*) FROM BOARD_TABLE";
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
	
	
	// 글 작성해서 등록하는 과정.. 
	public int write(Connection conn, BoardVo vo){
		int result = -1; //실패하면 -1로 처리해야하니까
		String sql = "INSERT INTO BOARD_TABLE VALUES";
			   sql +="(?, ?, ?, ?, TO_CHAR(SYSDATE,'YYYY-MM-DD'), 0)";
			   //인서트문이니까..ㄴ
			   PreparedStatement pstmt = null;
			   
			   try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, new BoardDao().getNo(conn));
				pstmt.setString(2, vo.getWriter() ); 
				pstmt.setString(3, vo.getSubject());
				pstmt.setString(4, vo.getContext());
				
				result = pstmt.executeUpdate();
				if(result>0) {
					conn.commit();
				}
			} catch (Exception e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				close(pstmt);
			}
			   return result;
	}
	
	// 최대 게시판 번호 알아내기
		public int getNo(Connection conn) {
			int result = 0;
			String sql = "SELECT NVL(max(IDX), 0) + 1 FROM BOARD_TABLE";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			System.out.println(result);
			return -1;
		}
	
		
		//게시글 수정하기
		public int update(Connection conn, BoardVo vo, int id){
			int result = -1; //실패하면 -1로 처리해야하니까
			String sql = "UPDATE BOARD_TABLE SET";
				   sql +=" subject =?, CONTEXT =? WHERE idx = ?";
				   //인서트문이니까..ㄴ
				   PreparedStatement pstmt = null;
				   
				   try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, vo.getSubject());
					pstmt.setString(2, vo.getContext()); 
					pstmt.setInt(3, id);
					
					
					result = pstmt.executeUpdate();
					if(result>0) {
						conn.commit();
					}
				} catch (Exception e) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} finally {
					close(pstmt);
				}
				   return result;
		}
		
	
}
