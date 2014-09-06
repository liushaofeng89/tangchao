<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">
    	<meta name="author" content="">

    	<title>唐潮美发沙龙欢迎您</title>

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
				            <li class="active"><a href="index.jsp"><i class="fa fa-cut fa-fw"></i>&nbsp;&nbsp;消费办理</a></li>
				            <li><a href="register.jsp"><i class="fa fa-credit-card fa-fw"></i>&nbsp;&nbsp;充值办卡</a></li>
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
					    	<li class="active"><a href="#tab1" data-toggle="tab"><i class="fa fa-users"></i>&nbsp;&nbsp;用户查询</a></li>
					    	<li><a href="#tab2" data-toggle="tab"><i class="fa fa-edit"></i>&nbsp;&nbsp;业务办理</a></li>
					        <li><a href="#tab3" data-toggle="tab"><i class="fa fa-history"></i>&nbsp;&nbsp;消费历史</a></li>
					    </ul>
					    <div class="tab-content" style="padding-top: 20px;padding-left:5px;border: solid 1px #ddd;border-top: none;border-bottom-left-radius:4px;border-bottom-right-radius：4px;">
							<div class="tab-pane active" id="tab1" style="padding: 150px;">
								<form class="form-inline" role="form" style="clear:both;text-align: center;">
								   <div class="form-group">
								      <input type="text" class="form-control" id="cardIdInput" placeholder="请输入卡号" style="width: 400px;">
								   </div>
								   <button type="submit" class="btn btn-default"><i class="fa fa-search"></i>&nbsp;&nbsp;查询</button>
								</form>
							</div>
							<div class="tab-pane" id="tab2">
						     		<h3 class="page-header">会员信息</h3>
	          						<div class="row placeholders">
	            						<div class="col-xs-6 col-sm-3 placeholder">
	              							<h4>姓名</h4>
	              							<span class="text-muted">唐三藏</span>
	            						</div>
	            						<div class="col-xs-6 col-sm-3 placeholder">
	              							<h4>卡号</h4>
	              							<span class="text-muted">No.123456789</span>
	            						</div>
			            				<div class="col-xs-6 col-sm-3 placeholder">
			              					<h4>折扣</h4>
			              					<span class="text-muted">八折</span>
			            				</div>
			            				<div class="col-xs-6 col-sm-3 placeholder">
			              					<h4>余额（人民币）</h4>
			              					<span class="text-muted"><i class="fa fa-jpy"></i>&nbsp;312.00</span>
			            				</div>
			          				</div>
	
			       					<h3 class="sub-header">消费办理</h3>
			       					<div class="table-responsive">
			           					<table class="table table-striped">
			           						<thead>
								                <tr>
								                	<th>#</th>
								                  	<th>服务名称</th>
								                  	<th>单价（元）</th>
								                  	<th>折扣价（元）</th>
								                  	<th>数量（份）</th>
								                  	<th>合计（元）</th>
								                </tr>
			           						</thead>
			           						<tbody>
								                <tr>
								                	<td><input type="checkbox"/></td>
								                  	<td>洗吹</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;30.00</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;24.00</td>
								                  	<td>
														<select>
														  	<option value ="volvo">x1</option>
														 	<option value ="saab">x2</option>
														  	<option value="opel">x3</option>
														  	<option value="audi">x4</option>
														  	<option value="audi">x5</option>
														  	<option value="audi">x6</option>
														  	<option value="audi">x7</option>
														  	<option value="audi">x8</option>
														  	<option value="audi">x9</option>
														  	<option value="audi">x10</option>
														</select>
													</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;48.00</td>
								                </tr>
			               						<tr>
								                	<td><input type="checkbox"/></td>
								                  	<td>洗剪吹</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;40.00</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;32.00</td>
								                  	<td>
														<select>
														  	<option value ="volvo">x1</option>
														 	<option value ="saab">x2</option>
														  	<option value="opel">x3</option>
														  	<option value="audi">x4</option>
														  	<option value="audi">x5</option>
														  	<option value="audi">x6</option>
														  	<option value="audi">x7</option>
														  	<option value="audi">x8</option>
														  	<option value="audi">x9</option>
														  	<option value="audi">x10</option>
														</select>
													</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;32.00</td>
								                </tr>
								                <tr>
								                	<td><input type="checkbox"/></td>
								                  	<td>烫头</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;40.00</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;32.00</td>
								                  	<td>
														<select>
														  	<option value ="volvo">x1</option>
														 	<option value ="saab">x2</option>
														  	<option value="opel">x3</option>
														  	<option value="audi">x4</option>
														  	<option value="audi">x5</option>
														  	<option value="audi">x6</option>
														  	<option value="audi">x7</option>
														  	<option value="audi">x8</option>
														  	<option value="audi">x9</option>
														  	<option value="audi">x10</option>
														</select>
													</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;32.00</td>
								                </tr>
								                <tr>
								                	<td><input type="checkbox"/></td>
								                  	<td>染发</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;40.00</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;32.00</td>
								                  	<td>
														<select>
														  	<option value ="volvo">x1</option>
														 	<option value ="saab">x2</option>
														  	<option value="opel">x3</option>
														  	<option value="audi">x4</option>
														  	<option value="audi">x5</option>
														  	<option value="audi">x6</option>
														  	<option value="audi">x7</option>
														  	<option value="audi">x8</option>
														  	<option value="audi">x9</option>
														  	<option value="audi">x10</option>
														</select>
													</td>
								                  	<td><i class="fa fa-jpy"></i>&nbsp;32.00</td>
								                </tr>
			           						</tbody>
			           						<tfoot>
			           							<tr>
			           								<td colspan="6" style="padding-top: 10px;padding-right: 20px;text-align: right;"><a class="btn btn-info" href="">结账</a></td>
			           							</tr>
			           						</tfoot>
			           					</table>
			       					</div>
					     	</div>
					     	<div class="tab-pane" id="tab3">
								<table class="table">
								   <caption>唐三藏的消费历史记录</caption>
								   <thead>
								      <tr>
								         <th>时间</th>
								         <th>消费名称</th>
								         <th>消费份额</th>
								         <th>单价</th>
								         <th>消费名称</th>
								         <th>消费份额</th>
								         <th>单价</th>
								         <th>合计</th>
								      </tr>
								   </thead>
								   <tbody>
								      <tr>
								         <td>Tanmay</td>
								         <td>Bangalore</td>
								         <td>Tanmay</td>
								         <td>Bangalore</td>
								         <td>Tanmay</td>
								         <td>Bangalore</td>
								         <td>Tanmay</td>
								         <td>Bangalore</td>
								      </tr>
								      <tr>
								         <td>Sachin</td>
								         <td>Mumbai</td>
								         <td>Sachin</td>
								         <td>Mumbai</td>
								         <td>Sachin</td>
								         <td>Mumbai</td>
								         <td>Sachin</td>
								         <td>Mumbai</td>
								      </tr>
								   </tbody>
								</table>
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
  </body>
</html>
