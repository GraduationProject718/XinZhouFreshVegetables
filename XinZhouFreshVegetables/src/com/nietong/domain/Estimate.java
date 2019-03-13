package com.nietong.domain;

import java.util.Date;

public class Estimate {
	private String id;
	private String content;
	private Date date;
	private String uid;
	private String pid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Estimate() {
	}
	public Estimate(String id, String content, Date date, String uid, String pid) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.uid = uid;
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Estimate [id=" + id + ", content=" + content + ", date=" + date + ", uid=" + uid + ", pid=" + pid + "]";
	}
	
}
