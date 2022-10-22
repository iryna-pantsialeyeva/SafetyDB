package controller;

import mapper.AdverseReactionMapper;
import mapper.AdverseReactionMapperImpl;
import model.AdverseReaction;
import model.Criteria;
import model.Outcome;
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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private ADRService adrService;
    private AdverseReactionMapper adverseReactionMapper;

    public UpdateServlet() {
        this.adrService = new ADRServiceImpl();
        this.adverseReactionMapper = new AdverseReactionMapperImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String description = request.getParameter("description");
        String suspectedDrug = request.getParameter("suspected_drug");
        Outcome outcome = Outcome.getOutcomeByLabel(request.getParameter("outcome"));
        Criteria criteria = Criteria.getCriteriaByLabel(request.getParameter("criteria"));
        AdverseReaction adverseReaction = adrService.getByID(id);
        adverseReaction.setDescription(description);
        adverseReaction.setSuspectedDrug(suspectedDrug);
        adverseReaction.setOutcome(outcome);
        adverseReaction.setCriteria(criteria);
        try {
            adrService.update(adverseReaction);
        } catch (ServiceException e) {
            request.setAttribute("error_update", e.getMessage());
            request.getRequestDispatcher("/update.jsp").forward(request,response);
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Adverse reaction was successfully updated.</h2>");
        writer.println("<h4> ");
        writer.println("</h4>");
        writer.println("</br>");
        writer.println("<h4><a href=\"index.jsp\">Return to main page</a></h4>");
        writer.close();
    }
}
