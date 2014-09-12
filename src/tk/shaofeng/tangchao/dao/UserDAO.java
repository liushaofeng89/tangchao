package tk.shaofeng.tangchao.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tk.shaofeng.tangchao.hbn.AbstractTCDAO;
import tk.shaofeng.tangchao.model.UserModel;

/**
 * vip user dao
 * 
 * @author liushaofeng
 * @date 2014-8-22
 */
public class UserDAO extends AbstractTCDAO
{

	/**
	 * save a vip user to db
	 * 
	 * @param user the user which need to register
	 */
	public boolean save(UserModel user)
	{
		Transaction tx = null;
		try
		{
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			session.close();
			return true;
		}
		catch (Exception e)
		{
			Logger.getLogger(this.getClass()).error(e.getMessage(), e);
			tx.rollback();
			return false;
		}
	}
}
