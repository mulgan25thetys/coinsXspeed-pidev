package horizure.micro.finance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

}
