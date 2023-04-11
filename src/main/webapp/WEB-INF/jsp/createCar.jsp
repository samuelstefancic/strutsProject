<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>Ajouter une nouvelle voiture</title>
</head>
<body>
  <h1>Ajouter une nouvelle voiture</h1>
  <s:form action="createCar">
    <s:textfield name="car.model" label="Modèle"/>
    <s:submit value="Ajouter la voiture"/>
  </s:form>
</body>
</html>
