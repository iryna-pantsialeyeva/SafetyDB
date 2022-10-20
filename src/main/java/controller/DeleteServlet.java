package controller;

import service.ADRService;
import service.impl.ADRServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private ADRService adrService;

    public DeleteServlet() {
        this.adrService = new ADRServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        adrService.delete(Integer.parseInt(request.getParameter("id")));
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Adverse reaction was deleted.</h2>");
        writer.println("</br>");
        writer.println("<h4><a href=\"index.jsp\">Return to main page</a></h4>");
        writer.close();
    }
}
