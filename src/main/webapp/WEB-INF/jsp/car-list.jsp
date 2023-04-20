<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>Détails Car</title>
</head>
<body>
    <h1>Détails Car</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Model</th>
                <th>Actions</th>
            </tr>
            <jsp:useBean id="cars" scope="request" type="java.util.List"/>
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td><s:property value="car.id"/></td>
                    <td><s:property value="car.model"/></td>
                    <td class="actions">

                        <!-- Détails de la voiture -->

                        <s:url var="carDetailsUrl" action="getCar">
                            <s:param name="id" value="%{car.id}"/>
                        </s:url>
                        <s:a href="%{carDetailsUrl}">Details de la voiture</s:a>

                        <!-- Supprimer la voiture -->

                        <s:url var="carDeleteUrl" action="deleteCar">
                            <s:param name="id" value="%{car.id}"/>
                        </s:url>
                        <s:a href="%{carDeleteUrl}">Supprimer la voiture</s:a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    <!-- Ajouter une nouvelle voiture -->
    <s:url var="carAjoutUrl" action="createCar"/>
    <s:a href="%{carAjoutUrl}">Créer une nouvelle voiture</s:a>
</body>
</html>
