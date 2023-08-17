<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Texas login</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
<div class="min-h-screen flex items-center justify-center">
    <div class="max-w-md w-full p-6 bg-white rounded-lg shadow-lg">
        <div class="flex justify-center mb-8">
            <img src="https://texascollege.edu.np/wp-content/uploads/2021/04/texas-logo.png" alt="Logo"
                 class="w-30 h-20">
        </div>
        <h1 class="text-2xl font-semibold text-center text-gray-500 mt-8 mb-6">Please Login</h1>
        <c:if test="${not empty errorMessage}">
            <div class="text-pink-500 bg-gray-100 animate-bounce">
                <div class="text-center"><c:out value="${errorMessage}"/></div>
            </div>
        </c:if>
        <form method="post" action="login">
            <div class="mb-6">
                <label for="username" class="block mb-2 text-sm text-gray-600">User Name</label>
                <input type="username" id="username" name="username"
                       class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-cyan-500"
                       required>
            </div>
            <div class="mb-6">
                <label for="password" class="block mb-2 text-sm text-gray-600">PAssword</label>
                <input type="password" id="password" name="password"
                       class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-cyan-500"
                       required>
                <a href="#" class="block text-right text-xs text-cyan-600 mt-2">Forgot password?</a>
            </div>
            <button type="submit"
                    class="w-32 bg-gradient-to-r from-gray-400 to-gray-600 text-white py-2 rounded-lg mx-auto block focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-cyan-500 mt-4 mb-6">
                Login
            </button>
        </form>
        <div class="text-center">
            <p class="text-sm">have no account? <a href="#" class="text-cyan-600">Register here</a></p>
        </div>
        <p class="text-xs text-gray-600 text-center mt-10"> Powered by Texas BCA student</p>
    </div>
</div>
</body>
</html>
