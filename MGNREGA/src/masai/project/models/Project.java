package masai.project.models;

public class Project {

	private int pid;
	private int GPMpid;
	private String pname;
	private int pcost;
	private int ptiming;
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getGPMpid() {
		return GPMpid;
	}

	public void setGPMpid(int gPMpid) {
		GPMpid = gPMpid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPcost() {
		return pcost;
	}

	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	public int getPtiming() {
		return ptiming;
	}

	public void setPtiming(int ptiming) {
		this.ptiming = ptiming;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", GPMpid=" + GPMpid + ", pname=" + pname + ", pcost=" + pcost + ", ptiming="
				+ ptiming + "]";
	}

	public Project(int pid, int gPMpid, String pname, int pcost, int ptiming) {
		super();
		this.pid = pid;
		GPMpid = gPMpid;
		this.pname = pname;
		this.pcost = pcost;
		this.ptiming = ptiming;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
