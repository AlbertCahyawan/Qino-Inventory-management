/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Encrypt;
import model.HibernateUtil;
import model.Sale;
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
public class IndexController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("index");

        String out = "Login Form";

        int RestaurantId = 0;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Check for user cookie 
            User user = new User();
            Sale sale = new Sale();
            
            String username = null;
            String password = null;
            Query query;
            List list;
            String sql = "";
            
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
            
            /*
            sql = "from Sale LEFT JOIN Item ";
            //+ "where Sale.uid =1";//+RestaurantId
              
            query = session.createQuery(sql);
            list = query.list();  */
            
            
            mv.addObject("message","test");

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return mv;
    }

}
