package masai.project.usecase;

import java.util.Scanner;

import masai.project.dao.GPMdao;
import masai.project.dao.GPMdaoImpl;
import masai.project.exception.CredException;
import masai.project.exception.GPMexception;

public class GPMLoginUsecase {
	
	public static boolean GPMlogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Registered Phone No: ");
		String phn = sc.next();
		
		System.out.println("Enter Your Password: ");
		String pswrd = sc.next();
		
		GPMdao dao = new GPMdaoImpl();
		String res;
		
		try {
			res = dao.GPMLogin(phn, pswrd);
			System.out.println(res);
			return true;
			
		} catch (CredException e) {
			System.out.println(e.getMessage());
			return false;
		} catch(GPMexception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
