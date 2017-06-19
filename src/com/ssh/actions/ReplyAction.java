package com.ssh.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.model.Message;
import com.ssh.model.Reply;
import com.ssh.model.Student;
import com.ssh.service.MessageService;
import com.ssh.service.ReplyService;
import com.ssh.service.StudentService;
import com.sun.org.apache.regexp.internal.recompile;

public class ReplyAction extends ActionSupport implements ServletRequestAware,
														  ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext application;
	
	
	private ReplyService replyService;
	private StudentService studentService;
	private MessageService messageService;
	
	
	public ReplyService getReplyService() {
		return replyService;
	}
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
		this.session=request.getSession();
		this.application=session.getServletContext();
		
		
	}
	
	//发表评论的方法
	public void PublishReply() throws IOException
	{
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		//获取表单参数
		String username=request.getParameter("username");
		Long messageid=Long.valueOf(request.getParameter("messageid"));
		String content=request.getParameter("content");
		
		Student student=studentService.findStudent(username).get(0);
		Message message=messageService.findMessagebyid(messageid);
		
		List<Message> messages=(List<Message>) application.getAttribute("messages");
		List<Message> mymessages=(List<Message>) session.getAttribute("mymessages");
		messages.remove(0);
		mymessages.remove(0);
		
		Reply reply=new Reply();
		reply.setContent(content);
		
		
		replyService.saveReply(student, message, reply);
		
		
//		List<Message> messages=messageService.findallMessage();
//		List<Message> mymessages=messageService.findMessagebystudent((Student) session.getAttribute("student"));
		
//		Timestamp d = new Timestamp(System.currentTimeMillis()); 
//		message.setCreatetime(d);
		
		
		messages.add(message);
		mymessages.add(message);
		
		
		Collections.sort(messages);
		Collections.sort(mymessages);
		
		application.removeAttribute("messages");
		application.setAttribute("messages", messages);
		
		session.removeAttribute("mymessages");
		session.setAttribute("mymessages", mymessages);
	}
	
	
	
	
	
	
	
	
	
}
