package com.ssh.test;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.model.Message;
import com.ssh.model.Reply;
import com.ssh.model.Student;
import com.ssh.service.MessageService;
import com.ssh.service.ReplyService;
import com.ssh.service.StudentService;

public class TestQuery {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext*.xml");
	
	
	@Test
	public void test() {
		StudentService studentService=ctx.getBean(StudentService.class);
		ReplyService replyService=ctx.getBean(ReplyService.class);
		MessageService messageService=ctx.getBean(MessageService.class);
		
		Student student=studentService.findStudent("201403080433").get(0);
		
		List<Message> messages=messageService.findallMessage();
//		Message testmessage=messageService.findMessagebyid((long) 149);
		
		Collections.sort(messages);
		
		for (Message message : messages) {
			if(message.getReplies() !=null && message.getReplies().size()>=1)
			{
				System.out.println(message.getId());
				for(Reply reply:message.getReplies())
				{
					if(reply !=null )
					{
						System.out.println("ÄÚÈÝ:"+reply.getContent() +"  "+"id:"+reply.getId());
					}
				}
			}
//			System.out.println(message.getId());
		}
		
		
		
//		for (Message message : messages) {
//			System.out.println(message.getStudent());
//		}
		
		
	}

}
