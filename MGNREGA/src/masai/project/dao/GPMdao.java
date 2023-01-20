package masai.project.dao;

import java.util.List;

import masai.project.exception.CredException;
import masai.project.exception.EmployeeException;
import masai.project.exception.GPMexception;
import masai.project.exception.ProjectException;
import masai.project.models.Employee;

public interface GPMdao {
	
	public String GPMLogin(String GPMphoneno, String GPMpassword)throws GPMexception, CredException;
	
	public String createEmployee(Employee emp) throws EmployeeException;
	
	public List<Employee> viewdetailsOfEmployee() throws EmployeeException;
	
	public String assignEmployeeToAProject(int eid, int pid)throws EmployeeException,GPMexception, ProjectException;
	
	

}
