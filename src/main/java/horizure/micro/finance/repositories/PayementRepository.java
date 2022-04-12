package horizure.micro.finance.repositories;

import org.springframework.data.repository.CrudRepository;

import horizure.micro.finance.entities.Payement;

public interface PayementRepository extends CrudRepository<Payement, Long> {

}
