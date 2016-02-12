<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>
<html>
<style>
table {
    border-collapse: collapse;
    width: 80%;
}

th, td {
    text-align: left;
    padding: 8px;
}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
<h2>В базе данных содержатся следующие элементы:</h2>
<body>

<table border='1'>
<tr>
<th><b>Код</b></th>
<th><b>Наименование</b></th>
<th><b>Цена</b></th>
<th><b>Дата</b></th>
</tr>

<c:forEach var="element" items="${myList}">
    <tr><td>${element.key}</td><td>${element.name}</td><td>${element.price}</td><td>${element.date}</td></tr>
</c:forEach>
 </body>
</html>