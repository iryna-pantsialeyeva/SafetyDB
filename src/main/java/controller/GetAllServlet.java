package controller;

import model.AdverseReaction;
import service.ADRService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/getall")
public class GetAllServlet extends HttpServlet {

    private ADRService adrService; //TODO add implementation

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        List<AdverseReaction> adverseReactionList = new ArrayList<>();

        try{
            writer.println("<h2>Adverse reactions: ");
            for (AdverseReaction adverseReaction : adverseReactionList) {
                writer.println(adverseReaction);
            }
            writer.println("</h2>");
        } finally {
            writer.close();
        }
    }
}
