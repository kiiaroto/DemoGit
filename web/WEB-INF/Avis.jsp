<%-- 
    Document   : Avis
    Created on : 10 avr. 2018, 10:09:27
    Author     : Ronan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AvisAccueil</title>
    </head>
    <body>


        <form method="post" action="AvisServlet">
            A combien cotez-vous l'esthétisme du site (entre 5 et 0) :
            <SELECT name="AvisUtilisateurEsthetisme" size="1">
                <OPTION selected value=5> 5 </OPTION>
                <OPTION value=4>4 </OPTION>
                <OPTION value=3>3</OPTION>
                <OPTION value=2>2</OPTION>
                <OPTION value=1>1</OPTION>
                <OPTION value=0>0</OPTION>
            </SELECT>
            <br>


            A combien côtez-vous l'ergonomie du site (entre 5 et 0) :
            <SELECT name="AvisUtilisateurErgonomie" size="1">
                <OPTION selected value=5>5</OPTION>
                <OPTION value=4>4</OPTION>
                <OPTION value=3>3</OPTION>
                <OPTION value=2>2</OPTION>
                <OPTION value=1>1</OPTION>
                <OPTION value=0>0</OPTION>
            </SELECT>
            <br>


            A combien cotez-vous la fonctionnalité du site (entre 5 et 0) :
            <SELECT name="AvisUtilisateurfonctionnalite" size="1">
                <OPTION selected value=5>5</OPTION>
                <OPTION value=4>4</OPTION>
                <OPTION value=3>3</OPTION>
                <OPTION value=2>2</OPTION>
                <OPTION value=1>1</OPTION>
                <OPTION value=0>0</OPTION>
            </SELECT>

            <br>

            <TEXTAREA cols=30 rows="5" name="AvisUtilisateurCommentaire" placeholder="Rentrez votre commentaire"></TEXTAREA>


            <br>
            <br>

            <label>Envoyez votre avis</label>
            <input type="submit" name="envoyerLesAvis" value="Soumettre votre avis">
            </form>
    </body>
</html>
