package com.hibernate.hbr_caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	private static final String Session = null;

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		firstLevelCache(factory);
		
		
		factory.close();
		
		
	}

	private static void firstLevelCache(SessionFactory factory) {
		
		//when second level cache was not enabled
		Session session = factory.openSession();

		//writeToDB(session);
		
		System.out.println("\nCalling for 17020 first time...");
		User user = session.get(User.class, 17020);
		System.out.println(user);
		
		System.out.println("\nCalling for 17020 second time...DB called??");
		User user2 = session.get(User.class, 17020);
		System.out.println(user2);
		
		System.out.println("\n17020 exists in session1 : " + session.contains(user2));//true
		
		session.close();
		
		Session session2 = factory.openSession();
		System.out.println("\n17020 exists in session2 : " + session2.contains(user2));//false
		
		System.out.println("\nCalling for 17020 third time with diff session...DB called??");
		User user3 = session2.get(User.class, 17020);
		System.out.println(user3);
		session2.close();
	}

	private static void writeToDB(Session session) {
		
		session.beginTransaction();
		
		session.save(new User(17020, "viku@NITA"));
		
		session.getTransaction().commit();
		
	}
}
