<%--
  Created by IntelliJ IDEA.
  User: jionghong
  Date: 11/11/2020
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Event list</title>
</head>
<body>
<div align="center">
    <table border="1" style="border-collapse: collapse">
        <caption><h2>List of Events</h2></caption>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>Location</th>
            <th>Operation</th>
        </tr>
        <c:forEach var="e" items="${listevent}">
            <tr>
                <td><c:out value="${e.id}" /></td>
                <td><c:out value="${e.name}" /></td>
                <td><c:out value="${e.location}" /></td>
                <td>
                    <a  href="/edit?id=<c:out value='${e.id}' />"><span style="color: blue">Edit</span></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a  href="/delete?id=<c:out value='${e.id}' />"><span style="color: red">Delete</span></a>
                </td>

            </tr>

        </c:forEach>
        <tr>
            <td colspan="4" align="center">
                <button style="color: deepskyblue"><a href="/new">Add Event</a></button>
            </td>
        </tr>

    </table>

</div>

</body>
</html>
