package tk.tangchao.pojo;

//业务明细

public class User_Business_Info {
	private int u_b_id;
	private String userId;
	private String businessId;
	private String addTime;
	private String recordBy;
	public int getU_b_id() {
		return u_b_id;
	}
	public void setU_b_id(int uBId) {
		u_b_id = uBId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getRecordBy() {
		return recordBy;
	}
	public void setRecordBy(String recordBy) {
		this.recordBy = recordBy;
	}
	
}
