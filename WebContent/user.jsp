<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<title>唐潮美发沙龙会员管理</title>

   		<!-- Bootstrap core CSS -->
    	<link href="css/bootstrap.min.css" rel="stylesheet">

    	<!-- Custom styles for this template -->
    	<link href="css/dashboard.css" rel="stylesheet">
    
    	<!-- Custom Fonts -->
    	<link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    	<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    	<script src="js/ie-emulation-modes-warning.js"></script>

    	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="js/ie10-viewport-bug-workaround.js"></script>

    	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    	<!--[if lt IE 9]>
      	<script src="https://oss.maxcdn.com/html5shiv/3.7.1/html5shiv.min.js"></script>
      	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    	<![endif]-->
		</head>
		<body>
		
			<jsp:include page="header.jsp"/>

    		<div class="container-fluid">
      			<div class="row">
        			<div class="col-sm-2 col-md-2 sidebar">
          				<ul class="nav nav-sidebar">
				            <li><a href="index.jsp"><i class="fa fa-cut fa-fw"></i>&nbsp;&nbsp;消费办理</a></li>
				            <li><a href="register.jsp"><i class="fa fa-credit-card fa-fw"></i>&nbsp;&nbsp;充值办卡</a></li>
				            <li class="active"><a href="user.jsp"><i class="fa fa-users"></i>&nbsp;&nbsp;会员管理</a></li>
				            <li><a href="manage.jsp"><i class="fa fa-cog fa-fw"></i>&nbsp;&nbsp;业务管理</a></li>
				            <li><a href="query.jsp"><i class="fa fa-bar-chart-o"></i>&nbsp;&nbsp;业绩查询</a></li>
          				</ul>
			          	<ul class="nav nav-sidebar">
			            	<li><a href="#">其他</a></li>
			          	</ul>
        			</div>
        			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        				<table class="table table-striped table-hover">
						   <thead>
						      <tr>
						         <th>姓名</th>
						         <th>性别</th>
						         <th>电话号码</th>
						         <th>卡号</th>
						         <th>折扣</th>
						         <th>账户余额(元)</th>
						         <th>开卡时间</th>
						      </tr>
						   </thead>
						   <tbody id="userListTable">
						   </tbody>
						</table>
        			</div>
      			</div>
    		</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.11.0.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/docs.min.js"></script>
    <script src="js/common.js"></script>
    
    <script type="text/javascript">
		$("#userListTable").html("");
					
		$.ajax( {
			type : "POST",
			url : "/tangchao/QueryUserService",
			dataType: "json",
			data : "type=false",
			success : function(msg) {
				var userList=eval(msg);
				for(var i in userList)
				{
					$("#userListTable").append("<tr><td>"+userList[i].userName+"</td><td>"+showSex(userList[i].isMale)+"</td><td>"+userList[i].cellPhoneNo+"</td><td>"+userList[i].cardId+"</td><td>"+showDiscounts(userList[i].discount)+"</td><td style='width:150px;text-align:right'><i class='fa fa-jpy'></i>&nbsp;"+userList[i].remain.toFixed(2)+"</td><td>"+formatTime(userList[i].createDate)+"</td></tr>");
				}
			}
		});
    </script>
  </body>
</html>
