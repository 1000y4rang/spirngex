<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 7. 16.
  Time: 오후 5:56
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

  <title>목록조회</title>
</head>
<body>
  <div class="card-body">
    <h5 class="card-title">
      Special title treatment
    </h5>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">tno</th>
          <th scope="col">title</th>
          <th scope="col">writer</th>
          <th scope="col">dueDate</th>
          <th scope="col">finished</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${dtoList}" var="dto">
        <tr>
          <th scope="row"><c:out value="${dto.tno}"/> </th>
          <td>
            <a href="/todo/read?tno=${dto.tno}" class="text-decoration-none">
              <c:out value="${dto.title}"/>
            </a>
          </td>
          <td><c:out value="${dto.writer}"/></td>
          <td><c:out value="${dto.dueDate}"/></td>
          <td><c:out value="${dto.finished}"/></td>
        </tr>
      </c:forEach>

      </tbody>
    </table>
  </div>
</body>
</html>
