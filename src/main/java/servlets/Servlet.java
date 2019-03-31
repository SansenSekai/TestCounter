package servlets;

import models.JdbcConnectionModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/")
public class Servlet extends HttpServlet {
    private final static String GET_COUNTER = "SELECT counter FROM counter_table WHERE id = 1";
    private final static String INCREMENT_COUNTER = "UPDATE counter_table SET counter = ";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer counter = null;

        JdbcConnectionModel connectionModel = JdbcConnectionModel.getInstance();
        try {

            Statement statement = connectionModel.getConnection().createStatement();
            ResultSet result = statement.executeQuery(GET_COUNTER);

            while (result.next()) {
                counter = result.getInt("counter");
            }
            req.setAttribute("counter", counter);

            statement.execute(INCREMENT_COUNTER + ++counter);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("test.jsp");
        requestDispatcher.forward(req, resp);
    }
}
