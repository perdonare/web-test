<%--
  Created by IntelliJ IDEA.
  User: perdonare
  Date: 2015/6/20
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:if test="${sessionScope.deployFlag}">
        ${sessionScope.deployFlag}
        部署成功
    </c:if>

</body>
</html>
