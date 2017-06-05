/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author albertcahyawan
 */
public class EditItemController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
        String ItemName = hsr.getParameter("itemname");
        String ItemCategory = hsr.getParameter("itemcategory");

        String ItemPrice = hsr.getParameter("itemprice");
        String ItemCost = hsr.getParameter("itemcost");
        String Quantity = hsr.getParameter("quantity");
        String MinQuantity = hsr.getParameter("minquantity");
        
        String update = hsr.getParameter("submit");
        
        ModelAndView mv = new ModelAndView("edititem");
        
        String out = "";

        String itemid = hsr.getParameter("itemid");
 
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "update Item set itemName = :name ,itemCategory = :category"
                    + ",itemPrice = :price ,itemCost = :cost ,quantity = :quantity"
                    + ",minimumQuantity = :minquantity where uid = " + itemid;

            Query query = session.createQuery(hql);
            query.setParameter("name", ItemName); 
            query.setParameter("category", ItemCategory); 
            query.setParameter("price", Integer.parseInt(ItemPrice)); 
            query.setParameter("cost", Integer.parseInt(ItemCost)); 
            query.setParameter("quantity", Integer.parseInt(Quantity)); 
            query.setParameter("minquantity", Integer.parseInt(MinQuantity));  
              
            query.executeUpdate();
             
            session.getTransaction().commit();
             
            if (update.equalsIgnoreCase("Edit")) {

                out = ItemName + " Updated";
            }  
            mv.addObject("message", out);  
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
         
        mv.addObject("itemid", itemid);
        mv.addObject("itemname", ItemName);
        mv.addObject("itemcategory", ItemCategory);
        mv.addObject("itemprice", ItemPrice);
        mv.addObject("itemcost", ItemCost);
        mv.addObject("quantity", Quantity);
        mv.addObject("minquantity", MinQuantity);
        
        
        
        return mv;
    }

}
