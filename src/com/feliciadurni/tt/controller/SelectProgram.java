package com.feliciadurni.tt.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.feliciadurni.tt.entity.*;
import com.feliciadurni.tt.persistence.PersonDao;
import com.feliciadurni.tt.persistence.ProgramDao;
import org.apache.log4j.Logger;

/**
 * Created by felic on 4/24/2016.
 */
@WebServlet(name = "SelectProgram", urlPatterns = { "/person/selectProgram" } )
public class SelectProgram extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method displays selectProgram.jsp.
     *
     * @param req The http request object
     * @param resp the http response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/person/selectProgram.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    /**
     * This method creates a list of the user's programs.
     *
     * @param req The http request object
     * @param resp the http response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        ProgramDao dao = new ProgramDao();

        /*
         * determine which program was selected from the dropdown
         */
        int programId = Integer.parseInt(req.getParameter("selectbasic"));
        Program selectedProgram = dao.getProgram(programId);

        /*
         * set the attribute for the selected program
         */
        session.setAttribute("selectedProgram", selectedProgram);

        /*
         * redirect to the add routine page
         */
        resp.sendRedirect("addRoutine");
    }
}
