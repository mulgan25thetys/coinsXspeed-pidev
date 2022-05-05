package horizure.micro.finance.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Claim;
import horizure.micro.finance.entities.NoFinancialService;
@Repository
public interface NoFinancialRepositry extends JpaRepository< NoFinancialService, Long> {
	@Query(value= ("SELECT *FROM NoFinancialService WHERE user_user_id =:userid "), nativeQuery = true)
	 public List< NoFinancialService> getoFinancialServiceByUser( @Param("userid") Long userid);
	

}