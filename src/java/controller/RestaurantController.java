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
import model.Restaurant;
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
public class RestaurantController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String RestaurantName = "" + hsr.getParameter("restaurantname"); 
        String update = ""+hsr.getParameter("submit");
        
        ModelAndView mv = new ModelAndView("restaurant");
        String out = "Restaurant";
        int RestaurantId = 0;
        
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Check for user cookie 
            User user = new User();
            Query query;
            String sql = "";
            List list;

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
                sql = "from User where email='" + username + "' and password='" + password + "'";

                query = session.createQuery(sql);

                list = query.list();
                if (!list.isEmpty()) {
                    user = (User) list.get(0);

                    RestaurantId = user.getRestaurantUid();
                    list.clear();
                }
            }
 
                
                 
                if(update.equalsIgnoreCase("Edit")){
                    
                sql = "update Restaurant set name = '" + RestaurantName + "'  where restaurantUid = " + RestaurantId;

                query = session.createQuery(sql);
                query.executeUpdate(); 
                }else{
                Restaurant restaurant = new Restaurant();
                sql = "from Restaurant where restaurantUid=" + RestaurantId;
                query = session.createQuery(sql);
                restaurant = (Restaurant) query.list().get(0);
                RestaurantName = restaurant.getName();
                }

            mv.addObject("restaurantname", RestaurantName);
            mv.addObject("restaurantEdit",
                    "<div class=\"form-group input-group\">\n"
                    + "<span class=\"input-group-addon\"><i class=\"fa fa-tag\"  ></i></span>\n"
                    + "<input type=\"text\" name=\"restaurantname\" class=\"form-control\" placeholder=\"Name\" value=\""+RestaurantName+"\" />\n"
                    + "</div>\n"
                    + "<input name=\"submit\" type=\"submit\" class=\"btn btn-success \" value=\"Edit\"/>");

            session.getTransaction().commit();
            mv.addObject("message", "Test1");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return mv;
    }

}
