package com.ssh.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import com.opensymphony.xwork2.Result;
import com.ssh.dao.ReplyDAO;
import com.ssh.dao.StudentDAO;
import com.ssh.model.Message;
import com.ssh.model.Reply;
import com.ssh.model.Student;
import com.ssh.service.MessageService;
import com.ssh.service.ReplyService;
import com.ssh.service.StudentService;

public class TestService {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext*.xml");
	
	
	@Test
	public void test() {
		StudentService studentService=ctx.getBean(StudentService.class);
		ReplyService replyService=ctx.getBean(ReplyService.class);
		MessageService messageService=ctx.getBean(MessageService.class);
		
		Student student=(Student) studentService.findStudent("root").get(0);
		
//		Student hStudent=(Student) studentService.findStudent("201403080433").get(0);
		
		Message message=messageService.findMessagebyid((long) 2);
		
		Student hStudent=message.getStudent();
		
		
		
//		Reply reply=new Reply();
//		
//		reply.setUstudent(student);
//		reply.setMessage(message);
//		reply.setContent("评论功能测试test3");
		
		
		//方法一
//		List<Reply> replies=message.getReplies();
//		replies.add(reply);
//		messageService.updateMessage(message);
		
		//方法二
//		message.getReplies().add(reply);
//		replyService.saveReply(reply);
		
		
//		replyService.saveReply(student, message, reply);
		
		
//		messageService.deleteMessage(message);
		
		
		System.out.println("评论者:"+student.getName());
		
		System.out.println("帖子主人:"+hStudent.getName());
		
		System.out.println("帖子ID:"+message.getId());
		System.out.println("帖子:"+message.getContent());
		System.out.println("帖子评论:"+message.getReplies().get(1).getContent());
		
		
		
		
		
	}

}
