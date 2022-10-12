<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main page</title>
</head>
<body>
<h3>User: <%=request.getAttribute("login")%>
</h3>
<br/>
<h3>Choose an action:</h3>
<br/>
<b><a href="getall"> 1. Show all adverse reaction </a></b>
<p>
    <b><a href="save.jsp">2. Add new adverse reaction</a></b>
</p>
</body>
</html>
