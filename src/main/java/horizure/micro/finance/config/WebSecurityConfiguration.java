package horizure.micro.finance.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	@Override
    public void configure(HttpSecurity http) throws Exception {
       http.csrf().disable().authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST,"/account/add-account/*").permitAll()
        .antMatchers(HttpMethod.GET,"/account/list-accounts/*").permitAll()
        .antMatchers(HttpMethod.GET,"/account/get-account/*").permitAll()
        .antMatchers(HttpMethod.POST,"/scoreform/add-score-form").permitAll()
        .antMatchers(HttpMethod.PUT,"/scoreform/answer-form/*").permitAll()
        .antMatchers(HttpMethod.GET,"/scoreform/list-form").permitAll()
        .anyRequest().authenticated(); 
    }
	
}
