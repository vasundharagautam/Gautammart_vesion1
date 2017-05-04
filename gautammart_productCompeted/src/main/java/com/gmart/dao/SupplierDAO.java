package com.gmart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmart.model.Supplier;
import com.google.gson.Gson;



@Repository
public class SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(Supplier supplier) {
		Session session=sessionFactory.openSession();
		System.out.println("Insert Method call for Supplier-Details");
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(supplier);
		session.flush();
		tran.commit();
		session.close();
		
	}

	public String Retrive() {
		Session connection=sessionFactory.openSession();
		Transaction tx=connection.getTransaction();
		tx.begin();

		 List listdata = connection.createQuery("FROM Supplier").list();
		 Gson gson = new Gson();
		 String jsonNames = gson.toJson(listdata);
		 tx.commit();
		 connection.close();
	     return jsonNames;
	}

}
