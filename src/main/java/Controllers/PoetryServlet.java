package Controllers;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pagulane on 27.03.16.
 */

@WebServlet(urlPatterns = "/poetry/s", loadOnStartup = 1)
public class PoetryServlet extends HttpServlet {

    PoetryDAOImpl poetryDAO = new PoetryDAOImpl();
    final static Logger logger = Logger.getLogger(PoetryServlet.class);

    public void init() throws ServletException
    {
        logger.info("Servlet Initialized!");
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        int id = 0;
        boolean error = false;
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("");

        if(request.getParameter("id") != null) {
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e) {
                error = true;
            }
        }

        if(id != 0){
            try {
                logger.info("Poetry with id " + id + " accessed!");
                request.setAttribute("poetry", poetryDAO.findById(id));
                rd = request.getRequestDispatcher("/WEB-INF/views/poetryDetail.jsp");
            } catch (SQLException e) {
                error = true;
            }
        }else{
            try {
                logger.info("Poetry list accessed!");
                request.setAttribute("poetryList", poetryDAO.findAll());
                rd = request.getRequestDispatcher("/WEB-INF/views/poetryList.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(error){
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }else{
            rd.forward(request, response);
        }

    }

    public void doPost(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException
    {
        PoetryForm poetryForm = new PoetryForm();
        poetryForm.setId(Integer.parseInt(request.getParameter("id")));
        poetryForm.setTitle(request.getParameter("title"));
        poetryForm.setContent(request.getParameter("content"));
        poetryForm.setYear(Integer.parseInt(request.getParameter("year")));

        PoetryValidator poetryValidator = new PoetryValidator(poetryForm);
        List<String> errorList = poetryValidator.validateForm();
        if(errorList.size() == 0){
            try {
                logger.info("Poetry with id " + request.getParameter("id") + " edited!");
                poetryDAO.update(poetryValidator.convertToPoetry());
                request.setAttribute("poetry", poetryDAO.findById(poetryForm.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            request.setAttribute("errorList", errorList);
            request.setAttribute("poetry", poetryForm);
        }
        request.getRequestDispatcher("/WEB-INF/views/poetryDetail.jsp").forward(request, response);
    }

}
