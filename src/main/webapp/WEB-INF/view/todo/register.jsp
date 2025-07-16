<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 7. 16.
  Time: 오전 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<script>
    /*안되는 걸루...*/
    const serverValidResult = {};

    <c:forEach items="${dto_errors}" var="error">
        serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
    </c:forEach>

    console.log(serverValidResult);
</script>
<body>
    <div class="card-body">
        <form action="/todo/register" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">Title : </span>
                <input type="text" name="title" class="form-control" placeholder="Title">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">DueDate : </span>
                <input type="date" name="dueDate" value="2025-07-16" class="form-control" placeholder="DueDate">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Writer : </span>
                <input type="text" name="writer" class="form-control" placeholder="Writer">
            </div>
            <div>
                Finished : <input type="checkbox" name="finished">
            </div>
            <div class="mb-4">
                <div class="float-end">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-secondary">Reset</button>
                </div>
            </div>
            <div class="row footer">
                <div class="row fixed-bottom" style="z-index: -100">
                    <footer class="py-1 my-1">
                        <p class="text-center text-muted">Footer</p>
                    </footer>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
