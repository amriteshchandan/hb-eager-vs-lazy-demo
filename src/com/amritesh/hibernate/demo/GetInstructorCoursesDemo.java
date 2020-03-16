package com.amritesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amritesh.hibernate.entity.demo.Course;
import com.amritesh.hibernate.entity.demo.Instructor;
import com.amritesh.hibernate.entity.demo.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			Instructor tempInstructor = session.get(Instructor.class, 1);
			System.out.println("Instructor :: " + tempInstructor);
			System.out.println("Courses :: " + tempInstructor.getCourses());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		
	}
	
}