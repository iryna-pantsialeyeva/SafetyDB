package controller;

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

@WebServlet("/getall")
public class GetAllServlet extends HttpServlet {

    private ADRService adrService;
    private Object adrValidator;

    public GetAllServlet() {
        adrService = new ADRServiceImpl();
        adrValidator = new Object();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        List<String> params = request.getAllPArams();
//        MyObj mo = new MyObj(params.get(0)...);
//        try {
//            adrValidator.validate(mo);
//        } catch (MyValidationException ex) {
//            ex.getReson();
//        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        List<AdverseReaction> adverseReactionList = adrService.getAll();

        try {
            writer.println("<h2>Adverse reactions: </h2>");
            writer.println("<h4> ");
            for (AdverseReaction adverseReaction : adverseReactionList) {
                writer.println(adverseReaction);
                writer.println("</br>");
                writer.println("</br>");
            }
            writer.println("</h4>");
        } finally {
            writer.close();
        }
    }
}
