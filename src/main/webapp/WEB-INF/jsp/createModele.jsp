<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<html>
<head>
  <title>Ajouter un modèle</title>
</head>
<body>
<h1>Ajouter un modèle</h1>
<s:form action="createModele">
  <s:textfield name="modele.name" label="Nom du modèle" />
  <s:select label="Marque" name="marqueId" list="Marques" listKey="id" listValue="nom" headerKey="" headerValue="Sélectionner une marque"></s:select>
  <s:submit value="Ajouter le modèle" />
</s:form>
</body>
</html>
