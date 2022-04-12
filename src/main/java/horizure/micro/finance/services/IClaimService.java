package horizure.micro.finance.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import horizure.micro.finance.entities.Claim;
import horizure.micro.finance.entities.Topic;

public interface IClaimService {
	
	public Claim add_Claim(Claim c);
	
	public Optional<Claim> retrieveClaim(Long id);
	
	public void Delete_Claim(Long Id_Claim);
	
	public List<Claim> FilterByTopic(Topic topic);
	
	public Topic most_topic_complained();
	
	public Map<Long, Long> triByUser();
	
	public Long nbr_Claim_recieved_each_week(Long id_user);
	
	public int Taux_Claim_each_month();
}
