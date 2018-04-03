<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Sessions ouvertes</title>
    </head>
    <body>
        <h1>Liste des sessions ouvertes</h1>
        <br>
        <table style="border: 1px solid black;border-collapse: collapse;">
            <tr style="border: 1px solid black;">
                <th style="border: 1px solid black;">N° Session</th>
                <th style="border: 1px solid black;">N° Formation</th>
                <th style="border: 1px solid black;">Début de session</th>
                <th style="border: 1px solid black;">Fin de session</th>
                <th style="border: 1px solid black;">Est-elle ouverte ?</th>
            </tr>

            <c:forEach items="${sessions}" var="uneSession">
                <tr style="border: 1px solid black;">
                    <td style="border: 1px solid black;"><c:out value="${uneSession.idSession}" /></td>
                    <td style="border: 1px solid black;"><c:out value="${uneSession.idFormation}" /></td>
                    <td style="border: 1px solid black;"><c:out value="${uneSession.dateDebut}" /></td>
                    <td style="border: 1px solid black;"><c:out value="${uneSession.dateFin}" /></td>
                    <td style="border: 1px solid black;"><c:out value="${uneSession.estOuverte}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>