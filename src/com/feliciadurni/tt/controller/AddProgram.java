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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.PersonDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;

/**
 * Created by felic on 4/17/2016.
 */
@WebServlet(name = "AddProgram", urlPatterns = { "/person/addProgram" } )

public class AddProgram extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/person/addProgram.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Program program = new Program();
        ProgramDao dao = new ProgramDao();
        PersonDao personDao = new PersonDao();
        String username = req.getRemoteUser();
        Person loggedInPerson = personDao.getPersonByUsername(username);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String beginDate = req.getParameter("beginDate");
        Date formattedBeginDate = new Date();

        try {
            formattedBeginDate = format.parse(beginDate);
        } catch (ParseException e) {
            log.warn(e);
        }

        int numberOfWeeks = Integer.parseInt(req.getParameter("numberOfWeeks"));

        Date endDate = program.calculateEndDate(formattedBeginDate,numberOfWeeks);

        program.setPerson(loggedInPerson);
        program.setProgramName(req.getParameter("programName"));
        program.setProgramType(req.getParameter("programType"));
        program.setProgramDescription(req.getParameter("programDescription"));
        program.setNumberOfWeeks(numberOfWeeks);
        program.setBeginDate(formattedBeginDate);
        program.setEndDate(endDate);

        dao.addProgram(program);

        /*
         * Logic to redirect user
         * if the button was clicked
         */
        if (req.getParameter("submit") != null) {
            resp.sendRedirect("/person/addProgram");
        }
        else if (req.getParameter("submitAndAdd") != null) {
            resp.sendRedirect("/person/selectProgram");
        }
    }
}
