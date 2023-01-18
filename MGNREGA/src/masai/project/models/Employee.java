package masai.project.models;

import java.sql.Date;

public class Employee {

	private int eid;
	private int GPMeid;
	private int peid;
	private String ename;
	private String eaddress;
	private Date ejoiningdate;
	private int ewage;
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getGPMeid() {
		return GPMeid;
	}

	public void setGPMeid(int gPMeid) {
		GPMeid = gPMeid;
	}

	public int getPeid() {
		return peid;
	}

	public void setPeid(int peid) {
		this.peid = peid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
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

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", GPMeid=" + GPMeid + ", peid=" + peid + ", ename=" + ename + ", eaddress="
				+ eaddress + ", ejoiningdate=" + ejoiningdate + ", ewage=" + ewage + "]";
	}

	public Employee(int eid, int gPMeid, int peid, String ename, String eaddress, Date ejoiningdate, int ewage) {
		super();
		this.eid = eid;
		GPMeid = gPMeid;
		this.peid = peid;
		this.ename = ename;
		this.eaddress = eaddress;
		this.ejoiningdate = ejoiningdate;
		this.ewage = ewage;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
