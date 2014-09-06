<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">
    	<meta name="author" content="">

    	<title>唐潮美发沙龙价格维护</title>

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
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">服务项目单价修改</h4>
			      </div>
			      <div class="modal-body">
			        ...
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			        <button type="button" class="btn btn-primary">保存</button>
			      </div>
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
		
			<jsp:include page="header.jsp"/>

    		<div class="container-fluid">
      			<div class="row">
        			<div class="col-sm-2 col-md-2 sidebar">
          				<ul class="nav nav-sidebar">
				            <li><a href="index.jsp"><i class="fa fa-cut fa-fw"></i>&nbsp;&nbsp;消费办理</a></li>
				            <li><a href="register.jsp"><i class="fa fa-credit-card fa-fw"></i>&nbsp;&nbsp;充值办卡</a></li>
				            <li><a href="user.jsp"><i class="fa fa-users"></i>&nbsp;&nbsp;会员管理</a></li>
				            <li class="active"><a href="manage.jsp"><i class="fa fa-cog fa-fw"></i>&nbsp;&nbsp;业务管理</a></li>
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
						         <th>编号</th>
						         <th>服务名称</th>
						         <th>服务单价(元)</th>
						         <th>编辑</th>
						      </tr>
						   </thead>
						   <tbody id="serviceListTable"></tbody>
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
    
    <script type="text/javascript">
	    $(document).ready(function(){
	    	 $.ajax( {
	 			type : "POST",
	 			url : "/tangchao/QueryServiceInfo",
	 			dataType: "json",
	 			success : function(msg) {
	 				var data=eval(msg);
	 				for (var i in data) {
	 					$("#serviceListTable").append("<tr><td>"+(parseInt(i)+1)+"</td><td>"+data[i].name+"</td><td>"+data[i].price+"</td><td><a href='javascript:show()'><i class='fa fa-edit'></i></a></td></tr>");
	 				}
	 			}
	 		});
    	});

    	function show()
    	{
    		$('#myModal').modal('show')
        }
    </script>
  </body>
</html>
