package tk.shaofeng.tangchao.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tk.shaofeng.tangchao.hbn.AbstractTCDAO;
import tk.shaofeng.tangchao.model.UserModel;

/**
 * query user information
 * 
 * @author liushaofeng
 * @date 2014-8-23
 */
public class UserQueryDAO extends AbstractTCDAO
{
	/**
	 * find all user informationo
	 * 
	 * @param sortType sort type
	 * @return all users' information
	 */
	@SuppressWarnings("unchecked")
	public List<UserModel> findAllUserByTimeSort(String sortType)
	{
		Session session = getSession();
		String hql = "from UserModel as user order by user.createDate desc";
		Query createQuery = session.createQuery(hql);
//		createQuery.setParameter(0, sortType);
		List<UserModel> list = (List<UserModel>) createQuery.list();
		session.close();
		return list;
	}

	/**
	 * get one user by card id
	 * 
	 * @param cardId user card id
	 * @return the user information with the input card id
	 */
	@SuppressWarnings("unchecked")
	public List<UserModel> findUserByCardId(int cardId)
	{
		String hql = "from UserModel as user where user.cardId = ?";
		Session session = getSession();
		Query createQuery = session.createQuery(hql);
		createQuery.setParameter(0, cardId);
		List<UserModel> list = (List<UserModel>) createQuery.list();
		session.close();
		return list;
	}
}
