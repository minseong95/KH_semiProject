package kh.board.model.vo;

public class BoardVo {
//	desc BOARD_TABLE;
//	---------- -------- ------------- 
//	IDX        NOT NULL NUMBER        
//	WRITER              VARCHAR2(20)  
//	SUBJECT             VARCHAR2(225) 
//	CREATEDATE          DATE          
//	VIEW_CNT            NUMBER(20)
	
	private int idx;
	private String writer;
	private String subject;
	private String createdate;
	private int view_cnt;
	
	@Override
	public String toString() {
		return "BoardVo [idx=" + idx + ", writer=" + writer + ", subject=" + subject + ", createdate=" + createdate
				+ ", view_cnt=" + view_cnt + "]";
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	
	
	
}
