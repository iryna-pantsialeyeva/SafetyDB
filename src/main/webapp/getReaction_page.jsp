<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>getReaction</title>
</head>
<body>
<form action="get_reaction" method="get">
  <table>
    <tr>
      <td>Enter adverse reaction id: </td>
      <td>
        <input type="text" name="id" required>
      </td>
      <td style="color: darkblue">
        <c:if test="${idError != null}">
          <c:out value="${idError}"/>
        </c:if>
      </td>
    </tr>
    <tr>
      <td><select name="action">
        <option>Update adverse reaction</option>
        <option>Delete adverse reaction</option>
      </select></td>
    </tr>
    <tr>
      <td><input type="submit" value="Proceed"></td>
    </tr>
  </table>
</form>
</body>
</html>
