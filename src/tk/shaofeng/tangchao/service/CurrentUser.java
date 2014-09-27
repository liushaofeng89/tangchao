package tk.shaofeng.tangchao.service;

import tk.shaofeng.tangchao.model.UserModel;

/**
 * 当前用户
 * 
 * @author liushaofeng
 * @date 2014-9-27
 */
public class CurrentUser extends UserModel
{
	private static CurrentUser instance = null;

	private CurrentUser()
	{
	}

	public static CurrentUser getInstance()
	{
		if (instance == null)
		{
			instance = new CurrentUser();
		}
		return instance;
	}

	public static void setInstance(CurrentUser instance)
	{
		CurrentUser.instance = instance;
	}
}
