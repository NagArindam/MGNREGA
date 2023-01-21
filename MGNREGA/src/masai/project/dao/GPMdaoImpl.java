package masai.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import masai.project.exception.CredException;
import masai.project.exception.EmployeeException;
import masai.project.exception.GPMexception;
import masai.project.exception.ProjectException;
import masai.project.models.Employee;
import masai.project.models.EmployeeWageDTO;
import masai.project.utility.DBUtil;

public class GPMdaoImpl implements GPMdao{
	
	public static int GPMIDstore;

	@Override
	public String GPMLogin(String GPMphoneno, String GPMpassword) throws GPMexception, CredException {
		String msg = "Incorrect phone or password!";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from GPM");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String phoneno = rs.getString("GPMphone");
				String password = rs.getString("GPMpassword");
				
				if(phoneno.equals(GPMphoneno) && password.equals(GPMpassword)) {
					msg = "Login Successfull";
					GPMIDstore = rs.getInt("GPMID");
					return msg;
				}
			}
			msg = "Wrong Credential!";
			throw new CredException(msg);
			
		} catch (SQLException e) {
			throw new GPMexception(e.getMessage());
		}
		
	}

	@Override
	public String createEmployee(Employee emp) throws EmployeeException {
		String msg = "Employee is not created";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Employee (GPMeid, peid, ename, eaddress, ejoiningdate, ewage) values(?,?,?,?,curdate(),?)");
			
			ps.setInt(1, emp.getGPMeid());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getEaddress());
			ps.setInt(4, emp.getEwage());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				msg = "Employee is created successfully.";
			else
				throw new EmployeeException(msg);
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		return msg;
	}

	@Override
	public List<Employee> viewdetailsOfEmployee() throws EmployeeException {
		
		List<Employee> listofemp = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Employee");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				int GPMeid = rs.getInt("GPMeid");
				int peid = rs.getInt("peid");
				String ename = rs.getString("ename");
				String eaddress = rs.getString("eaddress");
				Date ejoiningdate = rs.getDate("ejoiningdate");
				int ewage = rs.getInt("ewage");
				
				Employee emp = new Employee(eid, GPMeid, peid, ename, eaddress, ejoiningdate, ewage);
				
				listofemp.add(emp);
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(listofemp.size()==0) {
			throw new EmployeeException("No Employee Found!");
		}
		
		
		return listofemp;
	}

	@Override
	public String assignEmployeeToAProject(int eid, int pid) throws EmployeeException, GPMexception, ProjectException {
		String msg = "Employee is not assigned to a Project.";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Employee where eid=? AND GPMeid=?");
			
			ps.setInt(1, eid);
			ps.setInt(2, GPMIDstore);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("select * from Project where pid=? AND GPMpid=?");
				ps2.setInt(1, pid);
				ps2.setInt(2, GPMIDstore);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					PreparedStatement ps3 = conn.prepareStatement("update Employee set peid=? where eid=?");
					ps3.setInt(1, pid);
					ps3.setInt(2, eid);
					
					int x = ps3.executeUpdate();
					
					if(x>0) {
						msg = "Project with ID: "+pid+" Successfully assigned to Employee with Id: "+eid;
						return msg;
					}
				}
				else {
					throw new ProjectException("Not Assigned any Gram Panchayat Member (GPM) by BDO or Project is not exist.");
				}
			}
			else {
				throw new EmployeeException("Employee is assigned by another Gram Panchayat Member(GPM) or Employee is not exist.");
			}
			
		} catch (SQLException e) {
			throw new GPMexception(e.getMessage()); 
		}
		
		
		
		return msg;
	}

	@Override
	public List<EmployeeWageDTO> daysAndWagesOfEmployee() throws EmployeeException {
		
		List<EmployeeWageDTO> daysandwageofemp = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select e.eid, e.ename, p.pid, p.pname, e.ejoiningdate, datediff(curdate(),ejoiningdate) days, e.ewage, datediff(curdate(),ejoiningdate)*e.ewage total from Employee e INNER JOIN Project p ON e.peid = p.pid group by e.eid");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				String pname = rs.getString("pname");
				int pid = rs.getInt("pid");
				Date ejoiningdate = rs.getDate("ejoiningdate");
				int ewage = rs.getInt("ewage");
				int amount = rs.getInt("total");
				int dayswork = rs.getInt("days");
				
				EmployeeWageDTO totalemp = new EmployeeWageDTO(eid, ename, pname, pid, ejoiningdate, ewage, amount, dayswork);
				
				daysandwageofemp.add(totalemp);
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(daysandwageofemp.size()==0) {
			throw new EmployeeException("Employee noy found!");
		}
		
		
		
		
		return daysandwageofemp;
	}

}
