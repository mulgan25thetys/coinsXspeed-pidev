package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Claim;
import horizure.micro.finance.entities.User;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	public boolean existsClaimByUser(User user);
}
