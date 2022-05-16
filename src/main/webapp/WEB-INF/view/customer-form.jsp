<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi o Aggiorna Cliente</title>

    <h2>Aggiungi o Aggiorna Cliente</h2>
</head>
<body>

<form:form action="saveCustomer" modelAttribute="customer" method="post">

    <table>
        <form:input type="hidden" path="id" />
        <tr>
            <td><label>First Name:</label></td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td><label>Last Name:</label></td>
            <td><form:input path="lastName" /></td>
        </tr>
         <tr>
             <td><label>Email:</label></td>
             <td><form:input path="email" /></td>
         </tr>
          <tr>
            <td> &nbsp; </td>
            <td><input type="submit" value="Salva"></td>
          </tr>

    </table>
</form:form>

<p>
    <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
</p>

</body>
</html>
