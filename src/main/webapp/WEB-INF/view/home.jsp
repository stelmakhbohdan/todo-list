<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="myAcademy.learning.util.Mappings" %>
<html>
<head>
    <title>Todo List Application</title>
</head>
<body>
<div align="center">
    <c:url var="itemsLihk" value="${Mappings.ITEMS}"/>
    <h2><a href="${itemsLihk}">Show Todo Items</a></h2>
</div>

</body>
</html>