<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@include file="../../jspf/datasource.jspf"%>--%>
${param["username"]}
<c:if
        test="${!empty sessionScope.currentSessionUser or !null==sessionScope.currentSessionUser}">
    <c:redirect url="welcome.jsp"></c:redirect>
</c:if>

<html>
<head>
    <title>Login Form</title>
</head>
<body>
<form method="post" action="login">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
