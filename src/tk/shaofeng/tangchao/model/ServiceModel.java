package tk.shaofeng.tangchao.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务业务模型
 * 
 * @author liushaofeng
 * @date 2014-8-18
 */
public class ServiceModel
{
	private int id;
	private String name;
	private boolean enabled;
	private List<ServiceChangeHistoryModel> priceList = new ArrayList<ServiceChangeHistoryModel>();

	public ServiceModel()
	{

	}

	public ServiceModel(String name)
	{
		this.name = name;
		this.enabled = true;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	public List<ServiceChangeHistoryModel> getPriceList()
	{
		return priceList;
	}

	public void setPriceList(List<ServiceChangeHistoryModel> priceList)
	{
		this.priceList = priceList;
	}

}
