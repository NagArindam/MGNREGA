package masai.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import masai.project.exception.BDOexception;
import masai.project.exception.CredException;
import masai.project.exception.EmployeeException;
import masai.project.exception.GPMexception;
import masai.project.exception.ProjectException;
import masai.project.models.Employee;
import masai.project.models.GPM;
import masai.project.models.Project;
import masai.project.utility.DBUtil;

public class BDOdaoImpl implements BDOdao{

	@Override
	public String BDOLogin(String username, String password) throws CredException {
		
		String msg = "Invalid username or password";
		
		if(username.equals(BDOdao.username) && password.equals(BDOdao.password)) {
			msg = "Welcome BDO. Your Login is Successfull.";
		}
		else {
			throw new CredException(msg);
		}
		
		return msg;
	}

	@Override
	public String createAProject(Project proj) throws ProjectException {
		
		String msg = "Project is not created.";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into project(pname, pcost, ptiming) values(?,?,?)");
			
			ps.setString(1, proj.getPname());
			ps.setInt(2, proj.getPcost());
			ps.setInt(3, proj.getPtiming());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				msg = "Project Successfully Created";
			else
				throw new ProjectException(msg);
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		
		return msg;
	}

	@Override
	public List<Project> viewListOfProject() throws ProjectException {
		
		List<Project> listofproject = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from project");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int pid = rs.getInt("pid");
				int GPMpid = rs.getInt("GPMpid");
				String pname = rs.getString("pname");
				int pcost = rs.getInt("pcost");
				int ptiming = rs.getInt("ptiming");
				
				Project pr = new Project(pid, GPMpid, pname, pcost, ptiming);
				
				listofproject.add(pr);
			}
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		if(listofproject.size()==0) {
			throw new ProjectException("Project Not Found");
		}
		
		return listofproject;
	}

	@Override
	public String createNewGPM(GPM gpm) throws GPMexception {
		String msg = "GPM Not Created Successfully!";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into GPM(GPMname, GPMaddress, GPMphoneno, GPMpassword) values(?,?,?,?)");
			
			ps.setString(1, gpm.getGPMname());
			ps.setString(2, gpm.getGPMaddress());
			ps.setString(3, gpm.getGPMphoneno());
			ps.setString(4, gpm.getGPMpassword());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				msg = "New Gram Panchayat Members(GPM) created Successfully.";
			else
				throw new GPMexception(msg);
			
		} catch (SQLException e) {
			throw new GPMexception(e.getMessage());
		}
		
		
		
		return msg;
	}

	@Override
	public List<GPM> viewAllGPM() throws GPMexception {
		
		List<GPM> listOfGPM = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from GPM");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int GPMID = rs.getInt("GPMID");
				String GPMname = rs.getString("GPMname");
				String GPMaddress = rs.getString("GPMaddress");
				String GPMphoneno = rs.getString("GPMphoneno");
				String GPMpassword = rs.getString("GPMpassword");
				
				GPM gpm = new GPM(GPMID, GPMname, GPMaddress, GPMphoneno, GPMpassword);
				
				listOfGPM.add(gpm);
			}
			
		} catch (SQLException e) {
			throw new GPMexception(e.getMessage());
		}
		
		if(listOfGPM.size()==0) {
			throw new GPMexception("Any Gram Panchayat Member(GPM) was not found! ");
		}
		
		return listOfGPM;
	}

	@Override
	public String allocateProjectToGPM(int pid, int GPMID) throws ProjectException, GPMexception, BDOexception {
		String msg = "Project is not allocated!";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from GPM where GPMID=?");
			
			ps.setInt(1, GPMID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("select * from project where pid=?");
				
				ps2.setInt(1, pid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					PreparedStatement ps3 = conn.prepareStatement("update project set GPMpid=? where pid=?");
					
					ps3.setInt(1, GPMID);
					ps3.setInt(2, pid);
					
					int x = ps3.executeUpdate();
					
					if(x>0) {
						msg = "Project with Project ID(pid): "+pid +" is Allocated with Gram Panchayat Member(GPM) id: ";
						return msg;
					}
				}
				else {
					throw new ProjectException("Project is not exist with that pid: "+pid);
				}
			}
			else {
					throw new GPMexception("This Gram Pancahyat Member(GPM) id: "+GPMID+ " is not exist");
			}
			
		} catch (SQLException e) {
			throw new BDOexception(e.getMessage());
		}
		
		
		return msg;
	}

	@Override
	public List<Employee> listOfEmployeeOnProject(int pid) throws ProjectException, EmployeeException, BDOexception {
		
		List<Employee> listOfEmp = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Project where pid=?");
			
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("select * from Employee e INNER JOIN Project p ON e.peid = p.pid where p.pid=?");
				
				ps2.setInt(1, pid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				while(rs2.next()) {
					
					int eid = rs2.getInt("eid");
					int GPMeid = rs2.getInt("GPMeid");
					int peid = rs2.getInt("peid");
					String ename = rs2.getString("ename");
					String eaddress = rs2.getString("eaddress");
					Date ejoiningdate = rs2.getDate("ejoiningdate");
					int ewage = rs2.getInt("ewage");
					
					Employee emp = new Employee(eid, GPMeid, peid, ename, eaddress, ejoiningdate, ewage);
					
					listOfEmp.add(emp);
				}
			}
			else {
				throw new ProjectException("No Project Found with this pid: "+pid);
			}
			
		} catch (SQLException e) {
			throw new BDOexception(e.getMessage());
		}
		
		if(listOfEmp.size()==0) {
			throw new EmployeeException("Employee is not found with pid:  "+pid);
		}
		
		return listOfEmp;
	}
	
	

}
