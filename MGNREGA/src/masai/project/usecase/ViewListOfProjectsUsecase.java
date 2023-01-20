package masai.project.usecase;

import java.util.List;

import masai.project.dao.BDOdao;
import masai.project.dao.BDOdaoImpl;
import masai.project.exception.ProjectException;
import masai.project.models.Project;

public class ViewListOfProjectsUsecase {
	
	public static void viewlistofprojects() {
		
		BDOdao dao = new BDOdaoImpl();
		
		try {
			
			List<Project> pro = dao.viewListOfProject();
			
			System.out.println("All the Projects: ");
			System.out.println("====================");
			System.out.println("====================");
			
			for(Project pr: pro) {
				System.out.println("Project Id(pid): "+pr.getPid());
				System.out.println("GPM pid(GPMpid): "+pr.getGPMpid());
				System.out.println("Project Name: "+pr.getPname());
				System.out.println("Project Cost: "+pr.getPcost());
				System.out.println("Project Timing/Duration: "+pr.getPtiming());
				System.out.println("======================");
			}
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	}

}
