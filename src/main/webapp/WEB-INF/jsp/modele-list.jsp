<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List des modèles</title>
</head>
<body>
    <h1>List des modèles</h1>
    <table>
      <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Actions</th>
      </tr>
      <jsp:useBean id="modeles" scope="request" type="java.util.List"/>
      <c:forEach items="${modeles}" var="modele">
        <tr>
          <td><s:property value="modele.id"/></td>
          <td><s:property value="modele.name"/></td>
          <td class="actions"><
              <s:url var="modele-details.jsp" action="getModele">
                <s:param name="id" value="%{modele.id}"/>
              </s:url>
          <s:a href="%{modeleDetailsUrl}" action="deleteModele">
            Détails du modèle
          </s:a>

            <s:url var="modeleDeleteUrl" action="deleteModele">
                <s:param name="id" value="%{modele.id}"/>
            </s:url>
            <s:a href="%{modeleDeleteUrl}">Supprimer le modèle</s:a>
        </td>
        </tr>
      </c:forEach>
    </table>
<s:url var="modeleAjoutUrl" action="createModele"/>
<s:a href="%{modeleAjoutUrl}">Créer un nouveau modèle</s:a>
</body>
</html>
