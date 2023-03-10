package kh.board.model.vo;

public class BoardVo {
//	desc BOARD_TABLE;
//	---------- -------- ------------- 
//	IDX        NOT NULL NUMBER         
//	WRITER              VARCHAR2(20)   
//	SUBJECT             VARCHAR2(225)  
//	CONTEXT             VARCHAR2(2000) 
//	CREATEDATE          DATE           
//	VIEW_CNT            NUMBER(20)
	
	private int idx;
	private String writer;
	private String subject;
	private String context;
	private String createdate;
	private int view_cnt;
	@Override
	public String toString() {
		return "BoardVo [idx=" + idx + ", writer=" + writer + ", subject=" + subject + ", context=" + context
				+ ", createdate=" + createdate + ", view_cnt=" + view_cnt + "]";
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
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
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
	public BoardVo(int idx, String writer, String subject, String context, String createdate, int view_cnt) {
		super();
		this.idx = idx;
		this.writer = writer;
		this.subject = subject;
		this.context = context;
		this.createdate = createdate;
		this.view_cnt = view_cnt;
	}
	
	public BoardVo() {} //혹시몰라서 생성자 추가..
	
	
	
	
	
}
