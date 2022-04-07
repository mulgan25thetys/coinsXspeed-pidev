package horizure.micro.finance.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.Egroup;

import horizure.micro.finance.entities.StLevel;
import horizure.micro.finance.entities.Status;

import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.UserRepository;



@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	
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

	public User saveUser(User newUser) {
		List<User> users = userRepository.checkIfUserExist(newUser.getUserName(), newUser.getEmail());
		User user =null;
		if(users.size() == 0) {
			if(newUser.getPassword() != null) {
				newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
			}
			newUser.setStatus(Status.PASCONFIRME);
			newUser.setEgroup(Egroup.GOOD);
			if(newUser.getLevel() == null) {
				newUser.setLevel(StLevel.none);
			}
			newUser.setCreated_at(new Date());
			newUser.setUpdated_at(new Date());
			user = userRepository.save(newUser);
		}	
		return user;

	}
	@Override
	public float getSumAmountByEGroup(Egroup egroup) {
		return userRepository.getSumAmountByEGroup(egroup);
	}

	@Transactional
	public User deleteUser(Long userId) {
		
		Optional<User> retrievedUser=userRepository.findById(userId);
		if(retrievedUser==null)
			try {
				throw new Exception("User not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		accountRepository.deleteById(retrievedUser.get().getAccount().getId_account());
		userRepository.deleteById(userId);
		return retrievedUser.get();
		
	}
	@Override
	public List<User>findAllUsers() {
		
		return userRepository.findAll();
	
}
	@Transactional
	public User addUserWithAccount(User user) {
		// TODO Auto-generated method stub
		User useracc = this.addUser(user);
		if(useracc.getUserId() != null) {
			accountServiceImpl.addAccount(user.getAccount(), user.getUserId());
		}
		return useracc;
	}

}