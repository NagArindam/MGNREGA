package masai.project.mainuser;

import masai.project.usecase.AllocateProjectToGPMUsecase;
import masai.project.usecase.BDOLoginUsecase;
import masai.project.usecase.CreateNewGPMUsecase;
import masai.project.usecase.CreateProjectUsecase;
import masai.project.usecase.EmployeeWorkingOnProjectUsecase;
import masai.project.usecase.ViewAllGPMUsecase;
import masai.project.usecase.ViewListOfProjectsUsecase;

public class BDOMain {
	
	public static boolean bdologinwindow() {
		BDOLoginUsecase login = new BDOLoginUsecase();
		boolean res = login.BDOLogin();
		return res;
	}
	
	public static void bdoHomePage() {
		
		System.out.println("Welcome To BDO Home Page");
		System.out.println("=========================");
		System.out.println("Create A Project => Press 1.");
		System.out.println("View List Of All Projects => Press 2.");
		System.out.println("Create A new Gram Panchayat Member(GPM) => Press 3.");
		System.out.println("View List Of All Gram Panchayat Members(GPM) => Press 4.");
		System.out.println("Allocate Project To Gram Panchayat Member(GPM) => Press 5.");
		System.out.println("See List Of Employee Working on that Project And their Wages => Press 6.");
		System.out.println("Logout => Press 7.");
	}
	
	public static void CreateProject() {
		CreateProjectUsecase CreateProject = new CreateProjectUsecase();
		CreateProject.createProject();
	}
	
	public static void ViewListOfProject() {
		ViewListOfProjectsUsecase allprojects = new ViewListOfProjectsUsecase();
		allprojects.viewlistofprojects();
	}
	
	public static void createNewGPM() {
		CreateNewGPMUsecase newGPM = new CreateNewGPMUsecase();
		newGPM.createNewGpm();
	}
	
	public static void ViewListOfALLGPM() {
		ViewAllGPMUsecase allGPM = new ViewAllGPMUsecase();
		allGPM.viewallGpm();
	}
	
	public static void allocateProjectToGPM() {
		AllocateProjectToGPMUsecase allcProjGPM = new AllocateProjectToGPMUsecase();
		allcProjGPM.allocateprojecttogpm();
	}
	
	public static void seeListOfEmpWorkingAndWages() {
		EmployeeWorkingOnProjectUsecase empWages = new EmployeeWorkingOnProjectUsecase();
		empWages.employeeWorkingOnProject();
	}
	

}
