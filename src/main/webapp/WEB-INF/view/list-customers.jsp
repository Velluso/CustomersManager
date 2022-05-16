<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>

        table {
            background-color: rebeccapurple;
            border-color: deeppink;
        }

        a {

            text-decoration: white;
        }

    </style>
</head>
<body>

<input type="button" value="Add Customer"
        onclick="window.location.href='showFormForAdd'; return false;"
/>



<table border="1">

    <tr>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Email</th>
        <th>Action</th>
    </tr>

    <!-- loop e stampa di customers -->
    <c:forEach var="cliente" items="${customers}">

        <!-- costruisco un "update" link con l'id dei customers -->
        <c:url var="updateLink" value="/customer/showFormForUpdate">
            <c:param name="customerId" value="${cliente.id}" />
        </c:url>
        <!-- link delete -->
        <c:url var="deleteLink" value="/customer/delete">
            <c:param name="customerId" value="${cliente.id}" />
        </c:url>


    <tr>
        <td> ${cliente.firstName} </td>
        <td> ${cliente.lastName} </td>
        <td> ${cliente.email} </td>
        <td>
            <a href="${updateLink}">Update</a>

            <a href="${deleteLink}"
                        onclick="if (!confirm('Sei sicuro, ahh?'))
                            return false">
                Delete
            </a>
        </td>
    </tr>

    </c:forEach>

</table>

</body>
</html>
