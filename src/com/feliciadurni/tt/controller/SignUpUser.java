package com.feliciadurni.tt.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.PersonDao;
import com.feliciadurni.tt.utils.VerifyRecaptcha;
import org.apache.log4j.Logger;

/**
 * Created by felic on 4/17/2016.
 */
@WebServlet(name = "SignUpUser", urlPatterns = { "/signUpUser" } )

public class SignUpUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new Person();
        String gRecaptchaResponse;

        person.setFirstName(req.getParameter("firstName"));
        person.setLastName(req.getParameter("lastName"));
        person.setUserName(req.getParameter("userName"));
        person.setPassword(req.getParameter("password"));
        gRecaptchaResponse = req.getParameter("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

        PersonDao dao = new PersonDao();
        dao.addPerson(person);

        if (verify) {
            resp.sendRedirect("/person/main.jsp");
            log.info("captcha success!");

            System.out.println("captcha success!");
        } else {
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>You missed the Captcha.</font>");
        }
    }
}
