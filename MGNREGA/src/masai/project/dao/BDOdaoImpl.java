package masai.project.dao;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> listOfEmployeeOnProject(int pid) throws ProjectException, EmployeeException, BDOexception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
