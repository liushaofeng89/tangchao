package tk.tangchao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import sun.jdbc.rowset.CachedRowSet;
import tk.tangchao.pojo.WebInfo;
import tk.tangchao.util.DBConn;


public class InitServlet extends HttpServlet {

	/**
	 * 初始化日志
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(InitServlet.class);
	
	/**
	 * 默认构造方法
	 */
	public InitServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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

	
	public void init(ServletConfig config) throws ServletException {

		//初始化日志器
        super.init(config);
        String prefix = getServletContext().getRealPath("/");
        String file = getInitParameter("log4jFilePath");
        if (file != null) {
        	System.setProperty("webApp.root", prefix);/*替换log4j.properties文件中的${webApp.root}参数*/
            PropertyConfigurator.configure(prefix + file);
        }
        
    }


}
