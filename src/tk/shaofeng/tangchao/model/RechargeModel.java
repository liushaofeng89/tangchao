package tk.shaofeng.tangchao.model;

import java.util.Date;

/**
 * 用户充值模型
 * 
 * @author liushaofeng
 * @date 2014-8-31
 */
public class RechargeModel
{
	private int id;
	private long cardId;
	private double rechargeAmount;
	private double remain;
	private Date rechageDate;

	public RechargeModel()
	{
	}

	public RechargeModel(long carId, int rechargeAmount, double remain, Date rechageDate)
	{
		this.cardId = carId;
		this.rechargeAmount = rechargeAmount;
		this.remain = remain;
		this.rechageDate = rechageDate;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public long getCardId()
	{
		return cardId;
	}

	public void setCardId(long cardId)
	{
		this.cardId = cardId;
	}

	public double getRechargeAmount()
	{
		return rechargeAmount;
	}

	public void setRechargeAmount(int rechargeAmount)
	{
		this.rechargeAmount = rechargeAmount;
	}

	public void setRechargeAmount(double rechargeAmount)
	{
		this.rechargeAmount = rechargeAmount;
	}

	public double getRemain()
	{
		return remain;
	}

	public void setRemain(double remain)
	{
		this.remain = remain;
	}

	public Date getRechageDate()
	{
		return rechageDate;
	}

	public void setRechageDate(Date rechageDate)
	{
		this.rechageDate = rechageDate;
	}

}
