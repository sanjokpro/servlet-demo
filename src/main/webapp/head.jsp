<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="datasource.jsp" %>
<sql:query dataSource="${generator}" var="universitys">
    SELECT univ_name,univ_id from university;
</sql:query>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
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
            width: 4rem;
            height: 2rem;
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
