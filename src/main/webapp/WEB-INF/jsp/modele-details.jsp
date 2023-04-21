<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>Model details</title>
</head>
<body>
  <h1>Details model</h1>

<table>
    <tr>
        <th>ID</th>
        <td><s:property value="modele.id"/></td>
    </tr>
    <tr>
        <th>Nom</th>
        <td><s:property value="modele.name"/></td>
    </tr>
</table>
<s:url var="updateModeleUrl" action="updateModele">
    <s:param name="id" value="%{modele.id}"/>
</s:url>
<s:a href="%{updateModeleUrl}">Modifier le modèle</s:a>
</body>
</html>
