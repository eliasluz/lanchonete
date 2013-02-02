package br.com.lanchonete.util;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = createSessionFactory();

	private static SessionFactory createSessionFactory(){
		
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		return cfg.buildSessionFactory();
		
	}
	public static SessionFactory getSessionFactory(){
		
		return sessionFactory;
	}
}
