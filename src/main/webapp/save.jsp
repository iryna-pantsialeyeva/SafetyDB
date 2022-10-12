<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Adverse Reaction</title>
</head>
<body>
<form action="save" method="post">
    Description: <input type="text" name="description" placeholder="Enter description" required>
    <br>
    Suspected drug: <input type="text" name="suspected_drug" placeholder="Enter suspected drug" required>
    <br>
    Outcome: <select name="outcome">
    <option>death</option>
    <option>recovered</option>
    <option>not recovered</option>
    <option>unknown</option>
</select>
    <br>
    Criteria: <select name="criteria">
    <option>death</option>
    <option>hospitalisation</option>
    <option>disability or incapacity</option>
    <option>life threatening</option>
    <option>congenital anomaly</option>
    <option>medically important</option>
</select>
    <br>
    User e-mail: <input type="text" name="user_email" placeholder="Enter e-mail" required>
    <br>
    Reporter name: <input type="text" name="reporter_full_name" placeholder="Enter name" required>
    <br>
    User e-mail: <input type="text" name="user_email" placeholder="Enter e-mail" required>
    <br>
    Reporter type: <select name="reporter_type">
    <option>health professional</option>
    <option>patient</option>
</select>
    <br>
    Relationship type: <select name="name_given_by_reporter">
    <option>unclassifiable</option>
    <option>unlikely</option>
    <option>conditional</option>
    <option>possible</option>
    <option>probable</option>
    <option>certain</option>
</select>
    <br>
    Time relationship: <select name="time_relationship">
    <option>yes</option>
    <option>no</option>
    <option>na</option>
</select>
    <br>
    Withdrawal result: <select name="withdrawal_result">
    <option>yes</option>
    <option>no</option>
    <option>na</option>
</select>
    <br>
    Reintroduction result: <select name="reintroduction_result">
    <option>yes</option>
    <option>no</option>
    <option>na</option>
</select>
    <br>
    Other explanation: <select name="other_explanation">
    <option>yes</option>
    <option>no</option>
    <option>na</option>
</select>
    <br>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
