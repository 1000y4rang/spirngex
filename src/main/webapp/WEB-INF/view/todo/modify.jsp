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

<body>
    <div class="card-body">
        <form action="/todo/modify" method="post">
            <input type="hidden" name="page" value="${pageRequestDTO.page}">
            <input type="hidden" name="size" value="${pageRequestDTO.size}">
            <div class="input-group mb-3">
                <span class="input-group-text">Tno : </span>
                <input type="text" name="tno" class="form-control" value=<c:out value="${dto.tno}"/> readonly>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Title : </span>
                <input type="text" name="title" class="form-control" value=<c:out value="${dto.title}"/>>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">DueDate : </span>
                <input type="date" name="dueDate" class="form-control" value=<c:out value="${dto.dueDate}"/>>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Writer : </span>
                <input type="text" name="writer" class="form-control" value=<c:out value="${dto.writer}"/> readonly>
            </div>
            <div class="form-check">
                <label class="form-check-label">
                    Finished :
                </label>
                <input type="checkbox" name="finished" class="form-check-input" ${dto.finished ? "checked" : ""}>
            </div>
            <div class="mb-4">
                <div class="float-end">
                    <button type="button" class="btn btn-danger">Remove</button>
                    <button type="button" class="btn btn-primary">Modify</button>
                    <button type="button" class="btn btn-secondary">List</button>
                </div>
            </div>
        </form>
        <%--<script>
            // 작동안함
            // @Valid에서 문제 발생시
            const serverValidResult = {};
            <c:forEach items="${errors}" var="error">
            serverValidResult['${error.getField()}'] = '${error.defaultMessage}';
            </c:forEach>
            console.log(serverValidResult)
        </script>--%>

    <%--    <div class="row footer">
            <div class="row fixed-bottom" style="z-index: -100">
                <footer class="py-1 my-1">
                    <p class="text-center text-muted">Footer</p>
                </footer>
            </div>
        </div>--%>
    </div>
</body>
<script>
    /*스크립트가 body 아래에 있어야 먹힌다. 설정 잘못된 듯 */
    // 삭제 버튼 클릭
    const formObj = document.querySelector("form");
    document.querySelector(".btn-danger").addEventListener("click", function (e){

        e.preventDefault();
        e.stopPropagation();

        formObj.action = "/todo/remove";
        formObj.method = "post";
        formObj.submit();

    }, false);

    // 수정 버튼 클릭
    document.querySelector(".btn-primary").addEventListener("click", function(e){
        e.preventDefault();
        e.stopPropagation();

        formObj.action = "/todo/modify";
        formObj.method = "post";
        formObj.submit();

    }, false);

    // 리스트 버튼 클릭
    document.querySelector(".btn-secondary").addEventListener("click", function(e){
        self.location = `/todo/list?${pageRequestDTO.link}`;
    }, false);


</script>
</html>
