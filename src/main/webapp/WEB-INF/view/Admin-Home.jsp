<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Admin-Home</title>
</head>
<body style="background-color:powderblue;">

<h1> <center>Welcome Admin</center></h1>

    <br>
    <table border="1" style="background-color:#33475b;width:50%; color: azure " align="center">

        <tr>
            <td align="center"><button onclick="user()">Search User</button></td>

        </tr>

        <tr>
            <td align="center"><button onclick="category()">Search Category</button></td>

        </tr>

    </table>

<script>
    function user() {
        location.replace("home/searchUser")
    }
    function category() {
        location.replace("home/searchCatagory")
    }
</script>






</body>
</html>
