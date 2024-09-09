package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;


public class Main {

	public static void main(String args[])
	{
		ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao dao=context.getBean("studentDao",StudentDao.class);
	/*	Student s=new Student();
		s.setId(105);
		s.setName("vini");
		s.setCity("indore");
		int r=dao.insert(s);
		System.out.print("data inserted"+r);*/
		
		//Update
	/*Student s1=new Student();
		s1.setId(103);
		s1.setName("ANshita");
		s1.setCity("indore");
		int r1=dao.change(s1);
		System.out.print("data changes"+r1);*/
		
		
		//delete
	/*	int r2=dao.delete(105);
		System.out.print("data deleted"+r2);*/
		
	
	/*	Student s3=dao.getStudent(105);
		System.out.print(s3);*/
		
		List<Student>list=dao.getAllStudents();
		for(Student s: list)
		{
			System.out.println(s);
			
		}
        
	}
}
