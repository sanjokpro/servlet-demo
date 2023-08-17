<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource var="generator"
                   driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3307/question_generator"
                   user="sanjok"
                   password="sanjok"/>