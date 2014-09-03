package tk.shaofeng.tangchao.hbn;

import org.hibernate.Session;

public abstract class AbstractTCDAO
{
	public Session getSession()
	{
		return HibernateSessionFactory.getSession();
	}
}
