package dao;

import java.sql.*;

import model.Personne;

public class PersonneDao {

    public void insert(Personne personne) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO personne (id_personne, nom, prenom, mail ,tel ,adresse,code_postal,ville,mot_de_passe)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, personne.getId());
        stmt.setString(2, personne.getNom());
        stmt.setString(3, personne.getPrenom());
        stmt.setString(4, personne.getMail());
        stmt.setString(5, personne.getTel());
        stmt.setString(6, personne.getAdresse());
        stmt.setString(7, personne.getCodePostal());
        stmt.setString(8, personne.getVille());
        stmt.setString(9, personne.getMotDePasse());
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

}
