package masai.project.mainuser;

import masai.project.usecase.AssignEmployeeToProjectUsecase;
import masai.project.usecase.CreateEmployeeUsecase;
import masai.project.usecase.GPMLoginUsecase;
import masai.project.usecase.ViewDetailsOfEmployee;
import masai.project.usecase.ViewTotalDaysWorkedAndWagesOfEmployeeUsecase;

public class GPMMain {
	
	public static boolean GPMLogin() {
		GPMLoginUsecase log = new GPMLoginUsecase();
		boolean res = log.GPMlogin();
		return res;
	}
	
	public static void GPMHomePage() {	
		System.out.println("Welcome To Gram Panchayat Member(GPM) Home Page");
		System.out.println("================================================");
		System.out.println("Create Employee => Press 1.");
		System.out.println("View List Of All Employee with Details => Press 2.");
		System.out.println("Assign Employee to a Project => Press 3.");
		System.out.println("View total number of days Employee worked in a project and also their wages => Press 4.");
		System.out.println("Logout => Press 5.");
	}
	
	public static void createEmp() {
		CreateEmployeeUsecase createemployee = new CreateEmployeeUsecase();
		createemployee.createemp();
	}
	
	public static void viewEmp() {
		ViewDetailsOfEmployee viewempdetails = new ViewDetailsOfEmployee();
		viewempdetails.viewdetailsemp();
	}
	
	public static void assignemp() {
		AssignEmployeeToProjectUsecase assigne = new AssignEmployeeToProjectUsecase();
		assigne.assignEmpToProject();
	}
	
	public static void viewtotaldayswages() {
		ViewTotalDaysWorkedAndWagesOfEmployeeUsecase dayswages = new ViewTotalDaysWorkedAndWagesOfEmployeeUsecase();
		dayswages.totaldaysandwagesofemp();
	}

}
