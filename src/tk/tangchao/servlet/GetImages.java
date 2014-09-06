package tk.tangchao.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetImages extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor of the object.
	 */
	public GetImages() {
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

		doPost(request, response);

	}
	
	/**<待优化>用业务调度器
	 * 定时从数据库获取焦点图片到应用目录下 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
//		DBConn.getConnection();
//		//定义数据库中最新的、在线的5张焦点图的数组
//		String[] filePath = new String[5];
//		//定义数据库中焦点图的文件的名字的数组
//		String[] fileName = new String[5];
//		
//		//获取数据库存在的在线的焦点图
//		String sql="select focusImage_location from focusimage_info  where focusImage_isused='' or focusImage_isused is null order by focusImage_addtime desc limit 0,5";
//		CachedRowSet crs=DBConn.query(sql);
//		try {
//			int i = 0;
//			while(crs.next()){
//				if(null!=crs.getString("focusImage_location")){
//					filePath[i]=crs.getString("focusImage_location");
//					i++;
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		//将所有数据库中焦点图文件的名字存入数组中
//		for (int i = 0; i < filePath.length; i++) {
//			if(null!=filePath[i]){
//				fileName[i]=filePath[i].substring(filePath[i].lastIndexOf("/")-12);
//			}
//		}
//		
//		//判断这些文件是否存在于当前服务器跟目录中，没有就添加到目录中
//		for (int i = 0; i < fileName.length; i++) {
//			System.out.println(fileName[i]);
//		}
		
		
		
		//获取当前服务器的根目录中存在的焦点图
		String path = this.getServletConfig().getServletContext().getRealPath("/")+"/pictures/focusimages/";
		
		File file = new File(path);
		File[] files = file.listFiles();
		
		String[] filePath = new String[files.length];
		
		//回写的焦点图字符串
		String str ="";
			
		//将文件的名字添加到数组中去(加上路径返回给页面)
		for (int i = 0; i < files.length; i++) {
				filePath[i] ="pictures/focusimages/" + files[i].getName();
				str+="<a href='"+filePath[i]+"'></a>";
		}
		
		PrintWriter out=response.getWriter();		
		out.write(str);
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
