<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">
    	<meta name="author" content="">

    	<title>唐潮美发沙龙会员注册</title>

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
				            <li class="active"><a href="register.jsp"><i class="fa fa-credit-card fa-fw"></i>&nbsp;&nbsp;充值办卡</a></li>
				            <li><a href="user.jsp"><i class="fa fa-users"></i>&nbsp;&nbsp;会员管理</a></li>
				            <li><a href="manage.jsp"><i class="fa fa-cog fa-fw"></i>&nbsp;&nbsp;业务管理</a></li>
				            <li><a href="query.jsp"><i class="fa fa-bar-chart-o"></i>&nbsp;&nbsp;业绩查询</a></li>
          				</ul>
			          	<ul class="nav nav-sidebar">
			            	<li><a href="#">其他</a></li>
			          	</ul>
        			</div>
        			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        				<ul class="nav nav-tabs">
					    	<li class="active"><a href="#tab1" data-toggle="tab"><i class="fa fa-jpy"></i>&nbsp;&nbsp;会员充值</a></li>
					    	<li><a href="#tab2" data-toggle="tab"><i class="fa fa-plus"></i>&nbsp;&nbsp;卡片办理</a></li>
					    </ul>
					    <div class="tab-content" style="padding-top: 20px;padding-left:5px;border: solid 1px #ddd;border-top: none;border-bottom-left-radius:4px;border-bottom-right-radius：4px;">
							<div class="tab-pane active" id="tab1">
								<form class="form-horizontal" role="form">
								   <div class="form-group">
								      <label for="firstname" class="col-sm-2 control-label">请输入卡号</label>
								      <div class="col-sm-7">
								         <input id="rechargeId" type="text" class="form-control" onfocus="getFocus(this)" onblur="lostFocus(this)" onchange="queryUser(this)" maxlength="4" title="请会员卡号" value="请会员卡号">
								      </div>
								      <label for="lastname" id="userLabel" class="col-sm-3 control-label" style="text-align: left;font-weight:normal;"></label>
								   </div>
								   <div class="form-group">
								      <label for="lastname" class="col-sm-2 control-label">充值金额</label>
								      <div class="col-sm-7">
								         <input id="rechargeVal" type="text" class="form-control" onfocus="getFocus(this)" onblur="lostFocus(this)" title="输入充值金额（整数）" value="输入充值金额（整数）">
								      </div>
								   </div>
								   <div class="form-group">
								      <div class="col-sm-10" style="text-align: center;">
								         <button id="rechargeBtn" onclick="rechargeMoney()" type="button" class="btn btn-default">充值</button>
								      </div>
								   </div>
								</form>
							
							</div>
							<div class="tab-pane" id="tab2">
								<form class="form-horizontal" role="form">
								   <div class="form-group">
								      <label class="col-sm-2 control-label">姓名：</label>
								      <div class="col-sm-10">
								         <input class="form-control" id="userName" onfocus="getFocus(this)" onblur="lostFocus(this)" type="text" title="用户姓名" value="用户姓名">
								      </div>
								   </div>
								   <div class="form-group">
								      <label for="inputPassword" class="col-sm-2 control-label">性别：</label>
								      <div class="col-sm-10">
								      		<label class="checkbox-inline">
								      	   		<input type="radio" id="sexMale" name="sex"> 男&nbsp;&nbsp;<i class="fa fa-male"></i>
								      	  	</label>
										   	<label class="checkbox-inline">
										      	<input type="radio" id="sexFemale" name="sex" checked>女&nbsp;&nbsp;<i class="fa fa-female"></i>
										   	</label>
								      </div>
								   </div>
								   <div class="form-group">
								      <label class="col-sm-2 control-label" for="inputSuccess">电话号码：</label>
								      <div class="col-sm-10">
								         <input type="text" class="form-control" id="cellPhoneNo" onfocus="getFocus(this)" onblur="lostFocus(this)" maxlength="11" title="电话号码" value="电话号码">
								      </div>
								   </div>
								   <div class="form-group">
								      <label class="col-sm-2 control-label" for="inputSuccess">会员卡号：</label>
								      <div class="col-sm-10">
								         <input type="text" class="form-control" id="cardId" onfocus="getFocus(this)" onblur="lostFocus(this)" maxlength="4" title="会员卡号" value="会员卡号">
								      </div>
								   </div>
								   <div class="form-group">
								      <label class="col-sm-2 control-label" for="inputWarning">折扣选择：</label>
								      <div class="col-sm-10">
								         <select id="discounts" class="form-control">
								               <option value="1.0">原价</option>
								               <option value="0.9">九折</option>
								               <option value="0.8">八折</option>
								               <option value="0.7">七折</option>
								               <option value="0.6">六折</option>
								               <option value="0.5">五折</option>
								         </select>
								      </div>
								   </div>
								   <div class="form-group">
								      <label class="col-sm-2 control-label" for="inputError"> 初始金额：</label>
								      <div class="col-sm-10">
								         <input type="text" class="form-control" id="remain" onfocus="getFocus(this)" onblur="lostFocus(this)" title="初始金额" value="初始金额">
								      </div>
								   </div>
								   <div class="form-group">
								      <div class="col-sm-12" style="text-align: center;">
								         <button type="button" class="btn btn-default" onclick="submitRegister()">保存</button>
								      </div>
								   </div>
								</form>
					     	</div>
					     </div>
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
	    function submitRegister() {
			//check input data
			var userName = $("#userName").val();
			var cardId = $("#cardId").val();
			var remain = $("#remain").val();
			var cellPhoneNo = $("#cellPhoneNo").val();
			if (userName == "用户姓名" || cardId == "会员卡号" || remain == "初始金额"|| cellPhoneNo == "电话号码") {
				alert("用户名、卡号、电话号码和初始金额均为必填项!");
				return;
			}
	
			//register vip user
			$.ajax( {
				type : "POST",
				url : "/tangchao/RegisterService",
				data : "userName=" + userName + "&sex="
						+ $("#sexFemale").attr("checked") + "&cardId=" + cardId
						+ "&discounts=" + $("#discounts").val() + "&remain="
						+ remain+"&cellPhoneNo="+cellPhoneNo,
				success : function(msg) {
					if (msg == "REGISTER_SUCCESS") {
						alert("用户注册成功！");
						window.location.href = "user.jsp";
					} else {
						alert("用户注册失败！");
					}
				}
			});
		}

		function queryUser(obj)
		{
			if($(obj).val().length==4)
			{
				$.ajax( {
					type : "POST",
					url : "/tangchao/QueryUserService",
					dataType: "json",
					data : "type=true&cardId=" + $(obj).val(),
					success : function(msg) {
						var dataList =eval(msg);
						if(dataList.length!=0)
						{
							for(var i in dataList)
							{
								$("#userLabel").html("姓名：<code>"+dataList[i].userName+"</code>");
							}
						}else
						{
							$("#userLabel").html("卡号：<code>"+$(obj).val()+"</code>尚未注册！");
						}
					}
				});
			}else
			{
				$("#userLabel").html("");
			}
		}

		function rechargeMoney()
		{
			$.ajax( {
				type : "POST",
				url : "/tangchao/RechargeByCardIdService",
				data : "cardId="+ $("#rechargeId").val()+"&rechargeVal=" + $("#rechargeVal").val(),
				success : function(msg) {
					alert(msg);
					window.location.href="register.jsp";
				}
			});
		}
    </script>
  </body>
</html>
