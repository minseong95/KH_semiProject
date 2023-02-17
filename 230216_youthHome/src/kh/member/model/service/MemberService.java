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
		
}
