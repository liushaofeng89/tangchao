<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META http-equiv=Pragma content=no-cache>
<META http-equiv=Cache-Control content=no-cache> 
<meta http-equiv="expires" content="0"> 
<LINK href="../css/admin.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/utils.js"></script>
</HEAD>
<BODY>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" background="../images/header_bg.jpg" border=0>
		<TR height=56>
		    <TD width=260><IMG height=56 src="../images/header_left.jpg" width=260></TD>
		    <TD style="FONT-WEIGHT: bold; COLOR: #fff; PADDING-TOP: 20px" align=middle> 用户：${sessionScope.lsf_tc_userinfo.userName}(${sessionScope.lsf_tc_userinfo.userId})欢迎您！&nbsp;&nbsp;&nbsp;&nbsp;<A style="COLOR: #fff" onclick="if (confirm('确定要退出吗？')) return true; else return false;" href="/tangchao/servlet/Logout" target=_top>退出系统</A></TD>
		    <TD align=right width=268><IMG height=56 src="../images/header_right.jpg" width=268></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
		<TR bgColor=#1c5db6 height=4>
		    <TD></TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
