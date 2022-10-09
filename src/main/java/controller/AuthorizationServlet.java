package controller;

import model.User;
import service.ServiceException;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    private UserService userService;

    public AuthorizationServlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userService.authorization(email);
            if (!user.getEmail().equals(email)) {
                request.setAttribute("error_authorization", "E-mail is not found in the database.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (!user.getPassword().equals(password)) {
                request.setAttribute("error_password", "Password is not correct.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("login", user.getEmail());
                request.getRequestDispatcher("main_page.jsp").forward(request, response);
            }

        } catch (ServiceException e) {
            String exceptionMessage = e.getMessage();
            request.setAttribute("error_authorization", exceptionMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
