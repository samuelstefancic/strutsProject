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
<s:form action="createCar.action">
  <s:textfield name="car.couleur" label="Couleur"/>
  <s:textfield name="car.poids" label="Poids"/>
  <s:textfield name="car.typeCarburant" label="Type de carburant"/>
  <s:textfield name="car.nombreDisponible" label="Nombre disponible"/>
  <s:select name="car.modele.id" label="Modèle" list="modeles" listKey="id" listValue="nom" />
  <s:submit value="Ajouter la voiture"/>
</s:form>
</body>
</html>
