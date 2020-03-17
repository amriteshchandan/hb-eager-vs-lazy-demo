package com.amritesh.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amritesh.hibernate.entity.demo.Course;
import com.amritesh.hibernate.entity.demo.Instructor;
import com.amritesh.hibernate.entity.demo.InstructorDetail;

public class EagerLazyDemo {

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
			
			Instructor tempInstructor = session.get(Instructor.class, 5);
			System.out.println("tempInstructor :: " + tempInstructor);
			List<Course> courses = tempInstructor.getCourses();
			System.out.println("courses :: " + courses);
			session.getTransaction().commit();
			session.close();
			System.out.println("courses :: " + courses);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			sessionFactory.close();
		}
		
	}
	
}