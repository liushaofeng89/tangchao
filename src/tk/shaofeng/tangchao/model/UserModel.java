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
	private int cardId;
	private String userName;
	private boolean isMale;
	private Date createDate;
	private float discount;
	private String cellPhoneNo;
	private double remain;

	public UserModel()
	{
	}

	public UserModel(String userName, boolean isMale, Date createDate, int cardId, float discounts, String cellPhoneNo)
	{
		this.userName = userName;
		this.isMale = isMale;
		this.createDate = createDate;
		this.cardId = cardId;
		this.discount = discounts;
		this.cellPhoneNo = cellPhoneNo;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public int getCardId()
	{
		return cardId;
	}

	public void setCardId(int cardId)
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

	public String getCellPhoneNo()
	{
		return cellPhoneNo;
	}

	public void setCellPhoneNo(String cellPhoneNo)
	{
		this.cellPhoneNo = cellPhoneNo;
	}

	public double getRemain()
	{
		return remain;
	}

	public void setRemain(double remain)
	{
		this.remain = remain;
	}
}
