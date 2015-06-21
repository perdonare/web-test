<%--
  Created by IntelliJ IDEA.
  User: perdonare
  Date: 2015/6/21
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <form method="post" action="addUserLeave">
            请假标题：<input type="text" name="title" style="length:300px" /><br/>
            请假天数：<input type="text" name="days" style="length:300px" /><br/>
            请假说明：<textarea name="content" style="length:300px"></textarea><br/>
            <input type="submit" value="submit"/>
        </form>
    </div>
</body>
</html>
