package horizure.micro.finance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
