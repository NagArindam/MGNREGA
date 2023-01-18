package masai.project.models;

public class GPM {

	private int GPMID;
	private String GPMname;
	private String GPMaddress;
	private String GPMphoneno;
	private String GPMpassword;
	
	public int getGPMID() {
		return GPMID;
	}

	public void setGPMID(int gPMID) {
		GPMID = gPMID;
	}

	public String getGPMname() {
		return GPMname;
	}

	public void setGPMname(String gPMname) {
		GPMname = gPMname;
	}

	public String getGPMaddress() {
		return GPMaddress;
	}

	public void setGPMaddress(String gPMaddress) {
		GPMaddress = gPMaddress;
	}

	public String getGPMphoneno() {
		return GPMphoneno;
	}

	public void setGPMphoneno(String gPMphoneno) {
		GPMphoneno = gPMphoneno;
	}

	public String getGPMpassword() {
		return GPMpassword;
	}

	public void setGPMpassword(String gPMpassword) {
		GPMpassword = gPMpassword;
	}

	@Override
	public String toString() {
		return "GPM [GPMID=" + GPMID + ", GPMname=" + GPMname + ", GPMaddress=" + GPMaddress + ", GPMphoneno="
				+ GPMphoneno + ", GPMpassword=" + GPMpassword + "]";
	}

	public GPM(int gPMID, String gPMname, String gPMaddress, String gPMphoneno, String gPMpassword) {
		super();
		GPMID = gPMID;
		GPMname = gPMname;
		GPMaddress = gPMaddress;
		GPMphoneno = gPMphoneno;
		GPMpassword = gPMpassword;
	}

	public GPM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
