package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.FinancialService;

public interface IFinancialServiceService {

	List<FinancialService> listfinancialService();
	
	FinancialService addFinancialService(Long idUser,FinancialService fs);
}
