package masai.project.mainuser;

import java.util.Scanner;

public class MainFunc {

//	public static void main(String[] args) {
//		
//		OpenTheApplication();
//	}
	
	public static void openTheApplication() {
		
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
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
