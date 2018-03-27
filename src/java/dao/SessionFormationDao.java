package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SessionFormation;

public class SessionFormationDao {

    public List<SessionFormation> getOuvertes() throws SQLException {
        Connection con = Database.getConnection();
        List<SessionFormation> listeDesSessionsOuvertes = new ArrayList<SessionFormation>();

        String requete = "SELECT * FROM session_formation WHERE est_ouverte = true ORDER BY date_debut ASC";

        Statement canal = con.createStatement();
        ResultSet rs = canal.executeQuery(requete);

        while (rs.next()) {
            SessionFormation session = new SessionFormation();
            session.setIdSession(rs.getInt("id_session_formation"));
            session.setIdFormation(rs.getInt("id_formation"));
            session.setDateDebut(rs.getTimestamp("date_debut").toLocalDateTime());
            session.setDateFin(rs.getTimestamp("date_fin").toLocalDateTime());
            session.setEstOuverte(rs.getBoolean("est_ouverte"));
            listeDesSessionsOuvertes.add(session);
        }

        return listeDesSessionsOuvertes;
    }

}
