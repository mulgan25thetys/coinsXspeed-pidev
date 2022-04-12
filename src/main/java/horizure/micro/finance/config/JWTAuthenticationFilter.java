package horizure.micro.finance.config;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	/*public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,HttpServletResponse res) throws AuthenticationException {
	    try {
	        ApplicationUser creds = null;

	        if (req.getParameter("username") != null  && req.getParameter("password") != null) {
	            creds = new ApplicationUser();              
	            creds.setUsername(req.getParameter("username"));
	            creds.setPassword(req.getParameter("password"));                
	        } else {
	            creds = new ObjectMapper()
	                    .readValue(req.getInputStream(), ApplicationUser.class);
	        }

	        return getAuthenticationManager().authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        creds.getUsername(),
	                        creds.getPassword(),
	                        new ArrayList<>())
	        );
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	}*/
}
