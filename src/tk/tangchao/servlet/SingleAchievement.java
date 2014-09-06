package tk.tangchao.servlet;

import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import tk.tangchao.util.Utils;

public class SingleAchievement extends HttpServlet {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -1684501280174291471L;

	/**
	 * Constructor of the object.
	 */
	public SingleAchievement() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String beginTime = request.getParameter("dateTime1");
		String endTime = request.getParameter("dateTime2");  
		
		
		OutputStream out = response.getOutputStream();
		try {
		DefaultPieDataset dataset = new DefaultPieDataset();   
		dataset.setValue("加洗", 50);  
		dataset.setValue("烫染", 41);  
		dataset.setValue("洗剪吹", 20);  
		dataset.setValue("洗头", 10);  
		dataset.setValue("加奶疗/还原酸", 5);  
		
		
		JFreeChart chart = ChartFactory.createPieChart(
				"饼状图",                                  //图表标题
				dataset,                                  //数据集
				true,                                     //是否显示图例
				true,                                     //是否生成提示工具
				false                                     //是否生成url连接
				);
		
		
		
		//设置图片标题的字体和大小
		Font font = new Font("黑体",Font.CENTER_BASELINE,20);
		TextTitle _title = new TextTitle(beginTime+"-"+endTime+"业绩查询结果");
		_title.setFont(font);
		chart.setTitle(_title);
		
		PiePlot pieplot = (PiePlot) chart.getPlot();   
		pieplot.setLabelFont(new Font("宋体", 0, 11));   
				
		//设置饼图是圆的（true），还是椭圆的（false）；默认为true   
		pieplot.setCircular(true);   
		
		//设置显示每个分区的值（{0}表示section名，{1}表示section的值，{2}表示百分比。）
		pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator(("{0}: ({1})"))); 
				
		//没有数据的时候显示的内容   
		pieplot.setNoDataMessage("无数据显示");   
		pieplot.setLabelGap(0.02D); 
				
		//设置图表下方的图例说明字体
		chart.getLegend().setItemFont(new Font("微软雅黑",Font.BOLD,12));
				
		        
		response.setCharacterEncoding("utf-8");
		response.setContentType("image/png");
		ChartUtilities.writeChartAsPNG(out, chart,(int)(Utils.getScreenSize().width * 0.78), (int)(Utils.getScreenSize().height * 0.55));
				
		}
		catch (Exception e) {
		System.err.println(e.toString());
		}
		finally {
		out.close();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
