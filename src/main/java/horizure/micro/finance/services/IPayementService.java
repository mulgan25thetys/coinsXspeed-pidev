package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.FinancialService;
import horizure.micro.finance.entities.Payement;

public interface IPayementService  {
	
	
    List<Payement> retrieveAllPayement();
	
    Payement retrievePayement (Long id);
	
    Payement updatePayement (Payement P);
	
	public double getMensuality(FinancialService FS);
	
	public List<Payement> getPayement_mensuality(Long id_ServiceFinancial);
	
	public List<Payement> getPayement_Block(Long id_ServiceFinancial);
	
	public List<Payement> addPayement(long id_ServiceFinancial);


}
