/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Before;

/**
 * Classe ancêtre des classes de test d'accès à la base de données.
 * Réinitialise la base via un @Before
 * @author admin
 */
public class DaoTestCase {

    @Before
    public void doBefore() throws SQLException {
        Database.reset(LocalDateTime.of(2018, Month.MARCH, 03, 10, 0, 0));
    }
    

}
