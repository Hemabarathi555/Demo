package com.example.Transaction.Entity;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateParentChild {

	public static void main(String[] args) {
		StandardServiceRegistry registry=new StandardServiceRegistryBuilder()
				.configure()
				.build();
		SessionFactory factory= new MetadataSources(registry)
				.buildMetadata()
				.buildSessionFactory();
		Session session=factory.openSession();
		/*
		 * Category electronics= new Category("Electronics"); Category mobilePhone= new
		 * Category( "Mobile phone",electronics); Category iphone= new
		 * Category("iphone",mobilePhone); Category samsung = new
		 * Category("Samsung",mobilePhone); Category galaxy = new
		 * Category("Galaxy",samsung); Category washingMachine= new
		 * Category("WashingMachine",electronics); electronics.addChild(washingMachine);
		 * electronics.addChild(mobilePhone); mobilePhone.addChild(iphone);
		 * mobilePhone.addChild(samsung); samsung.addChild(galaxy);
		 * session.save(electronics);
		 */
		/*
		 * Category iphone= session.get(Category.class,8); Category iphone10= new
		 * Category("iPhone10",iphone); Category iphone11= new
		 * Category("iPhone11",iphone); iphone.addChild(iphone11);
		 * iphone.addChild(iphone10); session.save(iphone11); session.save(iphone10);
		 */
		Category electronics= session.get(Category.class,3);
		Set<Category> children=electronics.getChildren();
         System.out.println(electronics.getName());
 
         
         for(Category child:children) {
        	 System.out.println( "---" + child.getName());
        	 printChildren(child,1);
         }
		session.close();
		factory.close();
		
	}
	private static void printChildren(Category parent,int subLevel) {
		Set<Category>children= parent.getChildren();
		for(Category child:children) {
			for(int i=0;i<=subLevel; i++)
				 System.out.println("------");
       	 System.out.println(child.getName());
       	 printChildren(child,subLevel + 1);
        }
	}

}
