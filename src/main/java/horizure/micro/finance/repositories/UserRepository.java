package horizure.micro.finance.repositories;

import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

import horizure.micro.finance.entities.User;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {
}