package masai.project.mainuser;

import masai.project.usecase.BDOLoginUsecase;

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
	
	

}
