package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kh.member.model.vo.MemberVo;
import static kh.common.jdbc.JDBCTemplate.*;

public class MemberDao {
	//로그인
		public MemberVo login (Connection conn, MemberVo vo) {//MemberVo vo 들고와야지
			MemberVo result = null;
			
			
			String sql = "select ID, NAME, EMAIL from member_table";
			sql += " where ID =? and PASSWD=?";//두줄이라서 분리 작성 //앞에 띄어쓰기 주의해야 하나?
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt= conn.prepareStatement(sql); //conn으로부터 
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPasswd());
				rs = pstmt.executeQuery();    // 지겹다할 때까지 작성할 것
				//where 절에 pk키가 있는걸 ? 에 넣으면 단일행이 나옴 무조건!!!!(id)
				//그래서 반복 안하고 그냥 if 쓰면 됨
				if(rs.next()) {
					result = new MemberVo(); //new 해야 만들 수 있지.. 
					result.setEmail(rs.getString("email"));
					result.setId(rs.getString("id"));
					result.setName(rs.getString("name")); //MemberVo에 다시 채우는거야 
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally { // 파이널리 블록도 반드시 생성해줄 것.
				close(rs);
				close(pstmt);
			}
			return result;
			
		}

}
