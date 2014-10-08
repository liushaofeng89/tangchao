<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> 
			<span class="icon-bar"></span> 
			<span class="icon-bar"></span>
			<span class="icon-bar"></span></button>
			<a class="navbar-brand" href="#"><i class="fa fa-home"></i>&nbsp;&nbsp;TangChao</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
                	<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user fa-fw"></i>&nbsp;&nbsp;Admin<span class="caret"></span></a>
	                <ul class="dropdown-menu">
	                  <li><a href="javascript:logout()"><i class="fa fa-share-square"></i>&nbsp;&nbsp;注销</a></li>
	                </ul>
              	</li>
              	<li>&nbsp;&nbsp;</li>
              	<li>&nbsp;&nbsp;</li>
              	<li>&nbsp;&nbsp;</li>
			</ul>
		</div>
	</div>
</div>

<script type="text/javascript">
	function logout()
	{
		$.ajax({
			   type: "GET",
			   url: "/tangchao/LoginService",
			   success: function(msg){
			     window.location.href="login.html";
			   }
			});
	}
</script>

