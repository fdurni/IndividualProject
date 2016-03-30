package com.feliciadurni.tt.controller;

import com.feliciadurni.tt.entity.ProgramsEntity;
import com.feliciadurni.tt.persistence.ProgramsEntityDaoWithHibernate;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 *  This is a servlet that adds a new Program to the application.
 *
 *@author    Felicia Durni
 */

@WebServlet(name = "addProgram", urlPatterns = { "/add-program" } )
public class AddProgram extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     *  Handles HTTP GET requests.
     *
     *@exception  ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProgramsEntityDaoWithHibernate dao = new ProgramsEntityDaoWithHibernate();
        ProgramsEntity program = new ProgramsEntity();

        req.setAttribute("programName", program.setProgramName(programName));
        req.setAttribute("programType", program.setProgramType(programType));
        req.setAttribute("programDescription", program.setProgramDescription(programDescription));
        log.debug("added program");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addProgram" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
