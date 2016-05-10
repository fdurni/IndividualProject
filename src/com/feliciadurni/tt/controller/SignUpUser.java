package com.feliciadurni.tt.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

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
        PersonDao dao = new PersonDao();
        PersonRole personRole = new PersonRole();
        String gRecaptchaResponse;
        String username = req.getParameter("userName");
        int insertPersonId = 0;

        /*
         * setters for a person
         */
        person.setFirstName(req.getParameter("firstName"));
        person.setLastName(req.getParameter("lastName"));
        person.setUserName(username);
        person.setPassword(req.getParameter("password"));

        /*
         * get the g-recaptcha-response and verify it
         */
        gRecaptchaResponse = req.getParameter("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

        /*
         * setters for a personrole
         */
        personRole.setRole("user");
        personRole.setUserName(username);
        personRole.setPerson(person);

        /*
         * create a Set of roles that will be created for the person
         */
        Set<PersonRole> roles = new HashSet<PersonRole>();
        roles.add(personRole);
        person.setRoles(roles);

        /*
         * insert the person into the database
         */
        insertPersonId = dao.addPerson(person);

        /*
         * used to output an error message if insert is unsuccessful
         */
        PrintWriter out = resp.getWriter();

        /*
         * verify re-captcha and that a person was inserted
         * else, output error messages
         */
        if (verify && insertPersonId > 0) {
            resp.sendRedirect("/person/home");
        } else if (insertPersonId == 0) {
            out.println("<font color=red>Could not register new user. Try again.</font>");
        } else {
            out.println("<font color=red>You missed the Captcha.</font>");
        }
    }
}
