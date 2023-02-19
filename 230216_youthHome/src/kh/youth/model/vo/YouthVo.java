package kh.youth.model.vo;

import java.sql.Date;

public class YouthVo {
//	desc ann_table;
//	---------- -- ------------- 
//	IDX          NUMBER(6)     
//	DIVISION     VARCHAR2(10)  
//	ANNNAME      VARCHAR2(100) 
//	ANNDATE      DATE          
//	APPLYDATE    DATE          
//	MANAGER      VARCHAR2(100) 
//	
	
	private int idx;
	private String division;
	private String annName;
	private Date annDate;
	private Date applyDate;
	private String manager;
	
	public YouthVo() {}
	public YouthVo(int idx, String division, String annName, Date annDate, Date applyDate, String manager) {
		super();
		this.idx = idx;
		this.division = division;
		this.annName = annName;
		this.annDate = annDate;
		this.applyDate = applyDate;
		this.manager = manager;
	}
	
	
	@Override
	public String toString() {
		return "YouthVo [idx=" + idx + ", division=" + division + ", annName=" + annName + ", annDate=" + annDate
				+ ", applyDate=" + applyDate + ", manager=" + manager + "]";
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getAnnName() {
		return annName;
	}
	public void setAnnName(String annName) {
		this.annName = annName;
	}
	public Date getAnnDate() {
		return annDate;
	}
	public void setAnnDate(Date annDate) {
		this.annDate = annDate;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
	
	
}
