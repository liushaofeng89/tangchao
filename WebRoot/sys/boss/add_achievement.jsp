<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="tk.tangchao.util.DBConn"%>
<%@page import="sun.jdbc.rowset.CachedRowSet"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../jquerysrc/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/utils.js"></script>
	<STYLE type="text/css">
		body{margin: 0;padding: 0;}
		
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
				text-align:center;}
	    
		.demo{width:100%;margin:10px;font-size:13.5px;line-height:120%;font-weight:bold;}
		
		.mouseOver{background:#eee;}
			
		.evenBg{background:#f8f8f8;}
	
	</STYLE>
	
	<script type="text/javascript">
			// 隔行换色
			$(function(){
				$("#TableID1 tr:even,#TableID2 tr:even").addClass("evenBg");
				var hasClass;
				$("#TableID1 tr,#TableID2 tr").mouseover(function(){
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
	<body>
	<%!String[] users=null;%>
	
	<%CachedRowSet rs = DBConn.query("select * from user_info where user_role='员工'");users = new String[rs.size()];
	  int i=0;while(rs.next()){users[i] =  rs.getString("user_name");i++;}%>
		<DIV class="demo">
			<div>今日已添业绩：</div><hr>
			<TABLE id="TableID1" border="0" cellSpacing="0" cellPadding="0" width="100%">
				<THEAD>
			    	<TR><TH>姓名：</TH>
			    	<%DBConn.getConnection();
					CachedRowSet crs = DBConn.query("select * from business_info");
				  	while(crs.next()){%>
				  		<TH><%=crs.getString("business_name")%>(个)</TH>
				  	<%}%>
					    <TH>今日个人总业绩(元)</TH></TR></THEAD>
			  	<TBODY>
				  	<TR>
				  	 	<TD>张三</TD>
				  		<TD>5</TD>
					    <TD>3</TD>
					    <TD>5</TD>
					    <TD>2</TD>
					    <TD>2</TD>
					    <TD>235.00</TD>
				  		</TR>
				</TBODY>
			</TABLE><BR>
			
			<div>添加今日业绩：</div><hr>
			<TABLE id="TableID2" border="0" cellSpacing="0" cellPadding="0" width="100%">
				<THEAD>
			    	<TR><TH>姓名：</TH>
			    	<%DBConn.getConnection();
					CachedRowSet crs0 = DBConn.query("select * from business_info");
				  	while(crs0.next()){%>
				  		<TH><%=crs0.getString("business_name")%>(个)</TH>
				  	<%}%>
					    <TH>操作</TH></TR></THEAD>
			  	<TBODY>
			  		<TR>
					    <TD>罗光</TD>
					    <TD>2</TD>
					    <TD>10</TD>
					    <TD>4</TD>
					    <TD>2</TD>
					    <TD>1</TD>
					    <TD><a href="javascript:;">重新编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;">插入一栏</a></TD></TR>
				   <TR>
					    <TD colspan="7">提交以上数据</TD>
					   </TR>
				   
			  	 </TBODY>
			</TABLE><BR>
</DIV>
   		
	</body>
</html>
