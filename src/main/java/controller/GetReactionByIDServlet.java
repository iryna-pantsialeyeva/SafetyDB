package controller;

import model.AdverseReaction;
import model.Criteria;
import model.Outcome;
import service.ADRService;
import service.impl.ADRServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/get_reaction")
public class GetReactionByIDServlet extends HttpServlet {

    private ADRService adrService;

    public GetReactionByIDServlet() {
        this.adrService = new ADRServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        String action = request.getParameter("action");
        String stringId = request.getParameter("id");
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            request.setAttribute("idError", "Try again. Please enter the number.");
            getServletContext().getRequestDispatcher("/getReaction_page.jsp").forward(request, response);
        }
        AdverseReaction adverseReaction = adrService.getByID(id);
        if (adverseReaction.getId() == 0) {
            request.setAttribute("idError", "Adverse reaction with id " + id + " not found. Try again.");
            getServletContext().getRequestDispatcher("/getReaction_page.jsp").forward(request, response);
        } else {
            if(action.equals("Update adverse reaction")){
                request.setAttribute("adverse_reaction", adverseReaction);
                List<String> outcomeList = Arrays.stream(Outcome.values()).map(Outcome::getLabel).collect(Collectors.toList());
                List<String> criteriaList = Arrays.stream(Criteria.values()).map(Criteria::getLabel).collect(Collectors.toList());
                request.setAttribute("outcome_list", outcomeList);
                request.setAttribute("criteria_list", criteriaList);
                getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
            } else {
                request.setAttribute("id", stringId);
                getServletContext().getRequestDispatcher("/delete").forward(request, response);
            }
        }
    }
}
