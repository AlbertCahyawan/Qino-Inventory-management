/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author albertcahyawan
 */
public class LogoutController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("logout");
        String out = "add item";

        try {
            //Killing the cookie
            Cookie killMyCookie;
            killMyCookie = new Cookie("QinoEmail", null);
            killMyCookie.setMaxAge(0);
            killMyCookie.setPath("/Qino/");
            hsr1.addCookie(killMyCookie);

            killMyCookie = new Cookie("QinoPassword", null);
            killMyCookie.setMaxAge(0);
            killMyCookie.setPath("/Qino/");
            hsr1.addCookie(killMyCookie);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        mv.addObject("message", out);
        return mv;
    }

}
