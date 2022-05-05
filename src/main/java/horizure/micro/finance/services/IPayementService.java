package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;

import horizure.micro.finance.entities.FinancialService;
import horizure.micro.finance.entities.Payement;

public interface IPayementService  {
	
	
    List<Payement> retrieveAllPayement();
	
    Payement retrievePayement (Long id);
	
    Payement updatePayement (Payement P);
	
	public double getMensuality(double amount,float interest_fs,long duration);
	
	public List<Payement> getPayement_mensuality(double amount,float interest_fs,long duration,Date date_fs);
	
	//public List<Payement> addPayement(long id_ServiceFinancial);
	
	public List<Payement> getPayement_Block(double amount,float interest_fs,long duration,Date date_fs);

	List<Payement> retrievePayementFinancialService(Long id_fs);

	List<Payement> retrievePayementAccount(Long id_account); 
	
	List<Payement> retrievePayementFinancialServiceAccount(Long id_fs,Long id_acc);

	List<Payement> proceedToPayment(Long id_fs,Long id_acc,Payement payment);

}
