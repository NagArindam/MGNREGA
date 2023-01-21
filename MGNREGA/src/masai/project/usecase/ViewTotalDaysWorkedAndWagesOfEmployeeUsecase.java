package masai.project.usecase;

import java.util.List;

import masai.project.dao.GPMdao;
import masai.project.dao.GPMdaoImpl;
import masai.project.exception.EmployeeException;
import masai.project.models.EmployeeWageDTO;

public class ViewTotalDaysWorkedAndWagesOfEmployeeUsecase {
	
	public static void totaldaysandwagesofemp() {
		
		GPMdao dao = new GPMdaoImpl();
		
		try {
			List<EmployeeWageDTO> daysandwagesofemp = dao.daysAndWagesOfEmployee();
			
			System.out.println("List Of total number of days Employee worked in a project and also their wages");
			System.out.println("==================================");
			System.out.println("==================================");
			System.out.println();
			for(EmployeeWageDTO empdto: daysandwagesofemp) {
				
				System.out.println("Employee Id: "+empdto.getEid());
				System.out.println("Employee Name: "+empdto.getEname());
				System.out.println("Project Id: "+empdto.getPid());
				System.out.println("Project Name: "+empdto.getPname());
				System.out.println("Joining Date: "+empdto.getEjoiningdate());
				System.out.println("Total day worked: "+empdto.getDayswork());
				System.out.println("Wages/Day: "+empdto.getEwage());
				System.out.println("Total Amount: "+empdto.getAmount());
			}
			System.out.println("=================================");
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}

}
