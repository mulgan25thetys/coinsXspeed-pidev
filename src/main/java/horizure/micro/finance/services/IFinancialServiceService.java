package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.FinancialService;

public interface IFinancialServiceService {

	
	List<FinancialService> retrieveAllFinancialService();
	
	FinancialService retrieveFinancialService (Long id);
	
	FinancialService updateFinancialService (FinancialService FS);
	
	FinancialService addFinancialService (FinancialService FS);
	
	FinancialService addFinancialServiceLoan(long id_ServiceFinancial, long idUser) ;
	
	FinancialService addFinancialServiceToUserAccount(Long idUser,FinancialService FS);
	
	boolean getIsAccepted(long id_ServiceFinancial,Long idUser) ;
	
	double getCeilings(FinancialService FS, long id_user);

	List<FinancialService> retrieveAccountFinancialService(Long id_account);

	List<FinancialService> retrieveAllFinancialServiceAccount(Long id); 
}
