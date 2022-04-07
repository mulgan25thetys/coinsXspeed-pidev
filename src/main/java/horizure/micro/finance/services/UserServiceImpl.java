package horizure.micro.finance.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.Egroup;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.UserRepository;



@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void initialize(){
        if(userRepository.findOneByuserName("admin") == null){
            save(new User(1L,"admin", "admin", "ADMIN"));
        }
        if(userRepository.findOneByuserName("agent") == null){
            save(new User(2L,"agent", "agent", "AGENT"));
        }
        if(userRepository.findOneByuserName("client") == null){
            save(new User(3L,"client", "client", "CLIENT"));
        }
    }
    @Transactional
    private User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
	@Override
	public List<User> retrieveUsers() {
		 return (List<User>) userRepository.findAll();
		
	}
	@Override
	public User addUser(User u) {
	   userRepository.save(u);
	   return u;
		
	}

	@Override
	public User updateUser(User u) {
	  userRepository.save(u);
	  return u;
	}
 
	@Override
	public void removeUser(Long userId) {
		userRepository.deleteById(userId);
		
	}
	@Override
	public User getUser(Long userId) {
		return userRepository.getById(userId);

	}
	@Override
	public float getSumAmountByEGroup(Egroup egroup) {
		return userRepository.getSumAmountByEGroup(egroup);
	}
}