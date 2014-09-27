package tk.shaofeng.tangchao.model;

import java.util.Calendar;
import java.util.Date;

/**
 * 服务项目价格修改历史记录模型
 * 
 * @author liushaofeng
 * @date 2014-9-27
 */
public class ServiceChangeHistoryModel implements Comparable<ServiceChangeHistoryModel>
{
	private int id;
	private int serviceId;
	private float price;
	private Date lastModifyTime;

	public ServiceChangeHistoryModel()
	{

	}

	public ServiceChangeHistoryModel(int serviceId, float price)
	{
		this.serviceId = serviceId;
		this.price = price;
		this.lastModifyTime = Calendar.getInstance().getTime();
	}

	public ServiceChangeHistoryModel(String priceStr)
	{
		// TODO Auto-generated constructor stub
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getServiceId()
	{
		return serviceId;
	}

	public void setServiceId(int serviceId)
	{
		this.serviceId = serviceId;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public Date getLastModifyTime()
	{
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime)
	{
		this.lastModifyTime = lastModifyTime;
	}

	@Override
	public int compareTo(ServiceChangeHistoryModel o)
	{
		return (int) (o.getLastModifyTime().getTime() - this.getLastModifyTime().getTime());
	}

}
