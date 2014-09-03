package tk.shaofeng.tangchao.dao;

import java.util.List;

import org.hibernate.Query;

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
		String hql = "from UserModel as user order by user.createDate desc";
		Query createQuery = getSession().createQuery(hql);
		// createQuery.setString(0, sortType);
		return (List<UserModel>) createQuery.list();
	}

	/**
	 * get one user by card id
	 * 
	 * @param cardId user card id
	 * @return the user information with the input card id
	 */
	@SuppressWarnings("unchecked")
	public List<UserModel> findUserByCardId(String cardId)
	{
		String hql = "from UserModel as user where user.cardId = ?";
		Query createQuery = getSession().createQuery(hql);
		createQuery.setString(0, cardId);
		return (List<UserModel>) createQuery.list();
	}
}
