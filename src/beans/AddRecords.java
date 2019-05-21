package beans;

import java.util.LinkedHashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddRecords {
	
	
	public static void main(String[] args) {
		
		
		Configuration cfg=new Configuration();
		cfg.addResource("DBMail.hbm.xml");
		SessionFactory fact=cfg.buildSessionFactory();
		Session session=fact.openSession();
		
		
		Employee e1=new Employee(1001,"Harpreet","New Delhi" ,10000000);
		Employee e2=new Employee(1002,"Karan","Ghaziabad" ,100);
		Employee e3=new Employee(1003,"Bhuwan","Noida" ,435000);
		Employee e4=new Employee(1004,"Vaibhav","Bengluru" ,77000);
		Employee e5=new Employee(1005,"Rakesh","Patna" ,2600);
		Employee e6=new Employee(1006,"Jignesh","Ahemdabad" ,10000);
		
		
		LinkedHashSet<Employee> s1=new LinkedHashSet<Employee>();
		LinkedHashSet<Employee> s2=new LinkedHashSet<Employee>();
		LinkedHashSet<Employee> s3=new LinkedHashSet<Employee>();
		
		
		s1.add(e1);    s1.add(e5);
		s2.add(e6);    s2.add(e3);
		s3.add(e2);    s3.add(e4);
		
		
		Department d1= new Department(101,"Admin" , "New Delhi", s1);
		Department d2= new Department(102,"Accounts" , "LOndon", s2);
		Department d3= new Department(103,"Sales" , "Pune", s3);
		
		
		Transaction tx=session.beginTransaction();
		
		session.save(d1);
		session.save(d2);
		session.save(d3);
		
		
		tx.commit();
		
		fact.close();
		session.close();
		
		
		System.out.println("Database Created");
		
		
	}

}
