<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

${sessionScope.username}
    <c:out value="${sessionScope}" />

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
