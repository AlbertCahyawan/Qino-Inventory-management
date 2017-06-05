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
import model.Encrypt;
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
public class AddUserController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String Username = hsr.getParameter("name");
        String Email = hsr.getParameter("email");
        String Phone = hsr.getParameter("phone");
        String Password = hsr.getParameter("password");
        String RetypePassword = hsr.getParameter("retypepassword");
        String AccessRight = hsr.getParameter("AccessRight");

        ModelAndView mv = new ModelAndView("adduser");
        String out = "add User";
        int RestaurantId = 0;
        

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
            //encrypt the password
            Encrypt encrypt = new Encrypt();
            encrypt.setEncrpty(Password);
            Password = encrypt.getEncrpty();

            user = new User();
            user.setUsername(Username);
            user.setEmail(Email);
            user.setPhonenumber(Phone);
            user.setPassword(Password);
            user.setAccessright(AccessRight);
            user.setRestaurantUid(RestaurantId);

            session.save(user);

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        mv.addObject("message", out);
        return mv;
    }

}
