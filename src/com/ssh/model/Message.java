package com.ssh.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Message implements Comparable<Message>{
	private Long id;
	private Student student;
	private String content;
	private Timestamp createtime;
	private List<Reply> replies=new ArrayList();
	
	public List<Reply> getReplies() {
		return replies;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	
	
	@Override
	public int compareTo(Message o) {
		// TODO Auto-generated method stub
		int i=(int) (o.getId()-id);
		return i;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", student=" + student + ", content=" + content + ", createtime=" + createtime
				+ ", replies=" + replies + "]";
	}
	
	
	
	
	
}
