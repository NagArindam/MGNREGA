package masai.project.usecase;

import java.util.List;

import masai.project.dao.GPMdao;
import masai.project.dao.GPMdaoImpl;
import masai.project.exception.EmployeeException;
import masai.project.models.Employee;

public class ViewDetailsOfEmployee {
	
	public static void viewdetailsemp() {
		
		GPMdao dao = new GPMdaoImpl();
		
		try {
			List<Employee> emplist = dao.viewdetailsOfEmployee();
			
			System.out.println("List Of All Employee");
			System.out.println("=========================");
			System.out.println("=========================");
			System.out.println();
			for(Employee emp: emplist) {
				System.out.println("Employee Id: "+emp.getEid());
				System.out.println("Employee Name: "+emp.getEname());
				System.out.println("Employee GPMEID: "+emp.getGPMeid());
				System.out.println("Employee peid: "+emp.getPeid());
				System.out.println("Employee Address: "+emp.getEaddress());
				System.out.println("Employee Joining Date: "+emp.getEjoiningdate());
				System.out.println("Employee Ewage/Day: "+emp.getEwage());
			}
			System.out.println("============================");
			System.out.println();
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}

}
