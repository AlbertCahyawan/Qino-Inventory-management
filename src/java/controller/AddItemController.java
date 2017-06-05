/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import model.Item;
import model.User;
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
public class AddItemController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("additem");
        String out = "add item";
        boolean additem = false;
        
        int RestaurantId = 0;
        String ItemName = hsr.getParameter("itemname");
        String ItemCategory = hsr.getParameter("itemcategory");

        String ItemPrice = hsr.getParameter("itemprice");
        String ItemCost = hsr.getParameter("itemcost");
        String Quantity = hsr.getParameter("quantity");
        String MinQuantity = hsr.getParameter("minquantity");

        if (!hsr.getParameterMap().isEmpty()) {
            additem = true;
        }

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Check for user cookie 
            User user = new User();
            String username = null;
            String password = null;
            Cookie[] c = hsr.getCookies();

            for (int i = 0; i < c.length; i++) {
                Cookie cd = c[i];
                if (cd.getName().equals("QinoEmail")) {
                    username = cd.getValue();
                }
                if (cd.getName().equals("QinoPassword")) {
                    password = cd.getValue();
                }
            }
            if (!username.isEmpty() && !password.isEmpty()) {
                String sql = "from User where email='" + username + "' and password='" + password + "'";

                Query query = session.createQuery(sql);

                List list = query.list();
                if (!list.isEmpty()) {
                    user = (User) list.get(0);

                    RestaurantId = user.getRestaurantUid();
                }
            }
            //end of user
            
            if (additem == true) {
                Item item = new Item();
                item.setItemName(ItemName);
                item.setItemPrice(Integer.parseInt(ItemPrice) + 0);
                item.setItemCost(Integer.parseInt(ItemCost) + 0);
                item.setItemCategory(ItemCategory);
                item.setQuantity(Integer.parseInt(Quantity) + 0);
                item.setMinimumQuantity(Integer.parseInt(MinQuantity) + 0);
                item.setRestaurantUid(RestaurantId);

                session.save(item);
            }

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        mv.addObject("message", out);
        return mv;
    }

}
