<html>
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<body>
<form action="authorization" method="post">
    <table>
        <tr>
            <td>E-mail</td>
            <td><input type="text" name="email" placeholder="Enter your e-mail" required></td>
            <td style="color: red">
                <% if (request.getAttribute("error_authorization") != null) { %>
                <p>
                    <%=request.getAttribute("error_authorization")%>
                    <% ;
                    } %>
                </p>
            </td>
        </tr>
        <br/>
        <br/>
        <br/>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" placeholder="Enter your password" required></td>
            <td style="color: red">
                <% if (request.getAttribute("error_password") != null) { %>
                <p>
                    <%=request.getAttribute("error_password")%>
                    <% ;
                    } %>
                </p>
            </td>
        </tr>
        <br/>
        <br/>
        <tr>
            <td><input style="background: lightskyblue" type="submit" value="Login"/></td>
        </tr>
    </table>
</form>
</body>
</html>
