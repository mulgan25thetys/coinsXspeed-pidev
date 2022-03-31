package horizure.micro.finance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Claim;
import horizure.micro.finance.entities.TypeClaim;

@Repository
public interface ClaimRepositry extends JpaRepository<Claim, Long> {
	@Query ("select c from Claim c where c. type=:typeClaim")
	public List<Claim> getClaimByCategory(@Param("typeClaim") TypeClaim typeclaim);
	@Query("select  count(c) from Claim c where c. type=:typeClaim ")
	public int isCategoryExists( @Param("typeClaim")TypeClaim typeclaim);
	

}
