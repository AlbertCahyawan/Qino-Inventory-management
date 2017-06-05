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
public class EditUserController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String Username = hsr.getParameter("name");
        String Phone = hsr.getParameter("phone");
        String update = hsr.getParameter("submit");

        ModelAndView mv = new ModelAndView("edituser");
        String out = "";

        String userid = hsr.getParameter("userId");

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "update User set username = :name ,phonenumber = :phone where uid = " + userid;

            Query query = session.createQuery(hql);
            query.setParameter("name", Username);
            query.setParameter("phone", Phone);
            query.executeUpdate();

            session.getTransaction().commit();

            if (update.equalsIgnoreCase("Edit")) {

                out = Username + " Updated";
            }
            mv.addObject("message", out);

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        mv.addObject("name", Username);
        mv.addObject("phone", Phone);
        mv.addObject("userId", userid);
        return mv;
    }

}
