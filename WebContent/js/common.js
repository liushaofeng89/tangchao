function getFocus(obj)
{
	if($(obj).val()==$(obj).attr("title"))
	{
		$(obj).val("");
	}
}

function lostFocus(obj)
{
	if($(obj).val()=="")
	{
		$(obj).val($(obj).attr("title"));
	}
}

function showSex(obj)
{
	if(obj==true)
	{
		return "男";
	}else if(obj==false)
	{
		return "女";
	}
}
function showDiscounts(obj)
{
	if(obj=="1")
	{
		return "无折扣";
	}else if(obj=="0.9")
	{
		return "九折";
	}else if(obj=="0.8")
	{
		return "八折";
	}else if(obj=="0.7")
	{
		return "七折";
	}else if(obj=="0.6")
	{
		return "六折";
	}else if(obj=="0.5")
	{
		return "五折";
	}else
	{
	}
}

function formatTime(obj)
{
	return new Date(obj).format('yyyy-MM-dd HH:mm:ss'); 
}

Date.prototype.format =function(format)
{
    var o = {
    "M+" : this.getMonth()+1, // month
    "d+" : this.getDate(),    // day
    "H+" : this.getHours(),   // hour
    "m+" : this.getMinutes(), // minute
    "s+" : this.getSeconds(), // second
    "q+" : Math.floor((this.getMonth()+3)/3),  // quarter
    "S" : this.getMilliseconds() // millisecond
    };
    if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
    (this.getFullYear()+"").substr(4- RegExp.$1.length));
    for(var k in o)if(new RegExp("("+ k +")").test(format))
    format = format.replace(RegExp.$1,
    RegExp.$1.length==1? o[k] :
    ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
}