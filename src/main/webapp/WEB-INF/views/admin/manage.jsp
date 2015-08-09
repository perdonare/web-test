<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv=Content-Type content="text/html;charset=utf-8">
<meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
<meta content=always name=referrer>
<title>ha-ho</title>
<link href="/public/bootstrap/css/bootstrap.css" rel="stylesheet"/>
<link href="/public/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
<link href="/public/bsgrid/merged/bsgrid.all.min.css" rel="stylesheet"/>
<link href="/css/admin/manage.css" rel="stylesheet"/>
<script src="/public/jquery.min.js"></script>
<script src="/public/bootstrap/js/bootstrap.js"></script>
<script src="/js/admin/userManage.js"></script>
</head>
<body class="bd">
<div class=".container-fluid">
	
	<div class="user-message row">
    	<ul class="user-manage pull-right">
        	<li>退出</li>
            <li>修改资料</li>
            <li>修改密码</li>
            <li>系统信息</li>
            <li>前台首页</li> 
        </ul>
  </div>
  <div class="user-title row ">
      <a href="#">系统管理</a>
      <a href="#">内容管理</a>
      <a href="#">计划管理</a>
      <a href="#">系统管理</a>
      <a href="#">其他管理</a>
      	
  </div>
    
  <div class="user-main row">
  	<div class="user-list col-xs-2 col-md-2 panel-group">
  		<!--左边列表开始-->
    	
            <div class="panel-group pull-left" style="width:100%">
                <div class="btn btn-default ">
                    主题列表
                </div>

                <div class="panel panel-info">
                    <div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                        <a class="accordion-toggle">功能菜单</a>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse"
                         style="height: 0px;">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="/admin/userManage">用户管理</a></li>
                                <li><a href="#">角色管理</a></li>
                                <li><a href="#">菜单管理</a></li>
                                <li><a href="#">系统权限</a></li>
                                
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                        <a class="accordion-toggle">菜单管理</a>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse"
                         style="height: 0px;">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">菜单管理</a></li>
                                <li><a href="#">字典管理</a></li>
                                <li><a href="#">已完成</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
                        <a class="accordion-toggle">近期计划</a>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse"
                         style="height: 0px;">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">未完成</a></li>
                                <li><a href="#">进行中</a></li>
                                <li><a href="#">已完成</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default ">
                    <div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
                        <a class="accordion-toggle">近期计划</a>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse"
                         style="height: 0px;">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">未完成</a></li>
                                <li><a href="#">进行中</a></li>
                                <li><a href="#">已完成</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  		<div class="user-center col-xs-10 col-md-10">
	  
	      	<ul class="nav nav-tabs nav-justified">
	          	<li class="active"><a href="#identifier" data-toggle="tab">计划</a></li>
	              <li><a href="#identifier" data-toggle="tab">课程</a></li>
	              <li><a href="#identifier" data-toggle="tab">其他</a></li>
	          </ul>

            <div>
                <form class="form-inline">
                    <div class="form-group">
                        <label for="username" class="sr-only">用户名</label>
                        <input type="text" id="username" class="form-control" placeholder="用户名"/>
                        <button type="submit" class="btn btn-default">查询</button>
                    </div>
                </form>

                <div>
                    <button class="btn btn-default" type="submit">新增</button>
                    <button class="btn btn-default" type="submit">修改</button>
                    <button class="btn btn-default" type="submit">审核</button>
                    <button class="btn btn-default" type="submit">删除</button>
                </div>
            </div>

            <%@include file="manageJson.jsp" %>
	   
	  </div>
</div>
</body>
</html>