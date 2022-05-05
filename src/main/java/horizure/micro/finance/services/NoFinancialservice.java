package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.NoFinancialService;

public interface NoFinancialservice {
	public List< NoFinancialService> getAll();
	public  NoFinancialService addNoFinancialService( NoFinancialService f);
	 public List< NoFinancialService> getByoFinancialServiceUser(Long userid);
	 public NoFinancialService updateNoFinancialService( NoFinancialService f);
	 

}
