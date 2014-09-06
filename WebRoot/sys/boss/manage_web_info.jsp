<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../jquerysrc/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jquerysrc/icon.css">
	<link rel="stylesheet" type="text/css" href="../jquerysrc/demo.css">
	<script type="text/javascript" src="../jquerysrc/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../jquerysrc/jquery.easyui.min.js"></script>
	<link rel="stylesheet" href="../kindeditor-4.1.6/themes/default/default.css" />
	<script charset="utf-8" src="../kindeditor-4.1.6/kindeditor-min.js"></script>
	<script charset="utf-8" src="../kindeditor-4.1.6/lang/zh_CN.js"></script>
	<script type="text/javascript" src="../js/utils.js"></script>
	<style>
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
			#subdata:hover{background-color: #DFDFDF;}
			
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
	    
	    .mouseOver{background:#eee;}
			
		.evenBg{background:#f8f8f8;}
			
	</style>
	<script>
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

	//修改简介部分
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			resizeType : 0,
			allowPreviewEmoticons : false,
			allowImageUpload : true,
			afterChange : function() {
				K('.word_count').html(this.count('text'));
				K('.word_count_left').html(5000-this.count('text'));
			},
			items : ['source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
			         'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
			         'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
			         'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
			         'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
			         'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|',
			         'table', 'hr', 'pagebreak', 'anchor', 'link', 'unlink', '|', 'about']
		});

	//简介数据提交处理
	K('input[name=getHtml]').click(function(e){
		//判断是否输入内容
		var text=editor.text();
		if(""==text||"在这里输入新的唐潮简介信息……"==text||editor.text().length>5000)
		{
			alert("唐潮简介不对或字数上限……");
			return;
		}else{
			//提交数据
			$.ajax({
				type: "POST",
				url: "/tangchao/servlet/WebInfoManage",
				data: {html:editor.html()},
				success: function(msg){
					if("insertsuccess"==msg){
						alert("修改成功!");
						window.location.reload();
						}else if("insertfail"==msg){
							alert("修改失败!");
							editor.text(text);
							}else if("formatfail"==msg){
								alert("修改失败!");
								editor.text(text);
								}else{
									alert("未知错误,请与管理员取得联系!");
									}
					}
			});
		}
	});
			
});

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
			//添加编辑按钮
			
			
			}).mouseout(function(){
				$(this).removeClass("mouseOver");
				if(hasClass){$(this).addClass("evenBg");}						
				});
	});
</script>
</head>


<body style="text-align: center;">
	
	<div id="tt" class="easyui-tabs" tools="#tab-tools" style="width:1100px;height:520px;">
		
		<div title="当前唐潮介绍" style="padding:10px;">
			<div id="tangchaoinfo"></div>
		</div>
		
		<div title="修改唐潮介绍" style="padding:10px;" style="overflow:hidden">
			<span style="margin-left:13px;margin-bottom:3px;float: left;color:#aaa;"><font style="color: red;font-weight: bold;">注意：</font>
				<font style="color:#888;font-weight: bold;">①</font>在点击"<b>点击提交</b>"之前请认真确认信息,提交后之前的简介无法恢复&nbsp;&nbsp;&nbsp;<font style="color:#888;font-weight: bold;">②</font>字数不能超过5000字,已经输入<span class="word_count" style="color:black">15</span>个,剩下<span class="word_count_left" style="color:black">4985</span>个.
			</span>
			<form>
				<textarea id="content" name="content" style="width:1050px;height:420px;visibility:hidden;float: left;" onfocus="clearvalue()">在这里输入新的唐潮简介信息……</textarea>
				<div style="width:950px;height:400px;"><input id="subdata" name="getHtml" type="button" value="点击提交" style="margin-top:10px;padding-left:12px;padding-top:2px;background-color:transparent;background-image:url('../jquerysrc/icons/filesave.png');background-repeat:no-repeat;width:80px; height:20px;border:1px solid #A4BED4"/></div>
			</form>
		</div>
		
		<div title="联系方式维护" style="padding:10px;" style="overflow:hidden">
			<TABLE id="yourTableID" border="0" cellSpacing="0" cellPadding="0" width="100%">
				<THEAD>
					<TR><TH colspan="6">联系方式维护</TH></TR></THEAD>
				<TBODY>
					<TR><TD width="30%">手机：</TD><TD>${sessionScope.lsf_tc_webinfo.cellphone}</TD><TD style="width: 10%">[<a>修改</a>]</TD></TR>
					<TR><TD>固话：</TD><TD>${sessionScope.lsf_tc_webinfo.fixphone}</TD><TD>[修改]</TD></TR>
					<TR><TD>传真：</TD><TD>${sessionScope.lsf_tc_webinfo.fax}</TD><TD>[修改]</TD></TR>
					<TR><TD>邮箱：</TD><TD>${sessionScope.lsf_tc_webinfo.mail}</TD><TD>[修改]</TD></TR>
					<TR><TD>地址：</TD><TD>${sessionScope.lsf_tc_webinfo.address}</TD><TD>[修改]</TD></TR></TBODY>
			</TABLE>
		</div>
	</div>
	
</body>
</html>
