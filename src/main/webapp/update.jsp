<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Adverse Reaction</title>
</head>
<body>
<form action="update" method="post">
    <table>
        <tr>
            <td>Adverse reaction id:</td>
            <td><input type="text" name="id" value="<c:out value="${adverse_reaction.id}"/>" readonly></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" placeholder="Enter description"
                       value="<c:out value="${adverse_reaction.description}"></c:out> " required></td>
        </tr>
        <tr>
            <td>Suspected drug:</td>
            <td><input type="text" name="suspected_drug" placeholder="Enter suspected drug"
                       value="<c:out value="${adverse_reaction.suspectedDrug}"></c:out>" required></td>
        </tr>
        <tr>
            <td>Outcome:</td>
            <td>current value: <c:out value="${adverse_reaction.outcome.label}"/></td>
            <td>Select new value (if applicable):</td>
            <td><select name="outcome">
                <c:forEach var="outcome" items="${outcome_list}">
                    <option><c:out value="${outcome}"/></option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>Criteria:</td>
            <td>current value: <c:out value="${adverse_reaction.criteria.label}"/></td>
            <td>Select new value (if applicable):</td>
            <td><select name="criteria">
                <c:forEach var="criteria" items="${criteria_list}">
                    <option><c:out value="${criteria}"/> </option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>Relationship type:</td>

        </tr>
        <tr>
            <td>Time relationship:</td>

        </tr>
        <tr>
            <td>Withdrawal result:</td>

        </tr>
        <tr>
            <td>Reintroduction result:</td>

        <tr>
            <td>Other explanation:</td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
            <td style="color: darkblue">
                <c:if test="${error_update != null}">
                    <c:out value="${error_update}"/>
                    <a href="index.jsp">Return to the main page</a>
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
