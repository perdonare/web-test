<%--
  Created by IntelliJ IDEA.
  User: perdonare
  Date: 2015/6/16
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    success user:${sessionScope.get("username")}
    <a href="/activiti/view">查看我的工作流</a>
    <a href="/activiti/show">查看流程部署</a>
</body>
</html>
