/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Database;
import dao.PersonneDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Personne;
import tools.PasswordGenerator;
import tools.ServeurSMTP;

/**
 *
 * @author Teixei_H
 */
@WebServlet(name = "InscrireServlet", urlPatterns = {"/inscrire"})
public class InscrireServlet extends HttpServlet {
    Personne pers=new Personne() ;
    private final String VUE_FORM = "/WEB-INF/inscription.jsp";
    private final String VUE_MESSAGE = "/WEB-INF/message.jsp";

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(VUE_FORM).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean champsvalides = true;

        String vue = VUE_MESSAGE;

        System.out.println("Suis dans InscrireServlet");

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String tel = request.getParameter("telephone");
        String adresse = request.getParameter("adresse");
        String codepostal = request.getParameter("codepostal");
        String ville = request.getParameter("ville");

        if (nom == null || nom.matches("^ *$")) {
            champsvalides = false;
            request.setAttribute("nom_message", "Veuillez entrer votre nom.");
        }
        if (prenom == null || prenom.matches("^ *$")) {
            champsvalides = false;
            request.setAttribute("prenom_message", "Veuillez entrer votre prénom.");
        }
                
        if (mail == null || mail.matches("^ *$") || !mail.contains("@")) {
            champsvalides = false;
            request.setAttribute("mail_message", "Veuillez entrer votre e-mail.");
        }
        
        if (tel == null || tel.matches("^ *$")) {
            champsvalides = false;
            request.setAttribute("telephone_message", "Veuillez entrer votre téléphone.");
        }
        if (adresse == null || adresse.matches("^ *$")) {
            champsvalides = false;
            request.setAttribute("adresse_message", "Veuillez entrer votre adresse.");
        }
        if (codepostal == null || codepostal.matches("^ *$")) {
            champsvalides = false;
            request.setAttribute("codepostal_message", "Veuillez entrer votre code postal.");
        }
        if (ville == null || ville.matches("^ *$")) {
            champsvalides = false;
            request.setAttribute("ville_message", "Veuillez entrer votre ville.");
        }
        
        
        if (champsvalides) {
            try {
                try {
                    Connection con = Database.getConnection();
                    
                    PersonneDao pdao = new PersonneDao();
                    PasswordGenerator randmdp = new PasswordGenerator();
                    
                    String mdp = randmdp.getRandomPassword();
                    
                    pers = new Personne(0, nom, prenom, mail, tel, adresse, codepostal, ville, mdp);
                    
                    pdao.insert(pers);
                    request.setAttribute("message", "Vous êtes inscrit ");
                } catch (SQLException ex) {
                    if (ex.getErrorCode() == Database.DOUBLON) {
                        request.setAttribute("message", "Cette adresse email existe déjà");
                        vue = VUE_FORM;
                    } else {
                        Logger.getLogger(InscrireServlet.class.getName()).log(Level.SEVERE, null, ex);
                        request.setAttribute("message", "Problème de bases de données à " + (new Date()));
                    }
                }
                ServeurSMTP s = new ServeurSMTP();
                s.NewEmail(pers.getMail(), pers.getMotDePasse());
            } catch (MessagingException ex) {
                Logger.getLogger(InscrireServlet.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            HttpSession maSession = request.getSession();
            maSession.setAttribute("nom", nom);
            maSession.setAttribute("prenom", prenom);
            maSession.setAttribute("mail", mail);
            maSession.setAttribute("tel", tel);
            maSession.setAttribute("adresse", adresse);
            maSession.setAttribute("codepostal", codepostal);
            maSession.setAttribute("ville", ville);
            vue = VUE_FORM;
        }
        request.getRequestDispatcher(vue).forward(request, response);
    }
}
