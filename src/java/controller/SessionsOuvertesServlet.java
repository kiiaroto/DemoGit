package controller;

import dao.SessionFormationDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SessionFormation;

/**
 * Servlet implementation class SessionsOuvertesServlet
 */
@WebServlet("/sessionsOuvertes")
public class SessionsOuvertesServlet extends HttpServlet {
    private String VUE_OK = "/WEB-INF/sessions.jsp";
    private String VUE_ERREUR = "/WEB-INF/message.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vue = VUE_OK;
        try {
            SessionFormationDao dao = new SessionFormationDao();
            List<SessionFormation> sessions = dao.getOuvertes();
            request.setAttribute("sessions", sessions);
            
        } catch (SQLException exc) {
            exc.printStackTrace();
            request.setAttribute("message", "Pb de bases de données");
            vue = VUE_ERREUR;
        }
        getServletContext().getRequestDispatcher(vue).forward(request, response);
    }
}