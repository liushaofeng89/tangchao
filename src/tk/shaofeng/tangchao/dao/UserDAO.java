package tk.shaofeng.tangchao.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
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
		Session session = getSession();
		try
		{
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
			session.close();
			return false;
		}
	}

	/**
	 * find user info by card ID
	 * 
	 * @param cardId card ID
	 * @return user model
	 */
	@SuppressWarnings("unchecked")
	public UserModel findByCardId(int cardId)
	{
		Session session = getSession();
		Query createQuery = session.createQuery("from UserModel model where model.cardId = ?");
		createQuery.setParameter(0, cardId);
		List list = createQuery.list();
		session.close();
		if (list.isEmpty())
		{
			return null;
		}
		else
		{
			return (UserModel) list.get(0);
		}
	}
}
