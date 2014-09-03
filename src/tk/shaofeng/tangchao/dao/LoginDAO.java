package tk.shaofeng.tangchao.dao;

/**
 * 管理员登陆数据访问
 * 
 * @author liushaofeng
 * @date 2014-8-18
 */
public class LoginDAO
{
	/**
	 * verify the login user info
	 * 
	 * @param name login name
	 * @param pwd login password
	 * @return login successe
	 */
	public boolean verify(String name, String pwd)
	{
		if ("Tangchao".equals(name) && "Tangchao".equals(pwd))
		{
			return true;
		}
		return false;
	}
}
