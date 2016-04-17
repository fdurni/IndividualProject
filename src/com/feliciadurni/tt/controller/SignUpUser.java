package com.feliciadurni.tt.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.PersonDao;
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

        person.setFirstName(req.getParameter("firstName"));
        person.setLastName(req.getParameter("lastName"));
        person.setUserName(req.getParameter("userName"));
        person.setPassword(req.getParameter("password"));

        PersonDao dao = new PersonDao();
        dao.addPerson(person);

        resp.sendRedirect("/person/main.jsp");
    }
}
