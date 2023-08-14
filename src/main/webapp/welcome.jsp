<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Mi aplicación</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <style>
        .sidebar {
            width: 16rem;
            transition: width 0.3s;
        }

        .sidebar-collapsed {
            width: 5rem;
        }

        .logo-collapsed {
            width: 2rem;
        }

        .thin-space {
            width: 1rem;
        }

        .sidebar-item {
            display: flex;
            align-items: center;
            padding: 0.5rem 1rem;
        }

        .sidebar-icon {
            width: 2rem;
            height: 2rem;
            margin-right: 1rem;
        }

        .sidebar-icon svg {
            width: 100%;
            height: 100%;
            fill: currentColor;
        }

        .sidebar-text {
            display: block;
        }

        .sidebar-collapsed .sidebar-text {
            opacity: 0; /* Hide text */
            width: 0;
            overflow: hidden;
        }

        .user-info {
            display: flex;
            align-items: center;
        }

        .user-icon {
            width: 1.5rem;
            margin-right: 0.5rem;
        }
    </style>
</head>
<body class="bg-gray-100">
<div class="flex h-screen bg-gray-100">
    <!-- Sidebar -->
    <nav class="sidebar bg-white transition-all duration-300">
        <!-- Sidebar content goes here -->
        <div class="py-4 px-4">
            <img src="https://texascollege.edu.np/wp-content/uploads/2021/04/texas-logo.png" alt="Logo"
                 class="w-30 h-20 logo-normal mb-4 transition-all duration-300">

            <c:forEach items="${options}" var="option">
                <div class="sidebar-item">
                    <div class="sidebar-icon bg-cyan-500 rounded-full flex items-center justify-center">
                        <svg class="w-6 h-6" viewBox="0 0 24 24">
                            <path fill="white" d="M4 6h16v12H4V6zm12 4h2v4h-2v-4z"></path>
                        </svg>
                    </div>
                    <span class="sidebar-text"><c:out value="${option}"/></span>
                </div>
            </c:forEach>

            <!-- Add more sidebar items here -->
        </div>
    </nav>

    <!-- Thin Space -->
    <div class="thin-space"></div>

    <!-- Main Content -->
    <div class="flex-1 overflow-x-hidden overflow-y-auto">
        <!-- Header -->
        <header class="bg-white p-4 flex justify-between items-center">
            <button id="sidebarToggle" class="text-gray-500 focus:outline-none">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor"
                     class="w-6 h-6">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M4 6h16M4 12h8m-8 6h16"></path>
                </svg>
            </button>
            <div class="user-info flex items-center">
                <div class="user-icon bg-cyan-500 rounded-full flex items-center justify-center">
                    <svg class="w-6 h-6" viewBox="0 0 24 24">
                        <path fill="white"
                              d="M9 2a7 7 0 0 1 6.062 3.499c-.039.16-.183.525-.438.72 2.13.526 3.89 1.576 5.174 3.063a8.001 8.001 0 0 1-6.89 12.3 8 8 0 0 1-12.29 7.1 8.003 8.003 0 0 1 10.036-11.927c.366-.65.744-1.456.766-1.6A6.963 6.963 0 0 1 9 2zm-4.28 17.464a5.989 5.989 0 0 0 4.274 2.828 5.989  5.989 0 0 0 4.274-2.828c.348-.619.706-1.386.715-1.529a4.996 4.996 0 0 0-9.898-.224c.011.143.369.91.717 1.53zm7.28-6.464c2.761 0 5-2.239 5-5s-2.239-5-5-5-5 2.239-5 5 2.239 5 5 5zm0-9a3.001 3.001 0 0 1 0 6 3.001 3.001 0 0 1 0-6zm0 4a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"></path>
                    </svg>
                </div>
                <div class="ml-2">

                    <span class="block text-gray-600 text-sm"> ${sessionScope.currentUser.username}</span>
                    <button class="block text-cyan-600 text-xs mt-1">Logout</button>
                </div>
            </div>
        </header>


        <!-- Body -->
        <main class="p-6">
            <h1 class="text-2xl font-semibold text-gray-500 mb-6">Welcome to the Dashboard</h1>
            <!-- Dashboard content goes here -->
        </main>
    </div>
</div>

<!-- Footer -->
<footer class="bg-white p-4 text-center">
    Powered by Texas BCA student
</footer>

<script>
    const logo = document.querySelector('.logo-normal');

    document.getElementById('sidebarToggle').addEventListener('click', () => {
        const sidebar = document.querySelector('.sidebar');
        sidebar.classList.toggle('sidebar-collapsed');
        logo.classList.toggle('logo-collapsed');
    });
</script>
</body>
</html>
