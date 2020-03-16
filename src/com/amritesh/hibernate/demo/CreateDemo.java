package com.amritesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amritesh.hibernate.entity.demo.Course;
import com.amritesh.hibernate.entity.demo.Instructor;
import com.amritesh.hibernate.entity.demo.InstructorDetail;

public class CreateDemo {

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
			Instructor instructor = new Instructor("Susan", "Public", "susan.public@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("https://ytb.com/susan", "Video Game");
			instructor.setInstructorDetail(instructorDetail);
			session.save(instructorDetail);
			session.save(instructor);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		
	}
	
}