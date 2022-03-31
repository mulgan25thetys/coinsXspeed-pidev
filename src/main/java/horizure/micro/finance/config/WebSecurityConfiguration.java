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
        .antMatchers(HttpMethod.PUT,"/account/edit-account/*").permitAll()
        .antMatchers(HttpMethod.GET,"/account/list-accounts").permitAll()
        .antMatchers(HttpMethod.GET,"/account/sort-accounts/*").permitAll()
        .antMatchers(HttpMethod.GET,"/account/search-accounts/*").permitAll()
        .antMatchers(HttpMethod.GET,"/account/get-account/*").permitAll()
        .antMatchers(HttpMethod.GET,"/account/get-user-account/*").permitAll()
        .antMatchers(HttpMethod.PUT,"/account/change-account-status/*/*").permitAll()
        .antMatchers(HttpMethod.GET,"/account/get-statistic").permitAll()
        .antMatchers(HttpMethod.POST,"/scoreform/add-score-form").permitAll()
        .antMatchers(HttpMethod.PUT,"/scoreform/answer-form/*").permitAll()
        .antMatchers(HttpMethod.GET,"/scoreform/list-form").permitAll()
        .antMatchers(HttpMethod.GET,"/scoreform/get-form/*").permitAll()
        .antMatchers(HttpMethod.GET,"/scoreform/sort-form/").permitAll()
        .antMatchers(HttpMethod.GET,"/scoreform/search-form/*").permitAll()
        .antMatchers(HttpMethod.DELETE,"/scoreform/delete-form/*").permitAll()
        .antMatchers(HttpMethod.PUT,"/scoreform/edit-form/").permitAll()
        .antMatchers(HttpMethod.GET,"/financial-service/list-financial-service").permitAll()
        .antMatchers(HttpMethod.POST,"/financial-service/add-financial-service/*").permitAll()
        .antMatchers(HttpMethod.POST,"/transaction/add-transaction").permitAll()
        .antMatchers(HttpMethod.GET,"/transaction/list-transactions").permitAll()
        .antMatchers(HttpMethod.GET,"/user/list-users").permitAll()
        .antMatchers(HttpMethod.GET,"/user/retrieve-users").permitAll()
        .antMatchers(HttpMethod.POST,"/user/add-user").permitAll()
        .antMatchers(HttpMethod.PUT,"/user/modify-user").permitAll()
        .antMatchers(HttpMethod.DELETE,"/user/remove-user/*").permitAll()
        .anyRequest().authenticated(); 
    }
	
}
