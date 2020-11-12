package Controller;

import DAO.eventDAO;
import entity.event;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private eventDAO eDAO = new eventDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    openForm(request, response);
                    break;
                case "/insert":
                    insertEvent(request, response);
                    break;
                case "/delete":
                    deleteEvent(request, response);
                    break;
                case "/edit":
                    editForm(request, response);
                    break;
                case "/update":
                    updateEvent(request, response);
                    break;
                default:
                    listEvent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<event> listevent = eDAO.listAllEvents();
        request.setAttribute("listevent", listevent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("eventlisting.jsp");
        dispatcher.forward(request, response);
    }

    private void openForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("eventForm.jsp");
        dispatcher.forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        event existingEvent = eDAO.getEvent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("eventForm.jsp");
        request.setAttribute("e", existingEvent);
        dispatcher.forward(request, response);

    }

    private void insertEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String location = request.getParameter("location");

        event e = new event(name, location);
        eDAO.insertEvent(e);
        response.sendRedirect("list");
    }

    private void updateEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String location = request.getParameter("location");


        event e = new event(id,name, location);
        eDAO.updateEvent(e);
        response.sendRedirect("list");
    }

    private void deleteEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        event e = new event(id);
        eDAO.deleteEvent(e);
        response.sendRedirect("list");

    }
}
