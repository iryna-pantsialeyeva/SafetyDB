package controller;

import mapper.AdverseReactionMapper;
import mapper.AdverseReactionMapperImpl;
import model.*;
import service.ADRService;
import service.ServiceException;
import service.impl.ADRServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {

    private ADRService adrService;
    private AdverseReactionMapper arMapper;

    public SaveServlet() {
        adrService = new ADRServiceImpl();
        this.arMapper = new AdverseReactionMapperImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        String description = request.getParameter("description");
        String suspectedDrug = request.getParameter("suspected_drug");
        String outcome = request.getParameter("outcome");
        String criteria = request.getParameter("criteria");
        String supposedDrugOutcomeCriteria = request.getParameter("supposed_drug_outcome_criteria");
        String dependsOnTime = request.getParameter("effect_depends_on_time");
        String dependsOnDrugCancellation = request.getParameter("effect_depends_on_drug_cancellation");
        String dependsOnDrugReturn = request.getParameter("effect_depends_on_drug_return");
        String otherPossibleExplanation = request.getParameter("other_explanation");

        //TODO replace user with real one
        AdverseReaction adverseReaction = arMapper.fromFields(description, suspectedDrug, outcome, criteria,
                new User(0), supposedDrugOutcomeCriteria, dependsOnTime,
                dependsOnDrugCancellation, dependsOnDrugReturn, otherPossibleExplanation);

        try {
            adrService.save(adverseReaction);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Adverse reaction was successfully saved.</h2>");
        writer.println("<h4> ");
        writer.println("</h4>");
        writer.println("</br>");
        writer.println("<h4><a href=\"index.jsp\">Return to main page</a></h4>");
        writer.close();
    }
}
