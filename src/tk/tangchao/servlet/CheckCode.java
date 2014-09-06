package tk.tangchao.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.tangchao.util.Constant;

public class CheckCode extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public CheckCode() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();//设置保存验证码内容的session
		
		BufferedImage image = new BufferedImage(Constant.WIDTH, Constant.HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = image.getGraphics();
		
		//1、设置背景色
		setBackground(g);
		
		//2、设置图形边框
		setBorder(g);
		
		//3、设置干扰线
		drawRadomLine(g);
		
		//4、写随机数并将随机数存入session
		session.setAttribute("numrand",drawRadomNum(g));
		
		//5、写回浏览器
		response.setHeader("Pragma","No-cache");    
		response.setHeader("Cache-Control","no-cache");    
		response.setDateHeader("Expires", 0); 
		response.setContentType("image/jpeg");
		
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	private String drawRadomNum(Graphics g) {
		
		String sRand="";
		
		g.setFont(new Font("黑体",Font.ITALIC|Font.BOLD,18));
		for (int i=0;i<4;i++){    
		    String rand=String.valueOf(new Random().nextInt(10));    
		    sRand+=rand;    
		    // 将认证码显示到图象中   
		    g.setColor(new Color(20+new Random().nextInt(110),20+new Random().nextInt(110),20+new Random().nextInt(110)));//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
		    g.drawString(rand,13*i+6,16); 
		}
		//System.out.println(sRand);
		return sRand;
	}

	private void drawRadomLine(Graphics g) {
		g.setColor(getRandColor(160,200));
		
		for(int i=0;i<120;i++){//设置120条干扰线
			
			int x1=new Random().nextInt(Constant.WIDTH);
			int y1=new Random().nextInt(Constant.HEIGHT);
			
			int x2=new Random().nextInt(Constant.WIDTH);
			int y2=new Random().nextInt(Constant.HEIGHT);
			
			g.drawLine(x1, y1, x2, y2);
		}
	}

	private void setBorder(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, Constant.WIDTH-2, Constant.HEIGHT-2);
	}

	private void setBackground(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Constant.WIDTH, Constant.HEIGHT);
		
	}
	
	//给定范围获得随机颜色   
	private Color getRandColor(int fc,int bc){
        Random random = new Random();    
        if(fc>255) fc=255;    
        if(bc>255) bc=255;    
        int r=fc+random.nextInt(bc-fc);    
        int g=fc+random.nextInt(bc-fc);    
        int b=fc+random.nextInt(bc-fc);    
        return new Color(r,g,b);    
        } 
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
