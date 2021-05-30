package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

public class App 
{
	
    public static void main( String[] args ) {
        
    	
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
    	
    	
    	
//    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
    	StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
    	
//    	INSERT QUERY
//    	Student student = new Student(678, "Gaurav Singh", "Ballia");
//    	System.out.println(studentDao.insert(student));
    	
//    	UPDATE QUERY
//    	Student student = new Student();
//    	student.setId(222);
//    	student.setCity("RawalPindi");
//    	student.setName("Dhiraj");
//    	System.out.println(studentDao.change(student));
    	
    	
//    	DELETE QUERY
//    	System.out.println(studentDao.delete(222));
    	
//    	Student student = studentDao.getStudent(456);
//    	System.out.println(student); 
    	//ROW MAPPER
    	
    	List<Student> allRecord = studentDao.getAllRecord();
    	for(Student student : allRecord)
    		System.out.println(student);
    }
}
 