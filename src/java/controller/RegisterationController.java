/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Encrypt;
import model.HibernateUtil; 
import model.Restaurant;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author albertcahyawan
 */
public class RegisterationController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String Username = hsr.getParameter("name");
        String Email = hsr.getParameter("email");
        String Phone = hsr.getParameter("phone");
        String Password = hsr.getParameter("password");
        String RetypePassword = hsr.getParameter("retypepassword");

        ModelAndView mv = new ModelAndView("registeration");
        String out = "add User";

        if (Password != RetypePassword) {
            out = "Password is different";
        }

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            int restoid = 0;
            
            //encrypt the password
            Encrypt encrypt = new Encrypt();
            encrypt.setEncrpty(Password);
            Password = encrypt.getEncrpty();
            
            Restaurant restaurant = new Restaurant();
            restaurant.setName("");
            restaurant.setCurrency("idr");
            session.save(restaurant);
            
            restoid = restaurant.getRestaurantUid();
            
            User user = new User();
            user.setUsername(Username);
            user.setEmail(Email);
            user.setPhonenumber(Phone);
            user.setPassword(Password);
            user.setAccessright("Admin");
            user.setRestaurantUid(restoid); 
            session.save(user);  
            
            session.getTransaction().commit();

            out = "jalan";
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        mv.addObject("message", out);
        return mv;
    }
}
