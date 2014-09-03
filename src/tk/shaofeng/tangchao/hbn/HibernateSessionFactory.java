package tk.shaofeng.tangchao.hbn;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory
{
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Configuration configuration = new Configuration();

	// create Configuration instance
	private static SessionFactory sessionFactory;
	private static String configFile = CONFIG_FILE_LOCATION;

	static
	{
		try
		{
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		}
		catch (Exception e)
		{
			Logger.getLogger(HibernateSessionFactory.class).error(e.getMessage(), e);
		}
	}

	public static Session getSession()
	{
		Session session = (Session) threadLocal.get();
		if (session == null || !session.isOpen())
		{
			if (sessionFactory == null)
			{
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession() : null;
		}
		return session;
	}

	public static void rebuildSessionFactory()
	{
		try
		{
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		}
		catch (HibernateException e)
		{
			Logger.getLogger(HibernateSessionFactory.class).error(e.getMessage(), e);
		}
	}

	public static void closeSession()
	{
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);
		if (session != null)
		{
			session.close();
		}
	}
}
