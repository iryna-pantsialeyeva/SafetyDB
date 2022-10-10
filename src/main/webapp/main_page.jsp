<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main page</title>
</head>
<body>
<h3>User: <%=request.getAttribute("login")%> </h3>
<br/>
<form action="getall" method="get">
    <br/>
    <input type="submit" value="Show all"/>
</form>

</body>
</html>
