package horizure.micro.finance.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.FinancialService;

@Repository
public interface FinancialServiceRepository extends CrudRepository<FinancialService, Long>{
 
}
