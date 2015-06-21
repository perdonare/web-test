<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: perdonare
  Date: 2015/6/21
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <a href="add">添加流程</a>
</div>
<div>
    <table border="1">
        <tr>
            <th>标题</th>
            <th>内容</th>
            <th>内请假天数</th>
            <th>创建时间</th>
            <th>流程状态</th>
            <th>修改</th>
            <th>删除</th>
            <th>签收</th>
            <th>审核</th>
        </tr>sdfsd
        <%
            List list = (List) pageContext.getServletContext().getAttribute("userLeavePOs");
            for(Object o : list){
                System.out.println("aas");
            }

        %>
        <c:forEach begin="1" var="userLeavePO" items="userLeavePOs" step="1">sd
            <tr>
                <td>${userLeavePO.title}</td>
                <td>${userLeavePO.content}</td>
                <td>${userLeavePO.days}</td>
                <td>${userLeavePO.createTime}</td>
                <td>${userLeavePO.status}</td>sdfsdf
                <td><a href="edit?userId=${userLeave.id}">修改</a></td>
                <td><a href="delete?userId=${userLeave.id}">删除</a></td>
                <td><a href="claim?userId=${userLeave.id}">签收</a></td>
                <td><a href="check?userId=${userLeave.id}">审核</a></td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>