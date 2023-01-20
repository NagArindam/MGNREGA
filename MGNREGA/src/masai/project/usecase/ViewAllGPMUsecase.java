package masai.project.usecase;

import java.util.List;

import masai.project.dao.BDOdao;
import masai.project.dao.BDOdaoImpl;
import masai.project.exception.GPMexception;
import masai.project.models.GPM;

public class ViewAllGPMUsecase {

	public static void viewallGpm() {
		
		BDOdao dao = new BDOdaoImpl();
		
		try {
			
			List<GPM> GPMList = dao.viewAllGPM();
			
			System.out.println("List of Gram Panchayat Members(GPM): ");
			System.out.println("===================================");
			System.out.println("===================================");
			System.out.println();
			for(GPM gpm: GPMList) {
				System.out.println("Gram Panchayat Id(GPMID): "+gpm.getGPMID());
				System.out.println("Gram Panchayat Name(GPMname): "+gpm.getGPMname());
				System.out.println("Gram Panchayat Address(GPMaddress): "+gpm.getGPMaddress());
				System.out.println("Gram Panchayat Phone no(GPmphoneno): "+gpm.getGPMphoneno());
				System.out.println("Gram Panchayat Password(GPMpassword): "+gpm.getGPMpassword());
				System.out.println();
			}
			System.out.println("=====================================");
			
		} catch (GPMexception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
