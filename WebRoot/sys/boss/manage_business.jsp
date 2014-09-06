<%@ page language="java" import="java.util.*,tk.tangchao.util.*,sun.jdbc.rowset.CachedRowSet" pageEncoding="UTF-8"%>
<%@page import="tk.tangchao.util.DBConn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../jquerysrc/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/utils.js"></script>
	<STYLE type="text/css">
		
	    table{border:solid 1px #D5D5D5;	
			border-collapse:collapse;
			width:100%;}
	
		table td{border:1px solid #D5D5D5;
				font-size:12px;
				padding:7px 5px;
				text-align:center;}
	
		table thead th{background-color:#EEE;
				border-right:1px solid #D5D5D5;
				font-size:13.5px;
				line-height:120%;
				font-weight:bold;
				padding:8px 5px;
				text-align:center;}
	    
		.demo{width:100%;margin:0 auto;font-size:13.5px;line-height:120%;font-weight:bold;}
		
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
</head>
<body>
	<DIV class="demo">
		<div>当前系统存在的业务：</div><hr>
		<TABLE id="yourTableID" border="0" cellSpacing="0" cellPadding="0" width="100%">
			<THEAD>
		    	<TR><TH>业务编号</TH><TH>名称</TH><TH>单价(元)</TH><TH>添加时间</TH><TH colspan="2">编辑</TH></TR></THEAD>
		  	<TBODY>
		  		<%
				    DBConn.getConnection();
		    		CachedRowSet crs=DBConn.query("select * from business_info where business_dead_time='' or business_dead_time is null");
		    		while(crs.next()){%>
		    			<tr>
		    				<td><%=crs.getString("business_id") %></td>
		    				<td><%=crs.getString("business_name") %></td>
		    				<td><%=crs.getString("business_price") %></td>
		    				<td><%=crs.getString("business_add_time")%></td>
		    				<td><a href="javascript:;">修改价格</a></td>
		    				<td><a href="javascript:;">删除业务</a></td>
		    			</tr>
		    		<%}%>
		    		<tr><td colspan="6" style="cursor:pointer;">点击添加新业务</td></tr>
			</TBODY>
		</TABLE>
<BR>
</DIV>
	
	
</body>
</html>