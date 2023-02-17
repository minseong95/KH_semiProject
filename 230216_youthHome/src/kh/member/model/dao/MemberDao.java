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
		
		// 회원가입-> insert -> insert의 결과물은 int로 리턴함. 그럼 매개인자는?
		public int enroll(Connection conn, MemberVo vo) { //매개인자를 여러개 담을 수 있는 그릇이 있지.. MemberVo
			int result = -1;
			String query = "insert into member_table values"; // 강사님은 쿼리문부터 생각한다 하심.. 
			query+=" (?,?,?,?)"; // 쿼리문 너무 길어진다 싶으면 이렇게 분리를 해서.. 
			
			PreparedStatement  pstmt = null; 
			//여기서 ResultSet은 필요없지
			try {
				pstmt = conn.prepareStatement(query);
				// ? 채워주기(위치홀더)
				pstmt.setString(1, vo.getId()); 
				pstmt.setString(2, vo.getPasswd());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getEmail());
				// pstmt 실행
				// 결과값 result에 대입
				result = pstmt.executeUpdate();  //execute: 실행하다.. 갑분영단어.. 잘외우라고.. 
				
				
			} catch (Exception e) { //Exception으로 퉁쳐도되고 SQLException으로 써도 되고.. 
				e.printStackTrace();
			} //try 블럭 미리 만들어서 써도 괜춚
			 finally {
				 close(pstmt);
			 }
			System.out.println("DAO enroll return : "+result); //오류 확인을 위해 이렇게 syso 뿌려놓기.. 
			return result;
		}
		
		//id 중복체크
		public int dupIdChk(Connection conn, String id) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
			//id로 테이블을 조회, 있으면 1 이상, 없으면 0
			String sql = "select count(*) from member_table where ID=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result =rs.getInt(1); //rs의 첫 컬럼의 숫자값을 가져옴
					//System.out.println(result);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			//System.out.println(result); 테이블에 있는 아이디 입력했을 때 1로 되는데..어디서 잘못된거지
			return result;
		}

}
