//主机名
var pcName = "";
// 操作系统
var OS = "";
// 字长
var wordSize = "";
// MAC地址
var MAC = "";
// IP地址
var IP = "";
// 用户语言：
var userLanguage = navigator.userLanguage;
// 系统语言
var systemLanguage = navigator.systemLanguage;
// 浏览器信息
var browserInfo = navigator.userAgent;
// CPU序列号
var CPUID = "";
// CPU型号
var CPUType = "";
// 主板ID
var mainBoardId = "";
// 主板制造商
var mainBoardMadeBy = "";

var locator = new ActiveXObject ("WbemScripting.SWbemLocator"); 
var service = locator.ConnectServer(".");  //链接本地电脑

// 主板信息
function mainBoard() {
	var properties = service.ExecQuery("SELECT * FROM Win32_BaseBoard");
	var e = new Enumerator(properties);
	for (; !e.atEnd(); e.moveNext()) {
		var p = e.item();
		mainBoardId = p.SerialNumber;
		mainBoardMadeBy = p.Manufacturer;
	}
}

// 获取网络连接信息
function ipinfo() {
	var properties = service
			.ExecQuery("SELECT * FROM Win32_NetworkAdapterConfiguration Where IPEnabled=TRUE");
	var e = new Enumerator(properties);
	var i = 1;
	for (; !e.atEnd(); e.moveNext()) {
		var p = e.item();
		MAC = p.MACAddress;
		IP = p.IPAddress(0);
	}
}

// 获取操作系统信息
function osinfo() {
	var properties = service.ExecQuery("SELECT * FROM Win32_OperatingSystem");
	var e = new Enumerator(properties);
	var i = 1;
	for (; !e.atEnd(); e.moveNext()) {
		var p = e.item();
		OS = p.Caption;
		wordSize = p.OSArchitecture;
	}
}


//CPU 信息
function cpuInfo() {
	var properties = service.ExecQuery("SELECT * FROM Win32_Processor");
	var e = new Enumerator(properties);
	for (; !e.atEnd(); e.moveNext()) {
		var p = e.item();
		CPUID = p.ProcessorID;
		CPUType = p.Name;
		pcName = p.SystemName;
	}
}

$(document).ready(function() {
	cpuInfo;
	mainBoard();
	ipinfo();
	osinfo();
	$("#pcName").html(pcName);
	$("#os").html(OS);
	$("#wordSize").html(wordSize);
	$("#CPUID").html(CPUID);
	$("#CPUType").html(CPUType);
	$("#userLanguage").html(userLanguage);
	$("#systemLanguage").html(systemLanguage);
	$("#mainBoardId").html(mainBoardId);
	$("#mainBoardMadeBy").html(mainBoardMadeBy);
	$("#MAC").html(MAC);
	$("#IPAddress").html(IP);
	$("#browserInfo").html(browserInfo);	
});
