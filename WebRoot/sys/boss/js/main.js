
//定义两个变量用于保存填写合格数据的个数
var x=false,y=false,z=false;
var id="",password="";

/*
 * 1、检测原密码是否合法 
 * 2、检测要修改的员工的员工工号是否合法
 */
function check(){
	x=false;
	$.ajax({
		type: "GET",
		url: "/tangchao/servlet/ModifySecurity",
		data: {id:$("#id").val(),pwd:$("#pwd0").val(),type:"c"},
		success: function(msg){
			if(msg=="0"){
			$("#flag0").html("<font color='red'>原密码不正确</font>");
			x=false;$('a.easyui-linkbutton').linkbutton('disable');
		}else if(msg=="1"){
			$("#flag0").html("");	
			x=true;
		}else if(msg=="2"){
			$("#flag3").html("");	
			x=true;
			id=$("#id").val()
		}else if(msg=="3"){
			$("#flag3").html("<font color='red'>原员工号不存在或已离职</font>");
			x=false;$('a.easyui-linkbutton').linkbutton('disable');
		}
		}
	})
}

/*
 *检测密码的输入格式是否合法 
 */
function doCheck1(){
	
	var pwd1=$("#pwd1").val(),pwd2=$("#pwd2").val();
	
	if(pwd1!=""){
		if(pwd1.length<6){
			$("#flag1").html("<font color='red'>新密码不能少于<b>六</b>位</font>");
			y=false;$('a.easyui-linkbutton').linkbutton('disable');
			}else{
				$("#flag1").html("");y=true;
				if($("#pwd1").val()!=$("#pwd2").val()){
					$("#flag2").html("<font color='red'>两次新密码不一致</font>");
					}else{
						$("#flag2").html("");
						z=true;
						password=pwd1;
						if(x&&y&&z){
							  $('a.easyui-linkbutton').linkbutton('enable');
						  }
						}
				}
		}else{
			$("#flag1").html("<font color='red'>新密码不能为空</font>");
			y=false;$('a.easyui-linkbutton').linkbutton('disable');
			}
	
	
	
	if(pwd2!=""){
		if(pwd2.length<6){
			$("#flag2").html("<font color='red'>新密码不能少于<b>六</b>位</font>");
			z=false;$('a.easyui-linkbutton').linkbutton('disable');
			}else{
				$("#flag2").html("");
				if($("#pwd1").val()!=$("#pwd2").val()){
					$("#flag2").html("<font color='red'>两次新密码不一致</font>");
					}else{
						$("#flag2").html("");
						y=true;
						password=pwd1;
						if(x&&y&&z){
							  $('a.easyui-linkbutton').linkbutton('enable');
						  }
						}
				}
		}else{
			$("#flag2").html("<font color='red'>新密码不能为空</font>");
			z=false;$('a.easyui-linkbutton').linkbutton('disable');
			}
}

function doCheck2(){
	var pwd3=$("#pwd3").val(),pwd4=$("#pwd4").val()
	if(pwd3!=""){
		if(pwd3.length<6){
			$("#flag4").html("<font color='red'>新密码不能少于<b>六</b>位</font>");
			y=false;$('a.easyui-linkbutton').linkbutton('disable');
			}else{
				$("#flag4").html("");y=true;
				if($("#pwd3").val()!=$("#pwd4").val()){
					$("#flag5").html("<font color='red'>两次新密码不一致</font>");
					}else{
						$("#flag5").html("");
						z=true;
						password=pwd3;
						if(x&&y&&z){
							  $('a.easyui-linkbutton').linkbutton('enable');
						  }
						}
				}
		}else{
			$("#flag4").html("<font color='red'>新密码不能为空</font>");
			y=false;$('a.easyui-linkbutton').linkbutton('disable');
			}
	
	
	
	if(pwd4!=""){
		if(pwd4.length<6){
			$("#flag5").html("<font color='red'>新密码不能少于<b>六</b>位</font>");
			z=false;$('a.easyui-linkbutton').linkbutton('disable');
			}else{
				$("#flag5").html("");
				if($("#pwd3").val()!=$("#pwd4").val()){
					$("#flag5").html("<font color='red'>两次新密码不一致</font>");
					}else{
						$("#flag5").html("");
						y=true;
						password=pwd3;
						if(x&&y&&z){
							  $('a.easyui-linkbutton').linkbutton('enable');
						  }
						}
				}
		}else{
			$("#flag5").html("<font color='red'>新密码不能为空</font>");
			z=false;$('a.easyui-linkbutton').linkbutton('disable');
			}
	
	}
	
	



/*
 *信息填写是否完整（是否启用提交数据按钮）
 */
$(document).ready(function(){
	$('a.easyui-linkbutton').linkbutton('disable');
	});



/*
 * 提交数据
 */

function modify(){
	$.ajax({
		type: "POST",
		url: "/tangchao/servlet/ModifySecurity",
		data: {id:id,pwd:password,type:"u"},
		success: function(msg){
			 if(msg=="success"){
				 alert("密码更改成功");
				 window.location.reload();
			 }else{
				 alert("密码更改失败");
			 }
		}
	})
}


//删除单个员工
function delsingle(){
	var selected = $('#test').datagrid('getSelected');
	if(selected.length==0){
		alert("请选中要删除的用户!");
	}else{
		var result= window.confirm("你确定删除用户<"+selected.userName+">吗?");
		if (result) {
			$.ajax({
				type: "GET",
				url: "/tangchao/servlet/UserManage",
				data: {id:selected.userId},
				success: function(msg){
					 if("success"==msg){
						 alert("用户删除成功！");
						 window.location.reload();
					 }else if("fail"==msg){
						 alert("用户删除失败！");
					 }else if("deleteBossFail"==msg){
						 alert("老板不能删除自己,如更换老板,请联系系统维护人员!");
					 }else if("deleteWithNoRight"==msg){
						 alert("你没有删除用户的权限！");
					 }else{
						 alert("系统异常！");
					 }
				}
			})
		}
	}
	
}

//删除多个员工
function delmulti(){
	var ids="",names = "";
	var rows = $('#test').datagrid('getSelections');
	for(var i=0; i<rows.length; i++){
		names+=rows[i].userName+"、";
		ids+=rows[i].userId+"~";
		}
	names=names.substring(0, names.length-1);
	var result= window.confirm("你确定删除用户<"+names+">吗?");
	if (result) {
		$.ajax({
			type: "GET",
			url: "/tangchao/servlet/UserManage",
			data: {ids:ids.substring(0, ids.length-1)},
			success: function(msg){
				if("success"==msg){
					 alert("用户删除成功！");
					 window.location.reload();
				 }else if("fail"==msg){
					 alert("用户删除失败！");
				 }else if("deleteWithNoRight"==msg){
					 alert("你没有删除用户的权限！");
				 }else{
					 alert("系统异常！");
				 }
			}
	})
	}
}

//修改员工信息
function editpersoninfo(){
	$('#im').show();
	$('#im').dialog({modal:true});
	}

