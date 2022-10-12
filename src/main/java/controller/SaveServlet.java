package controller;

import com.google.protobuf.ServiceException;
import service.ADRService;
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
//    AuthorizationServlet authorizationServlet;

    public SaveServlet() {
        adrService = new ADRServiceImpl();
//        authorizationServlet = new AuthorizationServlet();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String suspectedDrug = request.getParameter("suspected_drug");
        String outcome = request.getParameter("outcome");
        String criteria = request.getParameter("criteria");
        String userEmail = request.getParameter("user_email");
        String reporterFullName = request.getParameter("reporter_full_name");
        String reporterType = request.getParameter("reporter_type");
        String nameGivenByReporter = request.getParameter("name_given_by_reporter");
        String timeRelationship = request.getParameter("time_relationship");
        String withdrawalResult = request.getParameter("withdrawal_result");
        String reintroductionResult = request.getParameter("reintroduction_result");
        String otherExplanation = request.getParameter("other_explanation");


        try {
            adrService.save(description, suspectedDrug, outcome, criteria, userEmail, reporterFullName, reporterType,
                    nameGivenByReporter, timeRelationship,withdrawalResult, reintroductionResult, otherExplanation);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Adverse reaction was successfully saved.</h2>");
        writer.println("<h4> ");
//        writer.write("Adverse reaction was successfully saved.");
//        writer.flush();
        writer.close();
    }
}
