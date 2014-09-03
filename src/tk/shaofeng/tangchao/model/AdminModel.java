package tk.shaofeng.tangchao.model;

/**
 * 管理员模型
 * 
 * @author liushaofeng
 * @date 2014-8-18
 */
public class AdminModel
{
	private String name;
	private String pwd;

	public AdminModel()
	{
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
}
