<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>jQuery Easy UI</title>
    <meta charset="UTF-8" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="css/locale/easyui-lang-zh_CN.js" ></script>
    <link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="css/themes/icon.css" />

</head>
<body>
<div class="easyui-dialog" style="width:400px;height:200px"
     data-options="title:'My Dialog',collapsible:true,iconCls:'icon-ok',onOpen:function(){}">
    dialog content.
</div>

</body>
</html>
