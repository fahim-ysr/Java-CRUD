<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

</<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add a book</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
</head>

<body>

<div class="container">
    <h1 class="p-3">Add a book</h1>

    <form:form action="/saveBook" method="post" modelAttribute="book">

        <%--Name Input--%>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="name">Name</label>
                <div class="col-md-6">
                    <form:input type="text" path="name" id="name" class="form-control input-sm" required="required"/>
                </div>
            </div>
        </div>

        <%--Year Input--%>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="year">Year</label>
                <div class="col-md-6">
                    <form:input type="number" path="year" id="year" class="form-control input-sm" required="required"/>
                </div>
            </div>
        </div>

        <%--Save Button--%>
        <div class="row p-2">
            <div class="col-md-2">
                <button type="submit" value="Register" class="btn btn-success">Save</button>
            </div>
        </div>

    </form:form>

</div>

</body>
</html>