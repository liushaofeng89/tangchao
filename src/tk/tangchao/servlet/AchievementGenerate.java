package tk.tangchao.servlet;

import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import tk.tangchao.util.Utils;


public class AchievementGenerate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AchievementGenerate() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String beginTime = request.getParameter("dateTime1");
		String endTime = request.getParameter("dateTime2");  
		String type = request.getParameter("type");  
		
		OutputStream out = response.getOutputStream();
		try {
		DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
		mDataset.addValue(20, "烫染", "李四");
		mDataset.addValue(40, "洗剪吹", "李四");
		mDataset.addValue(0, "加洗", "李四");
		mDataset.addValue(11, "洗头", "李四");
		mDataset.addValue(10, "加奶疗/还原酸", "李四");
		
		mDataset.addValue(12, "烫染", "王五");
		mDataset.addValue(60, "洗剪吹", "王五");
		mDataset.addValue(0, "加洗", "王五");
		mDataset.addValue(2, "洗头", "王五");
		mDataset.addValue(40, "加奶疗/还原酸", "王五");
		
		mDataset.addValue(10, "烫染", "展昭");
		mDataset.addValue(45, "洗剪吹", "展昭");
		mDataset.addValue(45, "加洗", "展昭");
		mDataset.addValue(7, "洗头", "展昭");
		mDataset.addValue(13, "加奶疗/还原酸", "展昭");
		
		mDataset.addValue(10, "烫染", "宋江");
		mDataset.addValue(45, "洗剪吹", "宋江");
		mDataset.addValue(45, "加洗", "宋江");
		mDataset.addValue(7, "洗头", "宋江");
		mDataset.addValue(13, "加奶疗/还原酸", "宋江");
		
		mDataset.addValue(10, "烫染", "吴三桂");
		mDataset.addValue(45, "洗剪吹", "吴三桂");
		mDataset.addValue(45, "加洗", "吴三桂");
		mDataset.addValue(7, "洗头", "吴三桂");
		mDataset.addValue(13, "加奶疗/还原酸", "吴三桂");
		
		mDataset.addValue(10, "烫染", "武大郎");
		mDataset.addValue(45, "洗剪吹", "武大郎");
		mDataset.addValue(45, "加洗", "武大郎");
		mDataset.addValue(7, "洗头", "武大郎");
		mDataset.addValue(13, "加奶疗/还原酸", "武大郎");
		
		mDataset.addValue(10, "烫染", "宋青书");
		mDataset.addValue(45, "洗剪吹", "宋青书");
		mDataset.addValue(45, "加洗", "宋青书");
		mDataset.addValue(7, "洗头", "宋青书");
		mDataset.addValue(13, "加奶疗/还原酸", "宋青书");
		
		mDataset.addValue(12, "烫染", "武松");
		mDataset.addValue(14, "洗剪吹", "武松");
		mDataset.addValue(5, "加洗", "武松");
		mDataset.addValue(27, "洗头", "武松");
		mDataset.addValue(13, "加奶疗/还原酸", "武松");
		
		mDataset.addValue(15, "烫染", "吴三");
		mDataset.addValue(15, "洗剪吹", "吴三");
		mDataset.addValue(20, "加洗", "吴三");
		mDataset.addValue(14, "洗头", "吴三");
		mDataset.addValue(5, "加奶疗/还原酸", "吴三");
		
		
		
		
		
		JFreeChart mBarChart = ChartFactory.createBarChart(
				beginTime+"-"+endTime+"业绩查询结果",     //图表标题
				"员工",                                   //横轴（目录轴）标签
				"数量",                                   //纵轴（数值轴）标签
				mDataset,                                 //数据集
				PlotOrientation.VERTICAL,                 //图标方向
				true,                                     //是否显示图例
				true,                                     //是否生成提示工具
				false                                     //是否生成url连接
				);
		
		
				//图表标题设置  
				TextTitle mTextTitle = mBarChart.getTitle();  
				mTextTitle.setFont(new Font("宋体", Font.BOLD, 20));  
				//mBarChart.setTitle(new TextTitle("学校人员分布图",new Font("黑体", Font.BOLD, 20)));  
				//图表图例设置  
				LegendTitle mLegend = mBarChart.getLegend();  
				if(mLegend != null)  
					mLegend.setItemFont(new Font("宋体", Font.CENTER_BASELINE, 15));  
				//mBarChart.getLegend().setItemFont(new Font("宋体", Font.CENTER_BASELINE, 15));  
				//设置柱状图轴  
				CategoryPlot mPlot = (CategoryPlot)mBarChart.getPlot();  
				
			    //x轴  
				CategoryAxis mDomainAxis = mPlot.getDomainAxis();  
				//设置x轴标题的字体  
				mDomainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 15));  
				//设置x轴坐标字体  
				mDomainAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 15));  
				//y轴  
				ValueAxis mValueAxis = mPlot.getRangeAxis();  
				//设置y轴标题字体  
				mValueAxis.setLabelFont(new Font("宋体", Font.PLAIN, 15));  
				//设置y轴坐标字体  
				mValueAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 15));  
			    //柱体显示数值  
				BarRenderer mRenderer= new BarRenderer();  
				mRenderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
				mRenderer.setItemLabelFont(new Font("宋体", Font.PLAIN, 10));  
				mRenderer.setItemLabelsVisible(true);  
				mPlot.setRenderer(mRenderer);  
				
				response.setCharacterEncoding("utf-8");
				response.setContentType("image/png");
				ChartUtilities.writeChartAsPNG(out, mBarChart,(int)(Utils.getScreenSize().width * 0.78), (int)(Utils.getScreenSize().height * 0.55));
				
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

	public void init() throws ServletException {
	}

}
