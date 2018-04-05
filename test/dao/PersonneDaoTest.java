/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Personne;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tchju
 */
public class PersonneDaoTest {
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Personne personne = new Personne(1, "palete", "martin", "paleteM@yahoo.fr", "01.45.25.36.98", "3 rue des aulnes", "93600", "aulney", "greta2017");
        PersonneDao instance = new PersonneDao();
        instance.insert(personne);
        
    }
    
}
