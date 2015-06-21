<%--
  Created by IntelliJ IDEA.
  User: perdonare
  Date: 2015/6/20
  Time: 9:51
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
        <table border="1">
            <tr bgcolor="#f5f5dc">
                <th>ID</th>
                <th>流程名称</th>
                <th>流程主键</th>
                <th>版本</th>
                <th>文件名</th>
                <th>部署ID</th>
                <th>查看流程图</th>
                <th><删除流程</th>
            </tr>
            <c:forEach begin="1" items="${processDefinitions}" step="1" var="processDefinition">
                <tr bgcolor="#f0f8ff">
                    <td>${processDefinition.id}</td>
                    <td>${processDefinition.name}</td>
                    <td>${processDefinition.key}</td>
                    <td>${processDefinition.version}</td>
                    <td>${processDefinition.resourceName}</td>
                    <td>${processDefinition.deploymentId}</td>
                    <th><a href="showPic?deploymentId=${processDefinition.deploymentId}&diagramResourceName=${processDefinition.diagramResourceName}">查看流程图</a> </th>
                    <th><a href="delete?deploymentId=${processDefinition.deploymentId}">删除流程</a> </th>
                </tr>
            </c:forEach>
        </table>
    </div>

    <br/>
    <br/>
    <div>
        <form method="post" action="/activiti/deploy-process" enctype="multipart/form-data">
        <input type="text" name="name">
        <input type="file" name="deploy-file">
        <input type="submit" value="submit">
    </form>
    </div>
</body>
</html>
