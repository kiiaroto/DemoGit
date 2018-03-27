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

public class SessionFormationDaoTest {

    @Test
    public void testGetOuvertes() throws SQLException {
        System.out.println("testGetOuvertes()");
        List<SessionFormation> expected = new ArrayList<SessionFormation>();
        expected.add(new SessionFormation(1, 1, LocalDateTime.of(2018, Month.MAY, 7, 9, 0, 0), LocalDateTime.of(2018, Month.MAY, 7, 18, 0, 0), true));
        expected.add(new SessionFormation(3, 1, LocalDateTime.of(2018, Month.JUNE, 10, 9, 0, 0), LocalDateTime.of(2018, Month.JUNE, 11, 18, 0, 0), true));

        SessionFormationDao sessionFormation = new SessionFormationDao();
        List<SessionFormation> result = sessionFormation.getOuvertes();

        assertArrayEquals(expected.toArray(), result.toArray());
    }

}
