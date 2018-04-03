package dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dao.SessionFormationDao;
import model.SessionFormation;
import org.junit.Test;

public class SessionFormationDaoTest extends DaoTestCase {

    @Test
    public void testGetOuvertes() throws SQLException {
        System.out.println("testGetOuvertes()");
        List<SessionFormation> expected = new ArrayList<SessionFormation>();
        expected.add(new SessionFormation(4, 2, LocalDateTime.of(2018, Month.SEPTEMBER, 03, 10, 0, 0), LocalDateTime.of(2020, Month.MARCH, 3, 10, 0, 0), true));

        SessionFormationDao sessionFormation = new SessionFormationDao();
        List<SessionFormation> result = sessionFormation.getOuvertes();

        assertArrayEquals(expected.toArray(), result.toArray());
    }

}
