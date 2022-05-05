package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Revenus;

@Repository
public interface RevenusRepository extends JpaRepository<Revenus, Long>{

	@Query(value =  "SELECT * FROM revenus ORDER BY updated_at DESC LIMIT 1", nativeQuery = true)
	Revenus getLastOne();
	
	@Query(value =  "SELECT amount FROM revenus ORDER BY updated_at DESC LIMIT 1", nativeQuery = true)
	Double getRevenus();
	
}
