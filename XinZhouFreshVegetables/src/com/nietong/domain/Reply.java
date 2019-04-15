package com.nietong.domain;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
	private String id;
	private String uid;
	private String eid;
	private String content;
	private Date date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Reply [id=" + id + ", uid=" + uid + ", eid=" + eid + ", content=" + content + ", date=" + date + "]";
	}
	public Reply(String id, String uid, String eid, String content, Date date) {
		super();
		this.id = id;
		this.uid = uid;
		this.eid = eid;
		this.content = content;
		this.date = date;
	}
	
	public Reply() {
	}
}
