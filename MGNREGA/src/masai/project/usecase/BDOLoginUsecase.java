package masai.project.usecase;

import java.util.Scanner;

import masai.project.dao.BDOdao;
import masai.project.dao.BDOdaoImpl;
import masai.project.exception.CredException;

public class BDOLoginUsecase {
	
	public static boolean BDOLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter BDO Username: ");
		String username = sc.next();
		
		System.out.println("Enter BDO Password: ");
		String password = sc.next();
		
		BDOdao dao = new BDOdaoImpl();
		String res;
		
		try {
			res = dao.BDOLogin(username, password);
			return true;
			
		} catch (CredException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
			return false;
		}
	}

}
