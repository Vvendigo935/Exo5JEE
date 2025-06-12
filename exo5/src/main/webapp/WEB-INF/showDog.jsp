<%@ page import="org.example.exo5.entity.Dog" %>
<%@page import="org.example.exo5.DAO.DogDAO" %>
<jsp:useBean id="dogs" type="java.util.ArrayList<org.example.exo5.entity.Dog>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

 <% DogDAO dogDAO = new DogDAO(); %>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <title>Dog list</title>
</head>
<body>
<main class="container">

    <% if (dogDAO.getAllDog().isEmpty()){ %>
    <tr>
        <td class="table table-dark text-center align-middle"> No Doggo found at the moment :( </td>
    </tr>
    <% } else { %>

    <h1>List of the dogs</h1>

    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>Number</th>
            <th>Name</th>
            <th>Breed</th>
            <th>Birth date</th>
        </tr>
        </thead>
        <tbody>

        <% for (Dog d : dogDAO.getAllDog()) {%>
        <tr>


            <td> <%= d.getId()%> </td>
            <td> <%= d.getName()%> </td>
            <td> <%= d.getBreed()%> </td>
            <td> <%= d.getDateOfBirth()%> </td>
        </tr>
        <% } %>

        <% } %>


        </tbody>
    </table>
</main>
<a href="index.jsp" class="text-baseline">retour</a>
</body>
</html>