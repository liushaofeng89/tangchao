<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="../jquerysrc/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../js/utils.js"></script>
	<script type="text/javascript">
	//获取唐潮简介信息部分
	$(document).ready(function() {
		$.ajax({
			type: "GET",
			url: "/tangchao/servlet/WebInfoManage",
			success: function(msg){
				var wi = msg.split("~");
				$("#tangchaoinfo").html(wi[0]);
			}
		});
	})
	</script>
  </head>
  
  <body style="background-image: url('./images/body-bg.png');">
  	<div><p id="tangchaoinfo"></p></div>
  </body>
</html>
