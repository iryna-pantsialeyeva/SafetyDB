<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Adverse Reaction</title>
</head>
<body>
<h3>User: <%=request.getAttribute("login")%> </h3>
<br/>
<form action="save" method="post">
    <table>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" placeholder="Enter description" required></td>
        </tr>
        <tr>
            <td>Suspected drug:</td>
            <td><input type="text" name="suspected_drug" placeholder="Enter suspected drug" required></td>
        </tr>
        <tr>
            <td>Outcome:</td>
            <td><select name="outcome">
                <option>death</option>
                <option>recovered</option>
                <option>not recovered</option>
                <option>unknown</option>
            </select></td>
        </tr>
        <tr>
            <td>Criteria:</td>
            <td><select name="criteria">
                <option>death</option>
                <option>hospitalisation</option>
                <option>disability or incapacity</option>
                <option>life threatening</option>
                <option>congenital anomaly</option>
                <option>medically important</option>
            </select></td>
        </tr>
        <tr>
            <td>Relationship type:</td>
            <td><select name="supposed_drug_outcome_criteria">
                <option>unclassifiable</option>
                <option>unlikely</option>
                <option>conditional</option>
                <option>possible</option>
                <option>probable</option>
                <option>certain</option>
            </select></td>
        </tr>
        <tr>
            <td>Time relationship:</td>
            <td><select name="effect_depends_on_time">
                <option>yes</option>
                <option>no</option>
                <option>na</option>
            </select></td>
        </tr>
        <tr>
            <td>Withdrawal result:</td>
            <td><select name="effect_depends_on_drug_cancellation">
                <option>yes</option>
                <option>no</option>
                <option>na</option>
            </select></td>
        </tr>
        <tr>
            <td>Reintroduction result:</td>
            <td><select name="effect_depends_on_drug_return">
                <option>yes</option>
                <option>no</option>
                <option>na</option>
            </select></td>
        </tr>
        <tr>
            <td>Other explanation:</td>
            <td><select name="other_explanation">
                <option>yes</option>
                <option>no</option>
                <option>na</option>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form>
</body>
</html>
