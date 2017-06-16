package com.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssh.model.Message;
import com.ssh.model.Reply;

@Component
public class ReplyDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession()
	{
		return this.sessionFactory.getCurrentSession();
	}
	
	
	//下面是dao方法
	
	
	//1.持久化一条评论
	public void SaveReply(Reply reply)
	{
		this.getSession().save(reply);
		
	}
	
	//2.删除一条评论
	public void DeleteReply(Reply reply)
	{
		this.getSession().delete(reply);
	}
	

	//3.根据一条message来查询该message的所有评论
	public List<Reply> FindReplyByMessage(Message message)
	{
		String hql="from Reply c where c.hmessage.id=?";
		return this.getSession().createQuery(hql).setLong(0, message.getId()).list();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
