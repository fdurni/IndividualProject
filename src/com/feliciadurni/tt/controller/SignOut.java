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
@WebServlet(name = "SignOut", urlPatterns = { "/person/signOut" } )

public class SignOut extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method signs the user out.
     *
     * @param req The http request object
     * @param resp the http response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();

        resp.sendRedirect("/TrainingTracker_war/");
    }
}