package horizure.micro.finance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Privilege;


@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege,Long> {

}
