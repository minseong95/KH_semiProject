package kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kh.board.model.vo.BoardVo;
import static kh.common.jdbc.JDBCTemplate.*;

public class BoardDao {
	//게시판 글 다 긁어오기
	public BoardVo boardShow(Connection conn) {
		BoardVo result = null;
		String sql ="SELECT idx, writer, subject, createdate, view_cnt FROM BOARD_TABLE";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //ResultSet에 다 담기
			
			while(rs.next()) {
				result = new BoardVo();
				result.setIdx(rs.getInt("idx"));
				result.setWriter(rs.getString("writer"));
				result.setSubject(rs.getString("subject"));
				result.setCreatedate(rs.getString("createdate"));
				result.setView_cnt(rs.getInt("view_cnt"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
}
