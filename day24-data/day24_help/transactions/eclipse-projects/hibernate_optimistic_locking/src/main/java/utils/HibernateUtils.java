package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
		System.out.println("sf created!!!!!");

	}

	public static SessionFactory getSf() {
		return sf;
	}

}
