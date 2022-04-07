package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.FinancialService;

public interface IFinancialServiceService {

	
	List<FinancialService> retrieveAllFinancialService();
	
	FinancialService retrieveFinancialService (Long id);
	
	FinancialService updateFinancialService (FinancialService FS);
	
	FinancialService addFinancialService (FinancialService FS);
	
	FinancialService addFinancialServiceLoan (FinancialService FS, long idUser);
	
	FinancialService addFinancialServiceToUserAccount(Long idUser,FinancialService FS);
	
	boolean getIsAccepted(long id_ServiceFinancial,Long idUser) ;
	
	double getCeilings(FinancialService FS, long id_user); 
}
