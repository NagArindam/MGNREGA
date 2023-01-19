package masai.project.dao;

import java.util.List;

import masai.project.exception.BDOexception;
import masai.project.exception.CredException;
import masai.project.exception.EmployeeException;
import masai.project.exception.GPMexception;
import masai.project.exception.ProjectException;
import masai.project.models.Employee;
import masai.project.models.GPM;
import masai.project.models.Project;

public interface BDOdao {
	
	public final String username = "bdo123";
	public final String password = "bdo123";
	
	public String BDOLogin(String username, String password)throws CredException;
	
	public String createAProject(Project proj)throws ProjectException;
	
	public List<Project> viewListOfProject() throws ProjectException;
	
	public String createNewGPM(GPM gpm) throws GPMexception;
	
	public List<GPM> viewAllGPM() throws GPMexception;
	
	public String allocateProjectToGPM(int pid, int GPMID) throws ProjectException, GPMexception, BDOexception;
	
	public List<Employee> listOfEmployeeOnProject(int pid)throws ProjectException, EmployeeException, BDOexception;
	

}
