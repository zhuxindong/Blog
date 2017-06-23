package com.ssh.test;

import static org.junit.Assert.*;

import org.hibernate.hql.spi.id.cte.CteValuesListBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.model.Score;
import com.ssh.model.Student;
import com.ssh.service.ScoreService;
import com.ssh.service.StudentService;

public class TestSave {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext*.xml");
	
	@Test
	public void test() {
		StudentService studentService=ctx.getBean(StudentService.class);
		ScoreService scoreService=ctx.getBean(ScoreService.class);
		
		Student student=studentService.findStudent("201403080433").get(0);
	}

}
