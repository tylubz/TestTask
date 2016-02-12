<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
<title>Тестовое задание</title>
</head>
<body>
 
    <form method="POST" action="uploadFile" enctype="multipart/form-data">
        <h2>Выберите файл для загрузки</h2>
         <input type="file" name="file"><br /> 
        <h2>Введите имя файла</h2>
         <input type="text" name="name"><br /> <br /> 
        <input type="submit" value="Загрузить"> Загрузить файл на сервер!
    </form>
     
</body>
</html>