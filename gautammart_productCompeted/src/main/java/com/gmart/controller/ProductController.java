package com.gmart.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gmart.dao.CategoryDAO;
import com.gmart.dao.ProductDAO;
import com.gmart.dao.SupplierDAO;
import com.gmart.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO cdao;
//
	@Autowired
	CategoryDAO cdao1;

	@Autowired
	SupplierDAO cdao2;
	public ProductController()
	{}
	
//	@RequestMapping( "/showproductpage")
//	public String disproduct()
//	{
//		return "ProductAdminView";
//	}

	@RequestMapping(value = "/showproductadmin", method = RequestMethod.GET)
	public ModelAndView showProductAdmin() 
	{

		ModelAndView mvc = new ModelAndView("ProductAdminView", "productadmin", new Product());

		String products = cdao.Retrive();
		String categoryes = cdao1.Retrive();
		String suppliers = cdao2.Retrive();
		System.out.println("my supplier"+suppliers);
		mvc.addObject("mylist1", categoryes);
		mvc.addObject("mylist2", suppliers);
		mvc.addObject("mylist3", products);
		return mvc;
	}

	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	public ModelAndView addProducts(@ModelAttribute("productadmin")Product productadmin,BindingResult result) 
	{
		System.out.println("hiiiiiiiiiiiiiiiiiiii");
		
		ModelAndView m1 = new ModelAndView("ProductAdminView", "productadmin", new Product());
		System.out.println(productadmin.getProID());
		cdao.insertProduct(productadmin);
		String path="E:\\DT\\gautammart\\src\\main\\webapp\\resources\\images\\";
		
		path=path+String.valueOf(productadmin.getProID())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=productadmin.getProImage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
              			fos.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		
		
		 boolean data=false;
		 String categoryes = cdao1.Retrive();
		String suppliers = cdao2.Retrive();
		String products = cdao.Retrive();
		 m1.addObject("checkk",data);
		m1.addObject("mylist3", products);
		m1.addObject("mylist1", categoryes);
		m1.addObject("mylist2", suppliers);
		return m1;
		
	}
	@RequestMapping(value="/Deleteproduct", method=RequestMethod.GET)
	public ModelAndView DeleteProduct(@RequestParam("pid")int cid)
	{
	
		cdao.Delete(cid);
		ModelAndView mvc=new ModelAndView("ProductAdminView","productadmin",new Product());
		String products=cdao.Retrive();
		String categoryes = cdao1.Retrive();
		String suppliers = cdao2.Retrive();
		
		mvc.addObject("mylist1", categoryes);
		mvc.addObject("mylist2", suppliers);
		mvc.addObject("mylist3",products);
		return mvc;
	}
	
	@RequestMapping(value="/plzUpdatedproduct", method=RequestMethod.GET)
	public ModelAndView plzUpdatedProduct(@RequestParam("pid")int cid)
	{
		Product poc=cdao.UpdateProduct(cid);
       boolean data=true;
		ModelAndView mvc=new ModelAndView("ProductAdminView","productadmin",poc);
		String categoryes = cdao1.Retrive();
		String suppliers = cdao2.Retrive();
		String productsss=cdao.Retrive();
		mvc.addObject("mylist3",productsss);
		mvc.addObject("mylist1", categoryes);
		mvc.addObject("mylist2", suppliers);
		mvc.addObject("checkk",data);
	   return mvc;
	}
	
	@RequestMapping(value="/plzNowUpdatedproducts", method=RequestMethod.POST)
	public ModelAndView plzNowUpdatedProducts(HttpServletRequest request)
	{
		  String cid=request.getParameter("productid");                                                 
		String cname=request.getParameter("productname");
		String cprize=request.getParameter("prize");
		String cstock=request.getParameter("stock");    
        String cdesc=request.getParameter("description");
                              
		boolean data=false;
		int cid1=Integer.parseInt(cid);
		int prize=Integer.parseInt(cprize);
		int stock=Integer.parseInt(cstock);
		cdao.NowUpdateProduct(cid1,cname,prize,stock,cdesc);
		ModelAndView mvc=new ModelAndView("ProductAdminView","productadmin",new Product());
		String products=cdao.Retrive();
		String categoryes = cdao1.Retrive();
		String suppliers = cdao2.Retrive();
		mvc.addObject("mylist3",products);
		mvc.addObject("mylist1", categoryes);
		mvc.addObject("mylist2", suppliers);
		mvc.addObject("checkk",data);
	   return mvc;
	}



}
