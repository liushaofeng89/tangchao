package tk.shaofeng.tangchao.model;

import java.util.Date;

/**
 * 用户模型
 * 
 * @author liushaofeng
 * @date 2014-8-18
 */
public class UserModel
{
	private int userId;
	private long cardId;
	private String userName;
	private boolean isMale;
	private Date createDate;
	private float discount;

	public UserModel()
	{
	}

	public UserModel(String userName, boolean isMale, Date createDate, long cardId, float discounts)
	{
		this.userName = userName;
		this.isMale = isMale;
		this.createDate = createDate;
		this.cardId = cardId;
		this.discount = discounts;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public long getCardId()
	{
		return cardId;
	}

	public void setCardId(long cardId)
	{
		this.cardId = cardId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public boolean getIsMale()
	{
		return isMale;
	}

	public void setIsMale(boolean isMale)
	{
		this.isMale = isMale;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public float getDiscount()
	{
		return discount;
	}

	public void setDiscount(float discount)
	{
		this.discount = discount;
	}
}
