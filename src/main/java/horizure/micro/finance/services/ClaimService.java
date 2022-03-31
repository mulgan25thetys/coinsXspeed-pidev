package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import horizure.micro.finance.entities.Claim;
import horizure.micro.finance.entities.TypeClaim;

public interface ClaimService {
List<Claim> retrieveAllClaims();
Optional<Claim> retrieveClaims(String recId);
Claim updateClaim(Claim r);
void deleteClaimById(String id);
public Claim getClaimByUser(Long id,Long id_claim);
public List<Claim>  getClaimByCategory(TypeClaim typeclaim);
public int  isCategoryExists(TypeClaim typeclaim);


}
