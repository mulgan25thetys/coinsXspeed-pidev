package horizure.micro.finance.services;



import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("ENTER TO  .........................loadUserByUsername");
    	User u = userRepository.findOneByuserName(userName);
        System.out.println(u.toString());
        if(u == null){
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + userName);
        }

        org.springframework.security.core.userdetails.User user = createUser(u);

        return user;
    }

    private org.springframework.security.core.userdetails.User createUser(User u) {
        return new org.springframework.security.core.userdetails.User(u.getUserName(), u.getPassword(), createAuthorities(u));
    }

    private Collection<GrantedAuthority> createAuthorities(User u) {
    	System.out.println("ENTER TO  .........................createAuthorities");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+u.getRole()));
        return  authorities;
    }
}
