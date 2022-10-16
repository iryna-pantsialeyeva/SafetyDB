package controller;

import mapper.AdverseReactionMapper;
import mapper.AdverseReactionMapperImpl;
import model.AdverseReaction;
import service.ADRService;
import service.impl.ADRServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/getall")
public class GetAllServlet extends HttpServlet {

    private ADRService adrService;
    private AdverseReactionMapper arMapper;

    public GetAllServlet() {
        adrService = new ADRServiceImpl();
        this.arMapper = new AdverseReactionMapperImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        List<AdverseReaction> dtos = adrService.getAll().stream().map(r -> arMapper.toDto(r)).collect(Collectors.toList());

        try {
            writer.println("<h2>Adverse reactions: </h2>");
            writer.println("<h4> ");
            for (AdverseReaction adverseReaction : dtos) {
                writer.println(adverseReaction);
                writer.println("</br>");
                writer.println("</br>");
            }
            writer.println("</h4>");
            writer.println("</br>");
            writer.println("<h4><a href=\"main_page.jsp\">Return to main page</a></h4>");
        } finally {
            writer.close();
        }
    }
}
