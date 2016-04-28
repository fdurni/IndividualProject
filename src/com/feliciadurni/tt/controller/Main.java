package com.feliciadurni.tt.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.PersonDao;
import org.apache.log4j.Logger;

/**
 * Created by felic on 4/28/2016.
 */
@WebServlet(name = "Main", urlPatterns = { "/person/home" } )
public class Main extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        PersonDao personDao = new PersonDao();
        String username = req.getRemoteUser();
        Person loggedInPerson = personDao.getPersonByUsername(username);
        String firstName = loggedInPerson.getFirstName();
        String lastName = loggedInPerson.getLastName();
        String fullName = firstName + " " + lastName;

        session.setAttribute("name", fullName);

        String url = "/person/main.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
