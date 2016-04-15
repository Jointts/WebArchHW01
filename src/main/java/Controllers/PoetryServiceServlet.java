package Controllers;

import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by pagulane on 27.03.16.
 */

@WebServlet(urlPatterns = "/poetry/poetryservice", loadOnStartup = 1)
public class PoetryServiceServlet extends HttpServlet{

    PoetryDAOImpl poetryDAO = new PoetryDAOImpl();

    public void init() throws ServletException
    {
        // Do required initialization
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");
        int id = 0;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }

        Gson gson = new Gson();
        String json = null;
        try {
            json = gson.toJson(poetryDAO.findById(id));
        } catch (SQLException e) {
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }
        PrintWriter out = response.getWriter();
        out.print(json);
    }
}
