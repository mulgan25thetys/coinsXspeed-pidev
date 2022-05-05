package horizure.micro.finance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import horizure.micro.finance.entities.Payement;

public interface PayementRepository extends CrudRepository<Payement, Long> {

	@Query(value = "SELECT * FROM payement p INNER JOIN account a  ON p.account_id_account = a.id_account WHERE a.id_account =:idacc",nativeQuery = true)
	List<Payement> getPaymentForAccount(@Param("idacc") Long idacc);
	
	@Query(value = "SELECT * FROM payement p INNER JOIN financial_service fs  ON p.financial_service_id_service_financial  = fs.id_service_financial WHERE fs.id_service_financial =:idfs",nativeQuery = true)
	List<Payement> getPaymentForFinancialService(@Param("idfs") Long idfs);
	
	@Query(value = "SELECT * FROM payement p INNER JOIN financial_service fs  ON p.financial_service_id_service_financial  = fs.id_service_financial WHERE fs.id_service_financial =:idfs AND p.account_id_account=:idacc",nativeQuery = true)
	List<Payement> getPaymentForFinancialServiceAccount(@Param("idfs") Long idfs,@Param("idacc") Long idacc);
}
