<%@ page language="java" import="java.util.*,tk.tangchao.util.*,java.io.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>成都唐潮美发沙龙旗舰店欢迎您……</title>
<meta charset="utf-8"/> 
<meta name="description" content="成都唐潮美发沙龙" />
<meta name="keywords" content="唐潮, 美发, 成都,沙龙, 一品天下" />
<link rel="shortcut icon" href="images/logo.ico" />

<meta name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/media-queries.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/prettyPhoto.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript">
			
			//获取唐潮简介
			$(document).ready(function() {
				$.ajax({
					type: "POST",
					url: "/tangchao/servlet/InitServlet",
					success: function(msg){
						var wi = msg.split("~");
						$("#introduction").html(wi[0]);
						$("#visited").html(wi[1]);
						$("#cellphone").html("手机: "+wi[2]);
						$("#fixphone").html("固话: "+wi[3]);
						$("#mail").html("邮箱: "+wi[4]);
						$("#fax").html("传真: "+wi[5]);
						$("#tcaddress").html("地址: "+wi[6]);
					}
				});
			})
			
			//--- Setup vars for JavaScript
			var $hour = 20;	
			var $minute = 8;	
			var $seconds = 20;
			var $site = '../round-under-construction-template';
			var $tweetCount = 10;
			var $tweetUserName = 'envato';
			var $sliderDelay = 4000;
		</script>
<link rel="stylesheet" type="text/css" href="css/_green.css" />
<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/portfolio.js"></script>
<script type="text/javascript" src="js/fullscreen-slider.js"></script>
<script type="text/javascript" src="js/count-down.js"></script>
<script type="text/javascript" src="js/share.js"></script>


<!--[if lt IE 9]>
 <script>
 	document.createElement('article');
 	document.createElement('aside');
  document.createElement('figcaption');
  document.createElement('figure');
  document.createElement('footer');
  document.createElement('header');
  document.createElement('hgroup');
  document.createElement('nav');
  document.createElement('section');
  document.createElement('time'); 
 </script> 
 
 <style type="text/css">
 	#countdown h1 {
  	padding: 0 25px 0 15px;
  	}
    
  #countdown p {
  	padding: 0 20px 0 15px;
  	}
    
 	#countdown ul li b {
  	left: -5px;
  	}
    
  .wrap-input	input {
    top: 4px;
    height: 23px;
    line-height: 23px;
    background-color: #FFF;
    }	
    
  .wrap-textarea textarea {
  	top: 4px;
    height: 130px;
		background-color: #FFF;
    }	
 </style>
<![endif]-->
</head>
<style type="text/css">
	#top {background-image: url("images/pattern-a.png");}
	#content .page header {background-image: url("images/pattern-a.png");}
</style>
<body>  

	<!--- BEGIN #焦点图 --->
	<section id="fullscreen-slider">
		<a href="pictures/focusimages/1.jpg"></a>
		<a href="pictures/focusimages/2.jpg"></a>
		<a href="pictures/focusimages/3.jpg"></a>
		<a href="pictures/focusimages/4.jpg"></a>
    </section>
 	<!--- END #焦点图 --->
   
  <!--- BEGIN #top ---> 
	<section id="top">
  
  	<!--- BEGIN #twitter-top for mobile version --->
  	<section id="twitter-top">
    	<article>
    		<div class="tweet"></div>
      </article>
      <a href="" class="button-twitter"></a>
    </section>
    <!--- END #twitter-top for mobile version --->
    
    <!--- BEGIN #logo --->
    <header id="logo"><img src="images/logo.png" title="" /></header>
    <!--- END #logo --->
    
    <!--- BEGIN #countdown --->
    <section id="countdown">
      <h1>唐潮美发沙龙</h1>
      <div>
      	<p>唐潮因你而精彩……</p>
      </div>
      <ul>
        <li><img src="images/count-down-bg.png" title="访问量"/><b id="visited"></b><span class="long">visited</span><span class="short">V</span></li>
        <li><img src="images/count-down-bg.png" /><b id="hours">20</b><span class="long">hours</span><span class="short">H</span></li>
        <li><img src="images/count-down-bg.png" /><b id="minutes">8</b><span class="long">minutes</span><span class="short">M</span></li>
        <li><img src="images/count-down-bg.png" /><b id="seconds">20</b><span class="long">seconds</span><span class="short">S</span></li>
      </ul>
    </section>
    <!--- END #countdown --->
    
   
    
    <!--- BEGIN #player for slider --->
    <section id="player">
      <div class="btn-1" class="prev"><a href="default.htm" class="prev"></a></div>
      <div class="btn-2" class="play-pause"><a href="default.htm" class="play-and-pause pause"></a></div>
      <div class="btn-3" class="next"><a href="default.htm" class="next"></a></div>
    </section>
    <!--- END #player for slider --->
    
    <!--- BEGIN menu Bubbles --->
    <nav id="menu-style-a">
      <ul>
      	<li><a href="#about-us-block">唐潮简介</a></li>
        <li><a href="#portfolio-block">设计欣赏</a></li>
        <li><a href="#contact-us-block">联系方式</a></li>
      </ul>
    </nav>
    <!--- END menu Bubbles --->
    
    <!--- BEGIN wrap mobile menu --->
    <div id="wrap-menu-style-b">
    	<div class="buttons"><a href="#menu-style-b" class="menu-tab">详细介绍</a><a href="#subscribe-bottom" class="subscribe-tab">查询维护</a></div>
      <!--- BEGIN menu for mobile version --->
      <nav id="menu-style-b">
        <ul class="menu">
          <li><a href="#about-us-block">唐潮简介</a></li>
          <li><a href="#portfolio-block">设计欣赏</a></li>
          <li><a href="#contact-us-block">联系方式</a></li>
          <!--- BEGIN #social-icons for mobile version --->
          <li class="wrap-social-icons">
            <ul class="social-icons">
              <li><a href="#" class="qq" title="分享到QQ好友" onclick="shareToQQHY()"></a></li>
	    	<li><a href="#" class="qqQJ" title="分享到QQ空间" onclick="shareToQQKJ()"></a></li>
	        <li><a href="#" class="txWB" title="分享到腾讯微博" onclick="shareToTXWB()"></a></li>        
	        <li><a href="#" class="xlWB" title="分享到新浪微博" onclick="shareToXLWB()"></a></li>
	        <li><a href="#" class="py" title="分享到朋友网" onclick="shareToPY()"></a></li>
            </ul>
            <div class="clear"></div>
          </li>
          <!--- END #social-icons for mobile version --->
        </ul>
      </nav>
      <!--- END menu for mobile version --->
      
      <!--- BEGIN #subscribe-bottom for mobile version--->
      <section id="subscribe-bottom">
      	<form name="subscribe-2">
        	<div class="wrap-input"></div>
          <span class="message"></span>
          <div class="subscribe-buttons"><a href="./sys/login.html" class="button-submit">查询</a><a href="./sys/login.html" class="cancel">维护</a></div>
        </form>
      </section>
      <!--- END #subscribe-bottom for mobile version--->
    </div>
    <!--- END wrap mobile menu --->
    
    <section id="preloader">
      <div></div>
    </section>    
  </section>
  <!--- END #top --->
  
  <div class="clear"></div>
  
  <!--- BEGIN #content --->
  <section id="content">
  
  	<!--- BEGIN Block #about-us-block --->
    <section class="page" id="about-us-block">
    	<header>
      	<h1>唐潮简介</h1>
      </header>
      <article>  
      	<div class="inner">
        	<a href="#" class="button-close"></a>
        	<a href="#top" class="button-top"></a>
          
          <!--BEGIN – Enter your html -->
          <div id="introduction"></div>
          <!--END – Enter your html -->
          
        </div>
      </article>
    </section>
    <!--- END Block #about-us-block --->
		
    <!--- BEGIN Block #portfolio-block --->
    <section class="page" id="portfolio-block">
    	<header>
    		<h1>设计欣赏</h1>
      </header>
      <article>
      	<div class="inner">
        	<a href="#" class="button-close"></a>
        	<a href="#top" class="button-top"></a>
          
          <!--BEGIN – Enter your html -->         
        	<h2>潮流设计.</h2>
					
          <!--- BEGIN Portfolio --->
					<div class="wrap-portfolio">        
            <section class="portfolio">
              <figure>
                <a href="pictures/portfolio/1.jpg" title="preview" rel="prettyPhoto[pp_one]"><img src="pictures/portfolio/1-small.jpg" /></a>
                <figcaption><ul><li>发型师：张三</li><li>设计说明：暂无说明。</li></ul></figcaption>
              </figure>
              <figure>
                <a href="pictures/portfolio/2.jpg" title="preview" rel="prettyPhoto[pp_one]"><img src="pictures/portfolio/2-small.jpg" /></a>
              </figure>
              <figure>
                <img src="pictures/portfolio/3-small.jpg" />
                <figcaption>Lorem ipsum dolor sit amet, consec tetuer adipiscing elit.</figcaption>
              </figure>
              <figure>
                <a href="pictures/portfolio/4.jpg" title="preview" rel="prettyPhoto[pp_one]"><img src="pictures/portfolio/4-small.jpg" /></a>
                <figcaption>Lorem ipsum dolor sit amet, consec tetuer adipiscing elit.</figcaption>
              </figure>
              <figure>
                <a href="pictures/portfolio/5.jpg" title="preview" rel="prettyPhoto[pp_one]"><img src="pictures/portfolio/5-small.jpg" /></a>
              </figure>
              <figure>
                <img src="pictures/portfolio/6-small.jpg" />
                <figcaption>Lorem ipsum dolor sit amet, consec tetuer adipiscing elit.</figcaption>
              </figure>              
            </section>         
            <div class="clear-float"></div>
					</div>  
          <!--- END Portfolio --->
          
          <h2>最新活动?</h2>
          <p>目前暂无任何活动，如需了解详情，请到柜台了解详情，谢谢……</p>
          <!--END – Enter your html -->
          
	      </div>      
      </article>            
    </section>
    <!--- END Block #portfolio-block --->
    
    <!--- BEGIN Block #contact-us-block --->
    <section class="page" id="contact-us-block">
    	<header>
    		<h1>联系方式</h1>
      </header>
      <article>
      	<div class="inner">
        	<a href="#" class="button-close"></a>
        	<a href="#top" class="button-top"></a>
          
          <!--BEGIN – Enter your html -->
        	<h2>我们的位置</h2>
          
         <!--BEGIN Our location -->          
         <section id="location">          	
         	<div class="wrap">              
         	<!--BEGIN google map -->             
         		<iframe width="200" height="455" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://ditu.google.cn/maps?f=q&amp;source=s_q&amp;hl=zh-CN&amp;geocode=&amp;q=%E5%9B%9B%E5%B7%9D%E7%9C%81%E6%88%90%E9%83%BD%E5%B8%82%E9%87%91%E7%89%9B%E5%8C%BA%E5%94%90%E6%BD%AE&amp;aq=&amp;sll=30.688107,104.020647&amp;sspn=0.002533,0.005284&amp;brcurrent=3,0x36efdbb0099db7d3:0xbb2c649bbad101d8,0,0x36efc52300447721:0xb98652ce2e240e02%3B5,0,0&amp;ie=UTF8&amp;hq=%E5%94%90%E6%BD%AE&amp;hnear=%E5%9B%9B%E5%B7%9D%E7%9C%81%E6%88%90%E9%83%BD%E5%B8%82%E9%87%91%E7%89%9B%E5%8C%BA&amp;t=m&amp;z=14&amp;iwloc=A&amp;cid=16240708165021735474&amp;ll=30.688108,104.020646&amp;output=embed"></iframe><br />
         		<small><a href="http://ditu.google.cn/maps?f=q&amp;source=embed&amp;hl=zh-CN&amp;geocode=&amp;q=%E5%9B%9B%E5%B7%9D%E7%9C%81%E6%88%90%E9%83%BD%E5%B8%82%E9%87%91%E7%89%9B%E5%8C%BA%E5%94%90%E6%BD%AE&amp;aq=&amp;sll=30.688107,104.020647&amp;sspn=0.002533,0.005284&amp;brcurrent=3,0x36efdbb0099db7d3:0xbb2c649bbad101d8,0,0x36efc52300447721:0xb98652ce2e240e02%3B5,0,0&amp;ie=UTF8&amp;hq=%E5%94%90%E6%BD%AE&amp;hnear=%E5%9B%9B%E5%B7%9D%E7%9C%81%E6%88%90%E9%83%BD%E5%B8%82%E9%87%91%E7%89%9B%E5%8C%BA&amp;t=m&amp;z=14&amp;iwloc=A&amp;cid=16240708165021735474&amp;ll=30.688108,104.020646" style="color:#0000FF;text-align:left">查看大图</a></small>              
         	<!--END google map -->            
         	</div>          
         </section>          
         <!--END Our location -->   
                
          <!--END – Enter your html -->
          
          <div id="box-address-contact-from">
          
          	<!--BEGIN Our Address -->
            <section id="address">
             
              <!--BEGIN – Enter your html -->
              <p>
				<ul>
					<li class="icon-tag1">地铁：
						<ul>
							<li>乘坐成都<font color="#adbc00"><b>地铁二号线</b></font>在<font color="#adbc00"><b>一品天下站<font color="red">A</font>出口</b></font>出站，穿过十字路口前行10米右方就是。</li>
							<li>乘坐成都<font color="#adbc00"><b>地铁二号线</b></font>在<font color="#adbc00"><b>一品天下站<font color="red">B</font>出口</b></font>出站，后转穿过十字路口前行10米右方就是。</li>
						</ul>
					</li>
					<li class="icon-tag2">公交：7路; 30高峰专线; 30路; 43路; 54路; 63路; 82路; 83路; 96路; 100路; 111路空调; 123路; 305路; 305路空调; 311路; 320路; 341路空调在蜀汉路同和路口站下车</li>
				</ul>
			  </p>

			  <h2>联系方式：</h2>
              <ul>
                <li class="icon-tag3" id="cellphone"></li>
				<li class="icon-tag4" id="fixphone"></li>
                <li class="icon-tag5" id="fax"></li>
                <li class="icon-tag6" id="mail"></li>
				<li class="icon-tag7" id="tcaddress"></li>
              </ul>
              <!--END – Enter your html -->
            
            </section>
            <!--END Our Address -->
						
           
            
            <div class="clear"></div>
          </div>

        </div>      
      </article>            
    </section>
    <!--- END Block #contact-us-block --->
      
  </section>
  <!--- END #content --->
  
  <footer id="footer">
  	<div class="footer-inner">
    	<!--BEGIN #social-icons -->
    	<ul class="social-icons">  
	    	<li><a href="#" class="qq" title="分享到QQ好友" onclick="shareToQQHY()"></a></li>
	    	<li><a href="#" class="qqQJ" title="分享到QQ空间" onclick="shareToQQKJ()"></a></li>
	        <li><a href="#" class="txWB" title="分享到腾讯微博" onclick="shareToTXWB()"></a></li>        
	        <li><a href="#" class="xlWB" title="分享到新浪微博" onclick="shareToXLWB()"></a></li>
	        <li><a href="#" class="py" title="分享到朋友网" onclick="shareToPY()"></a></li>
        </ul>
      <!--END #social-icons -->
      
        
      <section id="admin-part">
      	<div class="admin"><a class="btnstyle" href="./sys/login.html">查询维护</a></div>
      </section>
      
    </div>
  </footer>
</body>
</html>
