package masai.project.usecase;

import java.util.InputMismatchException;
import java.util.Scanner;

import masai.project.dao.BDOdao;
import masai.project.dao.BDOdaoImpl;
import masai.project.exception.ProjectException;
import masai.project.models.Project;

public class CreateProjectUsecase {
	
	public static void createProject() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Enter Project Name: ");
			String pname = sc.next();
			
			System.out.println("Enter Project Cost: ");
			int pcost = sc.nextInt();
			
			System.out.println("Enter Project Timimg/Duration: ");
			int ptiming = sc.nextInt();
			
			Project project = new Project();
			project.setPname(pname);
			project.setPcost(pcost);
			project.setPtiming(ptiming);
			
			BDOdao dao = new BDOdaoImpl();
			String res;
			
			try {
				res = dao.createAProject(project);
			} catch (ProjectException e) {
				res = e.getMessage();
			}
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input Data!");
		}
		
	}
	
	

}
