<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détails de l'utilisateur</title>
</head>
<body>
    <h1>Détails de l'utilisateur</h1>
        <table>
            <tr>
                <th>ID</th>
                <th><s:property value="user.id"/></th>
            </tr>
            <tr>
                <th>Name</th>
                <td><s:property value="user.name"/></td>
            </tr>
        </table>
    <s:url var="updateUserUrl" action="updateUser">
        <s:param name="id" value="%{user.id}"/>
    </s:url>
    <s:a href="%{updateUserUrl}">Mettre à jour l'utilisateur</s:a>
</body>
</html>
