<%--
  Created by IntelliJ IDEA.
  User: jionghong
  Date: 11/11/2020
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Event list</title>
</head>
<body>
<div align="center">
    <c:if test="${e!= null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${e == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" style="border-collapse: collapse">
                <caption>
                    <h2>
                        <c:if test="${e != null}">
                            Edit Event
                        </c:if>
                        <c:if test="${e == null}">
                            Add New Event
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${e != null}">
                    <input type="hidden" name="id" value="<c:out value='${e.id}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${e.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Location: </th>
                    <td>
                        <input type="text" name="location" size="45"
                               value="<c:out value='${e.location}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
