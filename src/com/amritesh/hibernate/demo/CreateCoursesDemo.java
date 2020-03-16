package com.amritesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amritesh.hibernate.entity.demo.Course;
import com.amritesh.hibernate.entity.demo.Instructor;
import com.amritesh.hibernate.entity.demo.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class, 2);
			
			Course tempCourse1 = new Course("ABC");
			Course tempCourse2 = new Course("DEF");
			
			tempInstructor.addCourse(tempCourse1);
			tempInstructor.addCourse(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		
	}
	
}