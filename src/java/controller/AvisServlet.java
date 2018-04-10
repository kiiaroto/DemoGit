/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AvisDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avis;

/**
 *
 * @author Ronan
 */
@WebServlet(name = "AvisServlet", urlPatterns = {"/AvisServlet"})
public class AvisServlet extends HttpServlet {

    private final String VUE_AVIS = "/WEB-INF/Avis.jsp";
    private final String VUE_ERREUR = "/WEB-INF/message.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(VUE_AVIS).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String beau = request.getParameter("AvisUtilisateurEsthetisme");
        String ergonomie = request.getParameter("AvisUtilisateurErgonomie");
        String fonctionnel = request.getParameter("AvisUtilisateurfonctionnalite");
        String commentaire = request.getParameter("AvisUtilisateurCommentaire");

        LocalDateTime date = LocalDateTime.now();

        int beauNombre = 0;
        beauNombre = Integer.parseInt(beau);
        System.out.println(beauNombre);

        int ergonomieNombre = 0;
        ergonomieNombre = Integer.parseInt(ergonomie);
        System.out.println(ergonomieNombre);

        int fonctionnelNombre = 0;
        fonctionnelNombre = Integer.parseInt(fonctionnel);
        System.out.println(fonctionnelNombre);

        Avis avise = new Avis(beauNombre, ergonomieNombre, fonctionnelNombre, commentaire, date);
        AvisDao avis = new AvisDao();
        try {
            avis.insert(avise);
            request.setAttribute("message", "Votre avis a été pris en compte !");
            request.getRequestDispatcher(VUE_ERREUR).forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(AvisServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher(VUE_AVIS).forward(request, response);
    }

}