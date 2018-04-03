/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }

    @Test
    public void testGetConnection() throws Exception {
      System.out.println("getConnection");
      Connection result = Database.getConnection();
      assertNotNull(result);
    }
    
    @Test
    public void testReset() throws SQLException {
        System.out.println("reset");
        Database.reset(LocalDateTime.now());
    }
}
