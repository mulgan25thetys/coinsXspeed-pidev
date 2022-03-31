package horizure.micro.finance.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.AccountRepository;
import horizure.micro.finance.repositories.UserRepository;

@Service
 public class UserServiceImpl implements IUserService {
	
	@Autowired
	 UserRepository userRepository;
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public User addUser(User u) {
		userRepository.save(u);
		   return u ;
	}
	
	@Override
	public User updateUser(User u) {
		userRepository.save(u);
		  return u;
	}

	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) userRepository.findAll();

	}
	@Override
	public User retrieveUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}


@Override
public void removeUser(Long userId) {
	userRepository.deleteById(userId);
	
}



	
}