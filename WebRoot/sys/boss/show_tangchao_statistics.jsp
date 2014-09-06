<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="../jquerysrc/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/utils.js"></script>
		<LINK rel="stylesheet" type="text/css" href="./css/style.css">
		<STYLE type="text/css">
		
		    table{border:solid 1px #D5D5D5;	
				border-collapse:collapse;
				width:100%;}
		
			table td{border:1px solid #D5D5D5;
					font-size:12px;
					padding:7px 5px;
					text-align:center;}
		
			table th{background-color:#EEE;
					border-right:1px solid #D5D5D5;
					font-size:13.5px;
					line-height:120%;
					font-weight:bold;
					padding:8px 5px;
					text-align:left;}
		    
			.demo{width:100%;margin:0 auto;}
			
			.mouseOver{background:#eee;}
			
			.evenBg{background:#f8f8f8;}
			
		</STYLE>
		
		<script type="text/javascript">
		// 隔行换色
		$(function(){
			$("#yourTableID tr:even").addClass("evenBg");
			var hasClass;
			$("#yourTableID tr").mouseover(function(){
				if($(this).hasClass("evenBg")){
					hasClass=true;
					$(this).removeClass();
					}else{
						hasClass=false;
						}
				$(this).addClass("mouseOver");
				}).mouseout(function(){
					$(this).removeClass("mouseOver");
					if(hasClass){$(this).addClass("evenBg");}						
					});
		});
		</script>
		
	</HEAD>
	<BODY>
		<TABLE id="yourTableID" border="0" cellSpacing="0" cellPadding="0" width="100%">
				<THEAD>
			    	<TR>
					    <TH colspan="6">唐潮信息统计</TH></TR></THEAD>
			  	<TBODY>
				  	<TR>
					    <TD>历史员工数：</TD>
					    <TD id="">null</TD>
					    <TD>当前员工数：</TD>
					    <TD>null</TD>
					    <TD>网站总访问量：</TD>
					    <TD>${sessionScope.lsf_tc_webinfo.visited}</TD></TR>
				   <TR>
					    <TD>上线时间：</TD>
					    <TD>2013-6-1</TD>
					    <TD>身份过期：</TD>
					    <TD id="">3分钟</TD>
					    <TD></TD>
					    <TD id="">null</TD></TR>
			  	   <TR>
					    <TD></TD>
					    <TD id="">null</TD>
					    <TD></TD>
					    <TD id="">null</TD>
					    <TD></TD>
					    <TD id="">null</TD></TR>
			       <TR>
					    <TD></TD>
					    <TD id="">null</TD>
					    <TD></TD>
					    <TD id="">null</TD>
					    <TD></TD>
					    <TD id="">null</TD></TR>
			   	   <TR>
					    <TD>系统维护QQ:</TD>
					    <TD>846908418</TD>
					    <TD>系统维护邮箱：</TD>
					    <TD>liushaofeng89@qq.com</TD>
					    <TD></TD>
					    <TD></TD></TR>
				</TBODY>
		</TABLE>
			
	</body>
</html>
