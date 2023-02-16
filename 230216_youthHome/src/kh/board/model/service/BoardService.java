package kh.board.model.service;

import java.sql.Connection;

import kh.board.model.dao.BoardDao;
import kh.board.model.vo.BoardVo;
import static kh.common.jdbc.JDBCTemplate.*;

public class BoardService {
	public BoardVo boardShow() {
		BoardVo result = null;
		Connection conn = getConnection();
		result = new BoardDao().boardShow(conn);
		return result;
	}
}
