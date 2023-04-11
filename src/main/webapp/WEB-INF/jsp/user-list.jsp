<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="{users}" var="user">
                <tr>
                    <td><s:property value="user.id" /></td>
                    <td><s:property value="user.name"/></td>
                    <td class="actions">

                        <!-- Récupérer les détails de l'utilisateur -->

                        <s:url var="userDetailsUrl" action="getUser">
                            <s:param name="id" value="%{user.id}"/>
                        </s:url>
                        <s:a href="%{userDetailsUrl}">Voir les détails de l'utilisateur</s:a>

                        <!-- Supprimer l'utilisateur -->

                        <s:url var="userDeleteUrl" action="deleteUser">
                            <s:param name="id" value="%{user.id}"/>
                        </s:url>
                        <s:a href="%{userDeleteUrl}">
                            Supprimer l'utilisateur
                        </s:a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    <!-- Ajouter un nouvel utilisateur -->

    <s:url var="userAjoutUrl" action="createUser"/>
    <s:a href="%{userAjoutUrl}">Créer un nouvel utilisateur</s:a>

</body>
</html>
<!-- A garder pour la syntaxe posthume
<td><s:property value="id"/></td>
<td><s:property value="name"/></td>-->