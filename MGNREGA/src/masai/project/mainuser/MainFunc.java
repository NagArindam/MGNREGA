package masai.project.mainuser;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainFunc {
	
	public static void openTheApplication() throws InputMismatchException{
		
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Welcome To MGNREGA App");
			System.out.println();
			System.out.println("Please Select One Option From Below.");
			System.out.println();
			System.out.println("For BDO Login => Press 1.");
			System.out.println("For Gram Panchayat Login(GPM) => Press 2.");
			System.out.println("For Exit => Press 3.");
			String msg = sc.next();
			
			if(msg.equals("1")) {
				
				BDOMain bdomain = new BDOMain();
				Boolean res = bdomain.bdologinwindow();
				int BDOLoginAttempt = 1;
				
				while(!res) {
					BDOLoginAttempt++;
					System.out.println("Attempt Remailnig: "+(5-BDOLoginAttempt));
					res = bdomain.bdologinwindow();
					
					if(BDOLoginAttempt==5 && res == false) {
						System.out.println("You Have Crossed Your Maximum Attempt! Please Try Again After Some Time.");
						break;
					}
				}
				
				if(res) {
					
					while(true) {
						bdomain.bdoHomePage();
						String BDOChoice = sc.next();
						
						if(BDOChoice.equals("1")) {
							bdomain.CreateProject();
						}
						else if(BDOChoice.equals("2")) {
							bdomain.ViewListOfProject();
						}
						else if(BDOChoice.equals("3")) {
							bdomain.createNewGPM();
						}
						else if(BDOChoice.equals("4")) {
							bdomain.ViewListOfALLGPM();
						}
						else if(BDOChoice.equals("5")) {
							bdomain.allocateProjectToGPM();
						}
						else if(BDOChoice.equals("6")) {
							bdomain.seeListOfEmpWorkingAndWages();
						}
						else if(BDOChoice.equals("7")) {
							System.out.println("Logout Successfull. Thank You!");
							break;
						}
						else {
							System.out.println("Please Choose 1 to 7");
						}
					}
					openTheApplication();
				}
				else {
					openTheApplication();
				}
			}
			else if(msg.equals("2")) {
				
				GPMMain gpmmain = new GPMMain();
				boolean res = gpmmain.GPMLogin();
				
				int GPMLoginAttempt = 1;
				
				while(!res) {
					GPMLoginAttempt++;
					System.out.println("Attempt Remailnig: "+(3-GPMLoginAttempt));
					res = gpmmain.GPMLogin();
					
					if(GPMLoginAttempt==3 && res == false) {
						System.out.println("You Have Crossed Your Maximum Attempt! Please Try Again After Some Time.");
						break;
					}
				}
				if(res) {
					while(true) {
						gpmmain.GPMHomePage();
						String GPMChoice = sc.next();
						
						if(GPMChoice.equals("1")) {
							gpmmain.createEmp();
						}
						else if(GPMChoice.equals("2")) {
							gpmmain.viewEmp();
						}
						else if(GPMChoice.equals("3")) {
							gpmmain.assignemp();
						}
						else if(GPMChoice.equals("4")) {
							gpmmain.viewtotaldayswages();
						}
						else if(GPMChoice.equals("5")) {
							System.out.println("Logout Successfull. Thank You!");
							break;
						}
						else {
							System.out.println("Please Choose 1 to 5");
						}
					}
					openTheApplication();
				}
				else {
					openTheApplication();
				}
			}
			else if(msg.equals("3")) {
				System.out.println("Successfully Exit!");
				System.exit(0);
			}
			else {
				System.out.println("Please Choose 1 to 3");
				openTheApplication();
			}
			
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		openTheApplication();
	}

}
