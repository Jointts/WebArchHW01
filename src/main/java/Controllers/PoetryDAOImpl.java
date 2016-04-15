package Controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pagulane on 26.03.16.
 */
public class PoetryDAOImpl implements PoetryDAO {

    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;

    public List<Poetry> findAll() throws SQLException {
        List<Poetry> poetryList = new ArrayList<Poetry>();
        String findAllQ = "SELECT * FROM poetry";
        connection = databaseConnection();
        statement = connection.createStatement();
        rs = statement.executeQuery(findAllQ);

        while(rs.next()){
            int id = rs.getInt("id");
            String title  = rs.getString("title");
            String content  = rs.getString("content");
            int year = rs.getInt("year");
            Poetry poetry = new Poetry();
            poetry.setId(id);
            poetry.setTitle(title);
            poetry.setContent(content);
            poetry.setYear(year);
            poetryList.add(poetry);
        }

        rs.close();
        statement.close();
        connection.close();
        return poetryList;
    }

    public Poetry findById(int id) throws SQLException {
        String findByIdQ = "SELECT * FROM poetry WHERE id=" +id;
        connection = databaseConnection();
        statement = connection.createStatement();
        rs = statement.executeQuery(findByIdQ);
        Poetry poetry = new Poetry();

        while(rs.next()) {
            String title = rs.getString("title");
            String content = rs.getString("content");
            int year = rs.getInt("year");
            poetry.setId(id);
            poetry.setTitle(title);
            poetry.setContent(content);
            poetry.setYear(year);
        }

        rs.close();
        statement.close();
        connection.close();
        return poetry;
    }

    public void update(Poetry o) throws SQLException {
        String updateQ = "UPDATE poetry SET " +
                "title='" + o.getTitle().replaceAll("'","''") + "', " +
                "content='" + o.getContent().replaceAll("'","''") +"', " +
                "year=" + o.getYear() +
                " WHERE id=" + o.getId() + ";";
        System.out.println(updateQ);
        connection = databaseConnection();
        statement = connection.createStatement();
        statement.executeUpdate(updateQ);

        statement.close();
        connection.close();
    }

    public Connection databaseConnection(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "daPevab8");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }
}
