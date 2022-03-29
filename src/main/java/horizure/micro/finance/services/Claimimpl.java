package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import horizure.micro.finance.entities.Claim;
import horizure.micro.finance.entities.TypeClaim;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.ClaimRepositry;

public class Claimimpl implements ClaimService {
	@Autowired
	ClaimRepositry claimrepositry;
	

	@Override
	public List<Claim> retrieveAllClaims() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Claim> retrieveClaims(String recId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claim updateClaim(Claim r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteClaimById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Claim getClaimByUser(Long id,Long id_Claim) {
	   Claim c=	 claimrepositry.findById(id_Claim).get();
	   c. getFinancialService().getAccounts().forEach(acc->{User u=acc.getUser();});
	   
	   
		
		
		return null;
	}

	@Override
	public List<Claim> getClaimByCategory(TypeClaim typeclaim) {
		List<Claim> claims= claimrepositry.getClaimByCategory(typeclaim);
		return claims;
	}

	@Override
	public int isCategoryExists(TypeClaim typeclaim) {
		// TODO Auto-generated method stub
		return 0;
	}

}
