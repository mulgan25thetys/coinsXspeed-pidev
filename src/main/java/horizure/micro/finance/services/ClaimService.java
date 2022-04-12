package horizure.micro.finance.services;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.Claim;
import horizure.micro.finance.entities.Topic;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.ClaimRepository;
import horizure.micro.finance.repositories.UserRepository;

@Service
public class ClaimService implements IClaimService {
	
	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Claim add_Claim(Claim c) {
		c.setCreated_at(new Date());
		return claimRepository.save(c);
	}

	@Override
	public Optional<Claim> retrieveClaim(Long id) {

		return claimRepository.findById(id);
	}

	@Override
	public void Delete_Claim(Long Id_Claim) {
		claimRepository.deleteById(Id_Claim);
		
	}

	@Override
	public List<Claim> FilterByTopic(Topic topic) {
		List<Claim> ClaimBytopic = claimRepository.findAll()
                .stream().filter(c->c.getTopic().equals(topic))
                .collect(Collectors.toList());
        return ClaimBytopic;
	}

	@Override
	public Topic most_topic_complained() {
		AtomicInteger nbsecurity= new AtomicInteger();
        AtomicInteger nbservice= new AtomicInteger();
        AtomicInteger nbquality= new AtomicInteger();
        claimRepository.findAll().forEach(c->{
            if(c.getTopic().equals(Topic.Service))
                nbservice.addAndGet(1);
            else if (c.getTopic().equals(Topic.Quality))
                nbquality.addAndGet(1);
            else 
                nbsecurity.addAndGet(1);
        });
        if((nbquality.intValue()>nbsecurity.intValue()) && (nbquality.intValue()>nbservice.intValue()))
            return Topic.Quality;

        else if((nbservice.intValue()>nbsecurity.intValue()) && (nbservice.intValue()>nbquality.intValue()))
            return Topic.Service;
        else
        {
      
            return Topic.Security;}
	}

	@Scheduled(cron = "@Weekly")
	public Map<Long, Long> triByUser() {
		Map<Long, Long> m  = new HashMap<Long,Long>();
        userRepository.findAll().forEach(u-> {
            m.put(u.getUserId(),nbr_Claim_recieved_each_week(u.getUserId()));
        });
     return m.entrySet()
              .stream()
              .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
              .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1, e2) -> e1,
                      LinkedHashMap::new
              ));
	}

	@Override
	public Long nbr_Claim_recieved_each_week(Long id_user) {
		User u = userRepository.findById(id_user).get();

        return  u.getClaim().stream().filter(e->e.getCreated_at().before(new Date())).filter(e->e.getCreated_at().
                after(addDays(new Date(), -7))).count();

       /* if (claimRepository.existsClaimByUser(u) )

        return  u.getClaim().stream().filter(e->e.getCreated_at().before(new Date())).filter(e->e.getCreated_at().
                after(addDays(new Date(), -7))).count();
        else
            return  Long.valueOf(0);*/

    }
	
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
	}

	@Override
	public int Taux_Claim_each_month() {
		List<User> u = (List<User>) userRepository.findAll();
        AtomicInteger somme= new AtomicInteger();

         u.forEach(us->{
             Calendar cal = Calendar.getInstance();
             cal.setTime(new Date());
             int monthnow = cal.get(Calendar.MONTH);
             if (claimRepository.existsClaimByUser(us) ){

             us.getClaim().forEach(c-> {
                 Calendar call = Calendar.getInstance();
             cal.setTime(c.getCreated_at());
             int month = cal.get(Calendar.MONTH);
             if(month==monthnow)
             somme.addAndGet(1);
             });}
         });
         System.out.println("Rate of complaints this month : "+somme.intValue()*100/(claimRepository.findAll().size())+"%");
         return (somme.intValue()*100/claimRepository.findAll().size());
	}
	
	
}
