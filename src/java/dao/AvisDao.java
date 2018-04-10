/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.Avis;

/**
 *
 * @author Ronan
 */
public class AvisDao {

    public void insert(Avis avis) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO avis (fonctionnalite, ergonomie, beaute, commentaire, date_effet)"
                + " VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, avis.getFonctionnalite());
        stmt.setInt(2, avis.getErgonomie());
        stmt.setInt(3, avis.getBeaute());
        stmt.setString(4, avis.getCommentaire());
        stmt.setTimestamp(5, Timestamp.valueOf(avis.getDate()));
        stmt.executeUpdate();
        stmt.close();
        connection.close();

    }

}
