package com.profound.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.profound.entity.Student;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		char ch='n';
		Scanner sc=new Scanner(System.in);
		
		do {
			
			System.out.println("--------------------MENU----------------");
			System.out.println("1.Add Studnt");
			System.out.println("2.Update Student");
			System.out.println("3.Delete Student");
			System.out.println("4.Show Student By Id");
			System.out.println("5.Exit");
			System.out.println("Enter Your Choice:");
			int choice=sc.nextInt();
			sc.nextLine();			
			switch(choice) {
			
			case 1:Student s=new Student();
			System.out.println("Enter Student Name:");
			s.setStud_name(sc.nextLine());
			System.out.println("Enter Student City:");
			s.setStude_city(sc.nextLine());
			
			session.save(s);
			tx.commit();
			break;
			
			case 2:System.out.println("Enter Id:");
			int id=sc.nextInt();
			Student s1=session.get(Student.class, id);
			System.out.println("1.Update Name");
			System.out.println("2.Update City");
			System.out.println("3.Update Name and City");
			System.out.println("Enter Your Choice:");
			int ch1=sc.nextInt();
			
			switch(ch1) {
			case 1:System.out.println("Enter Name:");
			s1.setStud_name(sc.nextLine());
			session.save(s1);
			tx.commit();
			break;
			
			case 2:System.out.println("Enter City:");
			s1.setStude_city(sc.nextLine());
			session.save(s1);
			tx.commit();
			break;
			
			case 3:System.out.println("Enter Name:");
			s1.setStud_name(sc.nextLine());
			System.out.println("Enter City:");
			s1.setStude_city(sc.nextLine());
			session.save(s1);
			tx.commit();
			break;
			
			
			}
			break;
			
			case 3:
				System.out.println("Enter Id:");
				Student s12=session.get(Student.class,sc.nextInt() );
				session.delete(s12);
				tx.commit();
				break;
				
			case 4:System.out.println("Enter Id:");
			int id1=sc.nextInt();
			Student s11=session.get(Student.class,id1);
			
			System.out.println("Id : "+s11.getStud_id()); 
	        System.out.println("Name : "+s11.getStud_name()); 
	        System.out.println("City : "+s11.getStude_city()); 
	        break;
			}
			System.out.println("Do You Want to Continue");
			ch=sc.nextLine().charAt(0);
		}while(ch=='y'||ch=='Y');
		session.close();
		factory.close();
	}

}
