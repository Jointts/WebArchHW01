import Controllers.Poetry;
import Controllers.PoetryDAOImpl;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by pagulane on 28.03.16.
 */

public class PoetryTest{

    PoetryDAOImpl poetryDAO = new PoetryDAOImpl();

    @Test
    public void findAll() throws SQLException {
        List<Poetry> poetryList = poetryDAO.findAll();
        assertTrue(poetryList.size() == 3);
    }

    @Test
    public void findById() throws SQLException {
        Poetry poetry = poetryDAO.findById(1);
        assertEquals("Invictus", poetry.getTitle());
    }

    @Test
    public void update() throws SQLException {
        Poetry poetryTest = new Poetry();
        poetryTest.setId(1);
        poetryTest.setTitle("TestTitle");
        poetryTest.setContent("TestContent");
        poetryTest.setYear(2000);
        poetryDAO.update(poetryTest);
        assertEquals(poetryDAO.findById(1).getTitle(), "TestTitle");

        //  Revert back to original title
        poetryTest.setTitle("Invictus");
        poetryDAO.update(poetryTest);
    }

}
