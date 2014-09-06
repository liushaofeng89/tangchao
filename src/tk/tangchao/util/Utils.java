/**
 * 系统工具类
 */
package tk.tangchao.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;


/**
 * @author liushaofeng
 * 
 */

public class Utils {

	public static Logger logger = Logger.getLogger(Utils.class);
	
	/**
	 * 获取屏幕分辨率方法
	 * 
	 * @return 屏幕的分辨率大小
	 */
	public static Dimension getScreenSize() {

		int width = Toolkit.getDefaultToolkit().getScreenSize().width;

		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		return new Dimension(width, height);

	}

	/**
	 * 得到非法请求的IP
	 * 
	 * @return 返回非法请求的IP地址
	 */
	public static String getIP(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("Proxy-Client-IP"); 
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getHeader("WL-Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
			ip = request.getRemoteAddr();  
		}  
			return ip;  
		}  
	
	
	/**
	 * 得到非法请求的MAC
	 * 
	 * @param 传入非法请求的IP地址
	 * @return 返回非法请求的MAC地址
	 * 
	 */
	public static String getMACAddress(String ip) {  
		String str = "";  
		String macAddress = "";  
		try {  
			Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);  
			InputStreamReader ir = new InputStreamReader(p.getInputStream());  
			LineNumberReader input = new LineNumberReader(ir);  
			for (int i = 1; i < 100; i++) {  
				str = input.readLine();  
			    if (str != null) {  
				    if (str.indexOf("MAC Address") > 1) {  
				    	macAddress = str.substring(  
				        str.indexOf("MAC Address") + 14, str.length());  
				        break;  
				    }  
			    }  
			            }  
		} catch (Exception e) {  
			logger.error("获取非法请求的MAC地址失败！");
		}  
			return macAddress;  
		} 

}
