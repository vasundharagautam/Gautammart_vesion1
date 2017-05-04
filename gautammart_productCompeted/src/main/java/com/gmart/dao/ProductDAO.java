package com.gmart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmart.model.Product;
import com.google.gson.Gson;

@Repository
public class ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public void insertProduct(Product product) {
		Session session=sessionFactory.openSession();
		System.out.println("Insert method for Product-Details");
		Transaction tran=session.getTransaction();
		tran.begin();
		session.save(product);
		session.flush();
		tran.commit();
		session.close();
	}
	
	
	public String Retrive()
	{
	Session connection=sessionFactory.openSession();
	Transaction tx=connection.getTransaction();
	tx.begin();

	 List listdata = connection.createQuery("FROM Product").list();
	 Gson gson = new Gson();
	 String jsonNames = gson.toJson(listdata);
	 tx.commit();
	 connection.close();
     return jsonNames;

	}
	
	
	public void Delete(Integer cid) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Product ob=(Product)session.get(Product.class, cid);
		System.out.println("This is ID"+ " "+ob.getProImage());
		session.delete(ob);
		session.flush();
		tx.commit();
		session.close();
		System.out.println("Delete Method Called");
	}
	
	public Product UpdateProduct(Integer cid) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Product ob=(Product)session.get(Product.class, cid);
		tx.commit();
		session.close();
		return ob;
	}
	
	public void NowUpdateProduct(int cid,String cname,int cprize,int cstock,String cdesc) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Product ob=(Product)session.get(Product.class, cid);
		ob.setProName(cname);
		ob.setPrize(cprize);
        ob.setStock(cstock);
       ob.setDescription(cdesc);
		session.update(ob);
		tx.commit();
		session.close();
		System.out.println("Update Method Called");
	
	}
	
	//For Display Click big images
		public Product DisplayImage(int ccid)
		{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Product ok=(Product)session.get(Product.class,ccid);
		session.close();
		return ok;
			
			
		}
}
