package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
  
	 Account findByAccountName(String userName);
}
