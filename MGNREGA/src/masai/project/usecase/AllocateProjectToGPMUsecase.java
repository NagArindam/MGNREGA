package masai.project.usecase;

import java.util.Scanner;

import masai.project.dao.BDOdao;
import masai.project.dao.BDOdaoImpl;
import masai.project.exception.BDOexception;
import masai.project.exception.GPMexception;
import masai.project.exception.ProjectException;

public class AllocateProjectToGPMUsecase {
	
	public static void allocateprojecttogpm() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("To allocate Project, Enter Project ID:");
		int pid = sc.nextInt();
		
		System.out.println("TO allocate Project, Enter Gram PanchayatMember(GPM) Id: ");
		int GPMID = sc.nextInt();
		
		BDOdao dao = new BDOdaoImpl();
		String res;
		
		try {
			res = dao.allocateProjectToGPM(pid, GPMID);
			System.out.println(res);
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		} catch (GPMexception e) {
			System.out.println(e.getMessage());
		} catch (BDOexception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
