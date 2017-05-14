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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author albertcahyawan
 */
public class LoginController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("loginform");
        String out = "Login Form";
        String username = null;
        String password = null;
        
        if(hsr.getParameterMap().containsKey("username")){
            username = hsr.getParameter("username");
            out = "Please enter valid username  ";
        } 
        if(hsr.getParameterMap().containsKey("pwd")){
            password = hsr.getParameter("pwd");
            out = "Please enter valid   password";
        } 
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            //session.save(myObject);
            
            //Session session = HibernateUtil.getSessionFactory().openSession();
            //session.beginTransaction();
            //List result = session.createQuery("from Users").list();
            
            mv.addObject("users",session.createQuery("from Users").list());
            
            //mv.addObject("users",result);
            session.getTransaction().commit();
        } catch(HibernateException e){
            e.printStackTrace();
        }
        mv.addObject("message",out);
        return mv;
    }
    
}
