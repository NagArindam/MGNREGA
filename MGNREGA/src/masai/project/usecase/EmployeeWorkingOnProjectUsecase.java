package masai.project.usecase;

import java.util.List;
import java.util.Scanner;

import masai.project.dao.BDOdao;
import masai.project.dao.BDOdaoImpl;
import masai.project.exception.BDOexception;
import masai.project.exception.EmployeeException;
import masai.project.exception.ProjectException;
import masai.project.models.Employee;

public class EmployeeWorkingOnProjectUsecase {
	
	public static void employeeWorkingOnProject() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project Id to see list of all Employee Working on a project and their wages: ");
		int pid = sc.nextInt();
		
		BDOdao dao = new BDOdaoImpl();
		
		try {
			
			List<Employee> listofemp = dao.listOfEmployeeOnProject(pid);
			
			System.out.println("List of Employee working on that Project and their wages:");
			System.out.println("=============================================");
			System.out.println("=============================================");
			for(Employee emp: listofemp) {
				System.out.println("Employee Id: "+emp.getEid());
				System.out.println("Employee Name: "+emp.getEid());
				System.out.println("Employee Address: "+emp.getEaddress());
				System.out.println("Employee Joining Date: "+emp.getEjoiningdate());
				System.out.println("Employee Wage/Day: "+emp.getEwage());
			}
			
			System.out.println("=========================================");
			
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		} catch (BDOexception e) {
			System.out.println(e.getMessage());
		}
	}

}
