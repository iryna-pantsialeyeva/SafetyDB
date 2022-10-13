<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Adverse Reaction</title>
</head>
<body>
<h3>User: <%=request.getAttribute("login")%>
</h3>
<br/>
<form action="delete" method="delete">
    <table>
        <tr>Adverse Reaction id:</tr>
        <tr><input type="text" name="id" placeholder="Enter id" required></tr>
        <tr><input type="submit" name="Delete"/></tr>
    </table>

</form>
</body>
</html>
