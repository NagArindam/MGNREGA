package masai.project.usecase;

import java.util.InputMismatchException;
import java.util.Scanner;

import masai.project.dao.BDOdao;
import masai.project.dao.BDOdaoImpl;
import masai.project.exception.GPMexception;
import masai.project.models.GPM;

public class CreateNewGPMUsecase {
	
	public static boolean flag = false;
	
	public static void createNewGpm() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Enter Gram Panchayat Member(GPM) Name: ");
			String nm = sc.next();
			
			System.out.println("Enter Gram Panchayat Member(GPM) Address: ");
			String add = sc.next();
			
			System.out.println("Enter Gram Panchayat Member(GPM) Phone: ");
			String phn = sc.next();
			
			System.out.println("Enter Gram Panchayat Member(GPM) Password: ");
			String pswrd = sc.next();
			
			GPM gpm = new GPM();
			gpm.setGPMname(nm);
			gpm.setGPMaddress(add);
			gpm.setGPMphoneno(phn);
			gpm.setGPMpassword(pswrd);
			
			BDOdao dao = new BDOdaoImpl();
			String res;
			
			try {
				res = dao.createNewGPM(gpm);
				System.out.println(res);
			} catch (GPMexception e) {
				res = e.getMessage();
				System.out.println(res);
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input!");
		}
	}

}
