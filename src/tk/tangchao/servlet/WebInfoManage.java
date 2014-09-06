package tk.tangchao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;
import tk.tangchao.pojo.WebInfo;
import tk.tangchao.util.CheckSessionRole;
import tk.tangchao.util.DBConn;
import tk.tangchao.util.Utils;


public class WebInfoManage extends HttpServlet {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1675007863168845142L;
	
	private Logger logger = Logger.getLogger(WebInfoManage.class);

	/**
	 * Constructor of the object.
	 */
	public WebInfoManage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	/**
	 * 获取唐潮简介.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//判断session中是否存在站点信息
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		WebInfo wi = new WebInfo();
		
		//站点基本数据
		int visited = 0;
		String content = "",cellphone = "",fixphone = "",mail = "",fax = "",address = "";
		
		//首先判断session中是否存在了站点信息
		if(null==session.getAttribute("lsf_tc_webinfo")){
			String sql = "select * from web_info";
			DBConn.getConnection();
			CachedRowSet rs = DBConn.query(sql);
			try {
				while(rs.next()){
					
					wi.setContent(rs.getString("web_info_content"));
					content = (null==rs.getString("web_info_content"))?"":rs.getString("web_info_content");
					
					wi.setVisited(rs.getInt("web_info_visited")+1);
					visited = rs.getInt("web_info_visited")+1;
					
					wi.setCellphone(rs.getString("web_info_cellphone"));
					cellphone = (null==rs.getString("web_info_cellphone"))?"":rs.getString("web_info_cellphone");
					
					wi.setFixphone(rs.getString("web_info_fixphone"));
					fixphone = (null==rs.getString("web_info_fixphone"))?"":rs.getString("web_info_fixphone");
					
					wi.setMail(rs.getString("web_info_mail"));
					mail = (null==rs.getString("web_info_mail"))?"":rs.getString("web_info_mail");
					
					wi.setFax(rs.getString("web_info_fax"));
					fax = (null==rs.getString("web_info_fax"))?"":rs.getString("web_info_fax");
					
					wi.setAddress(rs.getString("web_info_address"));
					address = (null==rs.getString("web_info_address"))?"":rs.getString("web_info_address");
				}
				DBConn.update("update web_info set web_info_visited="+visited);
			} catch (SQLException e) {
				logger.error("获取网站基本信息异常："+e.toString());
			}
			session.setAttribute("lsf_tc_webinfo",wi);
			out.write(content+"~"+visited+"~"+cellphone+"~"+fixphone+"~"+mail+"~"+fax+"~"+address);
		}else{
			wi = (WebInfo)session.getAttribute("lsf_tc_webinfo");
			out.write(wi.getContent()+"~"+wi.getVisited()+"~"+wi.getCellphone()+"~"+wi.getFixphone()+"~"+wi.getMail()+"~"+wi.getFax()+"~"+wi.getAddress());
		}

	}

	/**
	 * 修改唐潮简介.
	 * @return out流输出 insertsuccess||insertfail||formatfail字符串
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		String html = request.getParameter("html");
		
		//判断是否具有修改简介的权限
		if(("null".equals(CheckSessionRole.check(request)))||!("老板".equals(CheckSessionRole.check(request)))){
			String IP = Utils.getIP(request);
			String MAC = Utils.getMACAddress(IP);
			logger.error("用户IP:"+IP+"("+MAC+")没有修改简介的权限！");
			out.write("formatfail");
			response.sendRedirect(request.getContextPath()+"sys/login.html");
			return;
		}
		
		//如果当前是老板则修改简介
		if("老板".equals(CheckSessionRole.check(request))){
			if(html.length()!=0){
				String sql = "update web_info set web_info_content='"+html+"'";
				try {
					DBConn.getConnection();
					DBConn.update(sql);
				} catch (Exception e) {
					logger.error("数据修改异常:"+e.toString());
					out.write("insertfail");
				}
				out.write("insertsuccess");
			}
		}
		
		WebInfo wi= (WebInfo)session.getAttribute("lsf_tc_webinfo");
		wi.setContent(html);
		session.setAttribute("lsf_tc_webinfo",wi);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
	}

}
