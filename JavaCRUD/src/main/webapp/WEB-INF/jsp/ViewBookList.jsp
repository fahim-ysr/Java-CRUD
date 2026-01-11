<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

</<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View Book List</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>

    <style>
        a {
            color: white;
        }

        a:hover {
            color: white;
            text-decoration: none;
        }

    </style>

</head>
<body>

<div class="container">
    <h1 class="p-3">Book List</h1>

    <form:form>
        <table class="table table-borderd">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Year</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.year}</td>
                        <%--Edit Button--%>
                    <td>
                        <button type="button" class="btn btn-success">
                            <a href="/editBook/${book.id}">Edit</a>
                        </button>
                    </td>
                        <%--Edit Button--%>
                    <td>
                        <button type="button" class="btn btn-danger">
                            <a href="/deleteBook/${book.id}">Delete</a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </form:form>

    <%--Delete Button--%>

    <button type="button" class="btn btn-primary btn-block">
        <a href="/addBook">Add New Book</a>
    </button>

</div>

</body>
</html>