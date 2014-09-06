/**
 * 系统常量
 */
package tk.tangchao.util;

/**
 * @author liushaofeng
 *
 */
public class Constant {
	
	//工具类
	public Utils util;

	//设置验证码图片的宽度
	public static final int WIDTH = 65;
	
	//设置验证码图片的高度
	public static final int HEIGHT = 18;
	
	//当前系统屏幕的宽度(默认为800px)
	public static int SCR_WIDTH = 800;
	
	//当前系统屏幕的高度(默认为600px)
	public static int SCR_HEIGHT = 600;
	
	//设置session过期时间(10*6分钟)
	public static final int VALIDITY_SESSION_TIME = 60*10*6;
	
	/**
	 * 构造函数
	 */
	@SuppressWarnings("static-access")
	public Constant(){
		
		//设置屏幕分辨率
		this.util = new Utils();
		this.SCR_WIDTH = util.getScreenSize().width;
		this.SCR_HEIGHT = util.getScreenSize().height;
		
	}
	
		
}
