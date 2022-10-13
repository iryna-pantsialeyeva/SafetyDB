package controller;

import com.google.protobuf.ServiceException;
import service.ADRService;
import service.impl.ADRServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteServlet {

    private ADRService adrService;

    public DeleteServlet(){
        adrService = new ADRServiceImpl();
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            adrService.delete(id);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Adverse reaction was successfully deleted.</h2>");
        writer.println("<h4> ");
        writer.println("</h4>");
        writer.println("</br>");
        writer.println("<h4><a href=\"main_page.jsp\">Return to main page</a></h4>");
        writer.close();
    }
}
