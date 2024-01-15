<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Samochody</title>
</head>
<body>
<h1>Wyszukane samochody:</h1>
<table>
    <tr>
        <th>Rodzaj</th>
        <th>Marka</th>
        <th>Rok produkcji</th>
        <th>Zużycie paliwa</th>
    </tr>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.rodzaj}</td>
            <td>${car.marka}</td>
            <td>${car.rokProdukcji}</td>
            <td>${car.zużyciePaliwa}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
