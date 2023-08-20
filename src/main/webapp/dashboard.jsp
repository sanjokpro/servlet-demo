<%@include file="head.jsp" %>
<body class="bg-gray-100">
<div class="flex h-screen bg-gray-100">
    <!-- Sidebar -->
    <%@include file="nav-bar.jsp" %>
    <!-- Main Content -->
    <div class="flex-1 overflow-x-hidden overflow-y-auto">

        <%@include file="header.jsp" %>

        <!-- Body -->

        <main class="p-6">
            <h1 class="text-2xl font-semibold text-gray-500 mb-6">Welcome to the Dashboard</h1>
            <h2>Below data was received from university table from your database!!!</h2>
            <c:forEach items="${universitys.rows}" var="university">
                <div>
                    <c:out value="${university}"/>
                </div>
            </c:forEach>
        </main>
    </div>
</div>
<%@include file="footer.jsp" %>