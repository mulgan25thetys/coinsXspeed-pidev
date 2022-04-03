package horizure.micro.finance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{

}
