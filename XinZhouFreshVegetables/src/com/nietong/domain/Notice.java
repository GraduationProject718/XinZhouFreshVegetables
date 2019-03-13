package com.nietong.domain;

import java.util.Date;

public class Notice {
	private String nid;
	private String ntitle;
	private String ncontent;
	private Date ndate;
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	
	public Date getNdate() {
		return ndate;
	}
	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}
	public Notice() {
	}
	@Override
	public String toString() {
		return "Notice [nid=" + nid + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", ndate=" + ndate + "]";
	}
	public Notice(String nid, String ntitle, String ncontent, Date ndate) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.ndate = ndate;
	}
}
