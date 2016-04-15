package Controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pagulane on 26.03.16.
 */
interface PoetryDAO {
    List<Poetry> findAll() throws SQLException;
    Poetry findById(int id) throws SQLException;
    void update(Poetry o) throws SQLException;
    Connection databaseConnection();
}
