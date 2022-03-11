package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.UserRepository;



@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;

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
		User user = userRepository.save(newUser);
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
	@Override
	public User deleteUser(Long userId) {
		
		Optional<User> retrievedUser=userRepository.findById(userId);
		if(retrievedUser==null)
			try {
				throw new Exception("User not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		userRepository.deleteById(userId);
		return retrievedUser.get();
		
	}
	@Override
	public List<User>findAllUsers() {
		
		return userRepository.findAll();
	
}
}