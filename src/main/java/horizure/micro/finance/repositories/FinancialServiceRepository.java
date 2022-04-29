package horizure.micro.finance.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.FinancialService;

@Repository
public interface FinancialServiceRepository extends CrudRepository<FinancialService, Long>{

 
	@Query(value = "SELECT * FROM financial_service fs INNER JOIN payement p ON p.financial_service_id_service_financial = fs.id_service_financial WHERE p.account_id_account =:idacc"
			+ " AND p.financial_service_id_service_financial = :idfs",nativeQuery = true)
	List<FinancialService> getFinancialServiceAccount(@Param("idacc") Long idacc, @Param("idfs") Long idfs);
	
	@Query(value = "SELECT DISTINCT(id_service_financial),category,amount,ceiling,date_of_creation,date_of_updating,duration,interest_pr,reimbment_method "
			+ "FROM financial_service fs INNER JOIN payement p ON p.financial_service_id_service_financial = fs.id_service_financial "
			+ "WHERE p.account_id_account =:idacc",nativeQuery = true)
	List<FinancialService> getFinancialServicesForAccount(@Param("idacc") Long idacc);
}
