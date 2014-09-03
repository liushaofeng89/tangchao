package tk.shaofeng.tangchao.model;

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
	private float price;

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

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}
}
