package tk.tangchao.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
/**
 * <上传焦点图到数据库，生成本地焦点图地址到后台展示>
 * @author liushaofeng
 * @version [version 1.0.0 2013-4-23]
 *
 */
public class FocusImageManage extends HttpServlet {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -6283618167486394516L;
	
	Logger logger = Logger.getLogger(FocusImageManage.class);

	/**
	 * Constructor of the object.
	 */
	public FocusImageManage() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//如果是上传图片
		String type = (null == request.getParameter("type")) ? "" : request.getParameter("type");
		if("uploadfile_focusimage".equals(type)){
			doPost( request,  response);
			return;
		}
		
		//获取本地图片路径
		PrintWriter out = response.getWriter();
		String path = this.getServletConfig().getServletContext().getRealPath("\\")+"/pictures/focusimages/";
		String html = "";
		File f = new File(path);
		
		if(f.isDirectory()){
			
			File[] files = f.listFiles();
			
			if (null != files){
				
				//前台需要的图片展示效果
				if("get_front_focusimage".equals(type)){
					for (int i = 0; i < files.length; i++) {
						html+="<a href='"+files[i]+"'></a>";
					}
				}else{
					for (int i = 0; i < files.length; i++) {
						html+="<span style='margin:5px;'><img src='"+files[i]+"' width='240px;'/></span>";
					}
				}
				out.write(html);
			}   
		}else{
			logger.error("获取焦点图本地路径异常！");
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter  out = response.getWriter();
		
		//文件保存目录路径
		String savePath = this.getServletConfig().getServletContext().getRealPath("/")+"pictures\\focusimages\\";
		
		//定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		//extMap.put("flash", "swf,flv");
		//extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		//extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

		//最大文件大小3M
		long maxSize = 3*1024*1024;

		response.setContentType("text/html; charset=UTF-8");

		if(!ServletFileUpload.isMultipartContent(request)){
			out.write("<script type='text/javascript'>alert('请选择文件！');</script>");
			return;
		}
		//检查目录
		File uploadDir = new File(savePath);
		if(!uploadDir.isDirectory()){
			out.write("<script type='text/javascript'>alert('上传目录不存在！');</script>");
			return;
		}
		//检查目录写权限
		if(!uploadDir.canWrite()){
			out.write("<script type='text/javascript'>alert('上传目录没有写权限！');</script>");
			return;
		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if(!extMap.containsKey(dirName)){
			out.write("<script type='text/javascript'>alert('目录名不正确！');</script>");
			return;
		}
		
		//如果文件不存在则创建文件夹
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		Iterator itr = items.iterator();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			String fileName = item.getName();
			long fileSize = item.getSize();
			if (!item.isFormField()) {
				//检查文件大小
				if(item.getSize() > maxSize){
					out.write("<script type='text/javascript'>alert('上传文件大小超过限制！');</script>");
					return;
				}
				//检查扩展名
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
				if(!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
					out.write("<script type='text/javascript'>alert('上传文件扩展名是不允许的扩展名。\n只允许"+extMap.get(dirName)+"格式');</script>");
					return;
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "." + fileExt;
				try{
					File uploadedFile = new File(savePath, newFileName);
					item.write(uploadedFile);
				}catch(Exception e){
					out.write("<script type='text/javascript'>alert('上传文件失败！');</script>");
					return;
				}

				JSONObject obj = new JSONObject();
				obj.put("error", 0);
				obj.put("url", savePath + newFileName);
				out.println(obj.toJSONString());
			}
		}
		
	}

}
