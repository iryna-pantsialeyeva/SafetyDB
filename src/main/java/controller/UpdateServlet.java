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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    private ADRService adrService;

    public UpdateServlet() {
        adrService = new ADRServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String date = request.getParameter("report_date");
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
                adrService.update(id, date, description, suspectedDrug, outcome, criteria, userEmail, reporterFullName,
                        reporterType, nameGivenByReporter, timeRelationship, withdrawalResult, reintroductionResult,
                        otherExplanation);
            } catch (ServiceException e) {
                throw new ServletException(e.getMessage());
            }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Adverse reaction was successfully updated.</h2>");
        writer.println("</br>");
        writer.println("<h4><a href=\"main_page.jsp\">Return to main page</a></h4>");
        writer.close();
        }
}
