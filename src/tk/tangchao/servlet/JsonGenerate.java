package tk.tangchao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tk.tangchao.service.JsonService;

public class JsonGenerate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = Logger.getLogger(JsonGenerate.class);
	
	/**
	 * Constructor of the object.
	 */
	public JsonGenerate() {
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

		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/json");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//判断请求的json数据的目的
		String type=request.getParameter("type");
		int page=Integer.parseInt(request.getParameter("page")==null?"1":request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows")==null?"10":request.getParameter("rows"));

		JsonService js=new JsonService(type,page,rows);
		
		String json=js.generate();
	
		out.write(json);//写回json数据
		
		out.flush();
		
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
