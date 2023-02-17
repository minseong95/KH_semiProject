package kh.member.model.service;

import java.sql.Connection;

import kh.member.model.dao.MemberDao;
import kh.member.model.vo.MemberVo;

import static kh.common.jdbc.JDBCTemplate.*;

public class MemberService {

	//로그인
		public MemberVo login (MemberVo vo) {//MemberVo vo 들고와야지
			MemberVo result = null;
			Connection conn =getConnection();
			result = new MemberDao().login(conn, vo);
			close(conn);
			return result; 
		}
		
		// 회원가입
		public int enroll(MemberVo vo) { 
			int result = -1;
			Connection conn = getConnection(); //jdbc에서 getConnection 하면 오토커밋됨. 그렇게 설정했으니.. 
			result = new MemberDao().enroll(conn, vo);
			close(conn);
			return result;
			}
		
		
		//아이디 중복체크
		public int dupIdChk(String id) {
			Connection conn =getConnection();
			int result = new MemberDao().dupIdChk(conn, id);
			//System.out.println(result); 얘도 1
			close(conn);
			return result;
}
}
