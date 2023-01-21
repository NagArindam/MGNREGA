package masai.project.models;

import java.sql.Date;

public class EmployeeWageDTO {
	
	private int eid;
	private String ename;
	private String pname;
	private int pid;
	private Date ejoiningdate;
	private int ewage;
	private int amount;
	private int dayswork;
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Date getEjoiningdate() {
		return ejoiningdate;
	}

	public void setEjoiningdate(Date ejoiningdate) {
		this.ejoiningdate = ejoiningdate;
	}

	public int getEwage() {
		return ewage;
	}

	public void setEwage(int ewage) {
		this.ewage = ewage;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDayswork() {
		return dayswork;
	}

	public void setDayswork(int dayswork) {
		this.dayswork = dayswork;
	}

	@Override
	public String toString() {
		return "EmployeeWageDTO [eid=" + eid + ", ename=" + ename + ", pname=" + pname + ", pid=" + pid
				+ ", ejoiningdate=" + ejoiningdate + ", ewage=" + ewage + ", amount=" + amount + ", dayswork="
				+ dayswork + "]";
	}

	public EmployeeWageDTO(int eid, String ename, String pname, int pid, Date ejoiningdate, int ewage, int amount,
			int dayswork) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.pname = pname;
		this.pid = pid;
		this.ejoiningdate = ejoiningdate;
		this.ewage = ewage;
		this.amount = amount;
		this.dayswork = dayswork;
	}

	public EmployeeWageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
