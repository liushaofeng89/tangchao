<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.rg/TR/xhmll/DTDxhtmll-transitional.dtd/">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../jquerysrc/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jquerysrc/icon.css">
	<link rel="stylesheet" type="text/css" href="../jquerysrc/demo.css">
	<link rel="stylesheet" type="text/css" href="../css/admin.css"  >
	<script type="text/javascript" src="../jquerysrc/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../jquerysrc/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../jquerysrc/easyui-lang-zh_CN.js"></script>
  <style type="text/css">
  	.title{
  		font-weight: bold;
  	}
  	
  	#m_info a{
  		color:#aaa;
  		text-decoration: none
  	}
  
  	#m_info a:hover{
  		color:#000;
  	}
  </style>
    
   <script type="text/javascript">
   function modify(){
	    $('#dd').show();
		$('#dd').dialog({modal:true});
	   }
   
   </script>

  </head>
  
  <body>
  		
	<fieldset style="text-align: center;width:90%;height:90%;margin:auto">
		<legend>员工信息</legend>
			<div id="m_info" style="float:right;margin:5px 5px;">[<a href="javascript:void(0);" title="点击修改信息" onclick="modify()">编辑信息</a>]</div>
   				<TABLE cellSpacing=0 cellPadding=2 width="90%" height="90%" border=0>
					  <TR>
					    <TD align=right width="40%">员工工号：</TD>
					    <TD align=left style="COLOR: #880000" width="70%">${sessionScope.lsf_tc_userinfo.userId}</TD></TR>
					  <TR>
					    <TD align=right>员工姓名：</TD>
					    <TD align=left style="COLOR: #880000">${sessionScope.lsf_tc_userinfo.userName}</TD></TR>
					  <TR>
					    <TD align=right>员工性别：</TD>
					    <TD align=left style="COLOR: #880000">${sessionScope.lsf_tc_userinfo.userSex}</TD></TR>
					  <TR>
					    <TD align=right>登录角色：</TD>
					    <TD align=left style="COLOR: #880000">${sessionScope.lsf_tc_userinfo.userRole}</TD></TR>
					  <TR>
					    <TD align=right>用户类型：</TD>
					    <TD align=left style="COLOR: #880000">${sessionScope.lsf_tc_userinfo.userType}</TD></TR>
					  <TR>
					    <TD align=right>电子邮箱：</TD>
					    <TD align=left style="COLOR: #880000">${sessionScope.lsf_tc_userinfo.userMail}</TD></TR>
					  <TR>
					    <TD align=right>加入时间：</TD>
					    <TD align=left style="COLOR: #880000">${sessionScope.lsf_tc_userinfo.userJoinTime}</TD></TR>
					  <TR>
					    <TD align=right>上次登录：</TD>
					    <TD align=left style="COLOR: #880000">${sessionScope.lsf_tc_userinfo.userLastTime}</TD></TR>
 				</TABLE>
   	</fieldset>
   	
   	
   	
   	<div id="dd" title="信息修改" style="padding:0px;width:400px;height:300px;display:none;text-align: center">
		<table align="center">
			<tr width="25px"><td colspan="3">&nbsp;</td></tr>
			<tr width="25px"><td align="right">工号:</td><td align="left"><label>${sessionScope.lsf_tc_userinfo.userId}</label></td><td width="70px"></td></tr>
			<tr width="25px"><td align="right">姓名:</td><td align="left"><input type="text" value="${sessionScope.lsf_tc_userinfo.userName}" class="easyui-validatebox" required="true"/></td><td width="70px"></td></tr>
			<tr width="25px"><td align="right">性别:</td><td align="left"><input type="text" value="${sessionScope.lsf_tc_userinfo.userSex}" class="easyui-validatebox" required="true"/></td><td width="70px"></td></tr>
			<tr width="25px"><td align="right">角色:</td><td align="left"><input type="text" value="${sessionScope.lsf_tc_userinfo.userRole}" class="easyui-validatebox" required="true"/></td><td width="70px"></td></tr>
			<tr width="25px"><td align="right">邮箱:</td><td align="left"><input type="text" value="${sessionScope.lsf_tc_userinfo.userMail}" class="easyui-validatebox" required="true"/></td><td width="70px"></td></tr>
			<tr width="25px"><td align="right">加入时间:</td><td align="left"><label>${sessionScope.lsf_tc_userinfo.userJoinTime}</label></td><td width="70px"></td></tr>
			<tr width="25px"><td align="right">上次登录:</td><td align="left"><label>${sessionScope.lsf_tc_userinfo.userLastTime}</label></td><td width="70px"></td></tr>
			<tr width="25px"><td colspan="3">&nbsp;</td></tr>
			<tr width="25px"><td colspan="3" align="center"><a href="javascript:void(0);" class="easyui-linkbutton">确认修改</a></td></tr>
		</table>
	</div>
   
   
  </body>
</html>
