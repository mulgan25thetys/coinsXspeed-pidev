package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.Egroup;
import horizure.micro.finance.entities.Status;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.AccountRepository;
import horizure.micro.finance.repositories.UserRepository;



@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> retrieveUsers() {
		 return (List<User>) userRepository.findAll();
		
	}
	@Override
	public User addUser(User user) {
	   userRepository.save(user);
	   return user;
		
	}

	
 

	@Override
	public User findByUserName(String userName) {
		User user=userRepository.findByUserName(userName);
		return user;
	}
	
	@Override
	public Optional<User> findUserById(Long id) {
		
		return userRepository.findById(id);
	}
	
	@Override
	public User saveUser(User newUser) {
		List<User> users = userRepository.checkIfUserExist(newUser.getUserName(), newUser.getEmail());
		User user =null;
		if(users.size() == 0) {
			if(newUser.getPassword() != null) {
				newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
			}
			newUser.setStatus(Status.PASCONFIRME);
			newUser.setEgroup(Egroup.GOOD);
			newUser.setCreated_at(new Date());
			newUser.setUpdated_at(new Date());
			user = userRepository.save(newUser);
		}	
		return user;
	}
	@Override
	public User updateUser(Long id, User user) {
		
		Optional<User> retrievedUser=userRepository.findById(id);
		if(retrievedUser==null)
			try {
				throw new Exception("User not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		userRepository.save(user);
		return userRepository.findById(id).get();
		
		
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