package masai.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import masai.project.exception.CredException;
import masai.project.exception.EmployeeException;
import masai.project.exception.GPMexception;
import masai.project.exception.ProjectException;
import masai.project.models.Employee;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> viewdetailsOfEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignEmployeeToAProject(int eid, int pid) throws EmployeeException, GPMexception, ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

}
