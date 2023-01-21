package masai.project.usecase;

import java.util.InputMismatchException;
import java.util.Scanner;

import masai.project.dao.GPMdao;
import masai.project.dao.GPMdaoImpl;
import masai.project.exception.EmployeeException;
import masai.project.models.Employee;

public class CreateEmployeeUsecase {
	
	public static void createemp() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Enter Employee Name: ");
			String ename = sc.next();
			
			System.out.println("Enter Employee Address: ");
			String eaddress = sc.next();
			
			System.out.println("Enter Employee Wages/Day: ");
			int ewage = sc.nextInt();
			
			Employee emp = new Employee();
			
			emp.setGPMeid(GPMdaoImpl.GPMIDstore);
			emp.setEname(ename);
			emp.setEaddress(eaddress);
			emp.setEwage(ewage);
			
			GPMdao dao = new GPMdaoImpl();
			String res;
			
			try {
				res = dao.createEmployee(emp);
				System.out.println(res);
				
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Invali Data!");
		}
	}

}
