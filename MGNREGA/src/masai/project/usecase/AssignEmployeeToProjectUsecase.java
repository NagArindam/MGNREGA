package masai.project.usecase;

import java.util.Scanner;

import masai.project.dao.GPMdao;
import masai.project.dao.GPMdaoImpl;
import masai.project.exception.EmployeeException;
import masai.project.exception.GPMexception;
import masai.project.exception.ProjectException;

public class AssignEmployeeToProjectUsecase {
	
	public static void assignEmpToProject() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project Id: ");
		int pid = sc.nextInt();
		
		System.out.println("Enter Employee Id: ");
		int eid = sc.nextInt();
		
		GPMdao dao = new GPMdaoImpl();
		String res;
		
		try {
			res = dao.assignEmployeeToAProject(eid, pid);
			System.out.println(res);
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		} catch (GPMexception e) {
			System.out.println(e.getMessage());
		}
	}

}
