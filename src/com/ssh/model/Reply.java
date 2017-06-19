package com.ssh.model;

import java.sql.Timestamp;

public class Reply implements Comparable<Reply>{
	private Long id;
	private Student ustudent;
	private String content;
	private Message message;
	private Timestamp createtime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Student getUstudent() {
		return ustudent;
	}
	public void setUstudent(Student ustudent) {
		this.ustudent = ustudent;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	@Override
	public int compareTo(Reply o) {
		// TODO Auto-generated method stub
		int i=(int) (o.getId()-id);
		return i;
	}
	
	
}
