package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import horizure.micro.finance.entities.Egroup;

import horizure.micro.finance.entities.StLevel;
import horizure.micro.finance.entities.Status;

import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.AccountRepository;
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


   /* @PostConstruct
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
    }*/
	
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
		List<User> users = userRepository.checkIfUserExist(u.getUserName(), u.getEmail());
		User user =null;
		if(users.size() == 0) {
			if(u.getPassword() != null) {
				u.setPassword(passwordEncoder.encode(u.getPassword()));
			}
			if(u.getStatus() == null) {
				u.setStatus(Status.PASCONFIRME);
			}
			if(u.getEgroup() == null) {
				u.setEgroup(Egroup.WRONG);
			}
			
			if(u.getLevel() == null) {
				u.setLevel(StLevel.none);
			}
			u.setCreated_at(new Date());
			u.setUpdated_at(new Date());
			user = userRepository.save(u);
		}	
		return user;
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
	@Override
	public User updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}