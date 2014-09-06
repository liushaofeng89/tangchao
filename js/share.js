var url=encodeURI(document.location),title = encodeURI(document.title),language='zh_cn',pics='',site="http://www.tangchao.tk";
var desc=encodeURI("成都唐潮美发沙龙因你而精彩！");/*默认分享理由(可选)*/
var summary=encodeURI("地址：成都市一品天下大街牌匾正前方");/*摘要(可选)*/


$(document).ready(function(){
	//获取网页中图片的地址
	var imgs = document.getElementsByTagName("img");
	var imgURLs=new Array(4);
	for(var i = 0;i<4;i++){   
		imgURLs[i] = imgs[i].src;
	}
	pics=imgURLs.join("|");
	});


/*
 * 分享到新浪微博
 */

function shareToXLWB(){
	 var appkey=''; /**您申请的应用appkey,显示分享来源(可选)*/
	 var ralateUid='2987459453'; /**关联用户的UID，分享微博会@该用户(可选)*/
	 window.open("http://service.weibo.com/share/share.php?url="+url+"&appkey="+appkey+"&title="+title+"&pic="+pics+"&ralateUid="+ralateUid+"&language="+language,"_blank","width=615,height=505");	
}


/*
 * 分享到腾讯微博
 */

function shareToTXWB(){
	var _appkey = encodeURI("appkey");//你从腾讯获得的appkey
	var _u = 'http://v.t.qq.com/share/share.php?title='+title+'&url='+url+'&appkey='+_appkey+'&site='+site+'&pic='+pics;
	window.open( _u,'转播到腾讯微博', 'width=700, height=680, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, location=yes, resizable=no, status=no' );
	
}


/*
 * 分享到QQ空间
 */

function shareToQQKJ(){
	window.open("http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url="+url+"&title="+title+"&site="+site+"&pics="+pics+"&style=201&width=39&height=39&otype=sharec");
}


/*
 * 分享到QQ好友
 */

function shareToQQHY(){
	window.open("http://connect.qq.com/widget/shareqq/index.html?url="+url+"&title="+title+"&site="+site+"&desc="+desc+"&summary="+summary);
}


/*
 * 分享到朋友网
 */

function shareToPY(){
	window.open("http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url="+url+"&title="+title+"&site="+site+"&pics="+pics+"&to=pengyou&desc="+desc+"&summary="+summary);
}

 