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
public class LoginController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("loginform"); 
     
        String out = "Login Form";
         
        String username ="" ;
        String password ="";
         if(hsr.getParameterMap().isEmpty()){
            //out = "please Fill name and password";
        } else{
           username = hsr.getParameter("UserName");
           password = hsr.getParameter("Password");
         }
        /*
        if(hsr.getParameterMap().containsKey("username")){
            username = hsr.getParameter("username");
            out = "Please enter valid username  ";
        } 
        if(hsr.getParameterMap().containsKey("pwd")){
            password = hsr.getParameter("pwd");
            out = "Please enter valid   password"; 
        } */  
         
 
        try{ 
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
             
            User user = new User();
            //Check for user cookie
             
            Cookie[] c = hsr.getCookies(); 
            
            for(int i = 0; i < c.length; i++){
                Cookie cd = c[i];
                if(cd.getName().equals("QinoEmail")){
                    username = cd.getValue(); 
                } 
                if(cd.getName().equals("QinoPassword")){
                    password = cd.getValue(); 
                }
            } 
             
            if(!username.isEmpty() && !password.isEmpty()){
            String sql = "from User where email='"+username+"' and password='"+password+"'"; 
            
            Query query = session.createQuery(sql);  
            
            List list = query.list();  
            
            if(list.isEmpty()){
                out = "list kosong";
            }else{
                user = (User) list.get(0); 
                Cookie cookie = new Cookie("QinoEmail",user.getEmail());
		cookie.setMaxAge(60*60*24*7); //7 day 
                cookie.setPath("/Qino/");
		hsr1.addCookie(cookie);
                
                cookie = new Cookie("QinoPassword",user.getPassword());
		cookie.setMaxAge(60*60*24*7); //7 day 
                cookie.setPath("/Qino/");
		hsr1.addCookie(cookie);
                  
                mv = new ModelAndView("welcome");
            } 
            }  
            
            session.getTransaction().commit();
        } catch(HibernateException e){
            e.printStackTrace();
        } 
        
            mv.addObject("message",out);  
        return mv;
    }
    
}
