<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>Détails voiture</title>
</head>
<body>
  <h1>Détails voiture</h1>
  <table>
    <tr>
      <th>ID</th>
      <td><s:property value="car.id"/></td>
    </tr>
    <tr>
      <th>Modèle</th>
      <td><s:property value="car.model"/></td>
    </tr>
  </table>
<s:url var="updateCarUrl" action="updateCar">
  <s:param name="id" value="%{car.id}"/>
</s:url>
<s:a href="%{updateCarUrl}">Modifier la voiture</s:a>
</body>
</html>