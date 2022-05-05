package horizure.micro.finance.config;



import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpMethod;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

import horizure.micro.finance.services.AuthenticationService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private AuthenticationService authenticationService;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	    
	    mailSender.setUsername("coinsxspeed.micro.finance@gmail.com");
	    mailSender.setPassword("coinsxspeed$mf22");
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}
	
	@Bean
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(htmlTemplateResolver());
        return templateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver htmlTemplateResolver(){
        SpringResourceTemplateResolver emailTemplateResolver = new SpringResourceTemplateResolver();
        emailTemplateResolver.setPrefix("classpath:/templates/");
        emailTemplateResolver.setSuffix(".html");
        emailTemplateResolver.setTemplateMode(TemplateMode.HTML5.name());
        emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        return emailTemplateResolver;
    }
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
		
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/comment/list-comments").permitAll()
        .antMatchers(HttpMethod.POST,"/comment/add-comment").permitAll()
        .antMatchers(HttpMethod.DELETE,"/comment/delete-comment/*").permitAll()
        .antMatchers(HttpMethod.GET,"/comment/get-nbcommentsbyreplyid/*").permitAll()
        .antMatchers(HttpMethod.GET,"/user/get-sumamountbyegroup/*").permitAll()  
        .antMatchers(HttpMethod.GET,"/user/list-users").permitAll()
        .antMatchers(HttpMethod.POST,"/user/add-users").permitAll()
        .antMatchers(HttpMethod.POST,"/user/register-customer").permitAll()
        .antMatchers(HttpMethod.PUT,"/user/edit-user/*").permitAll()
        .antMatchers(HttpMethod.DELETE,"/user/delete-user/*").permitAll()
        .and()
        .authorizeRequests().antMatchers(HttpMethod.PUT,"/comment/edit-comment/*").hasAnyRole("ADMIN", "AGENT")// pour continuer à avoir accès à la console de la bdd
        ;
	       
		   http.csrf().disable().cors().disable();
		   http.headers().frameOptions().disable();
		
	
		   http.csrf().disable().cors().disable().authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/send-email").permitAll()
	        .antMatchers(HttpMethod.POST,"/account/add-account/*").permitAll()
	        .antMatchers(HttpMethod.PUT,"/account/edit-account/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/list-accounts").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/sort-accounts/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/search-accounts/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/get-account/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/get-user-account/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/get-user-by-account/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/get-account-by-user/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/get-statistic").permitAll()
	        .antMatchers(HttpMethod.PUT,"/account/change-account-status/*/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/get-statistic-by-date/*/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/get-statistic").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/export/excel").permitAll()
	        .antMatchers(HttpMethod.GET,"/account/get-all-clients").permitAll()
	        .antMatchers(HttpMethod.POST,"/scoreform/add-score-form").permitAll()
	        .antMatchers(HttpMethod.PUT,"/scoreform/answer-form/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/scoreform/get-responses-form").permitAll()
	        .antMatchers(HttpMethod.GET,"/scoreform/list-form").permitAll()
	        .antMatchers(HttpMethod.GET,"/scoreform/get-form/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/scoreform/sort-form/").permitAll()
	        .antMatchers(HttpMethod.GET,"/scoreform/search-form/*").permitAll()
	        .antMatchers(HttpMethod.DELETE,"/scoreform/delete-form/*").permitAll()
	        .antMatchers(HttpMethod.DELETE,"/scoreform/delete-response/*").permitAll()
	        .antMatchers(HttpMethod.PUT,"/scoreform/edit-form/").permitAll()
	        .antMatchers(HttpMethod.GET,"/scoreform/get-statistic").permitAll()
	        .antMatchers(HttpMethod.GET,"/financial-service/list-financial-service").permitAll()
	        .antMatchers(HttpMethod.POST,"/financial-service/add-financial-service").permitAll()
	        .antMatchers(HttpMethod.PUT,"/financial-service/add-financial-service-loan/*/*").permitAll()
	        .antMatchers(HttpMethod.POST,"/financial-service/add-financial-service-to-User/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/financial-service/get-financial-service/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/financial-service/list-financial-service-account/*").permitAll()
	        .antMatchers(HttpMethod.POST,"/transaction/add-transaction").permitAll()
	        .antMatchers(HttpMethod.GET,"/transaction/list-transactions").permitAll()
	        .antMatchers(HttpMethod.POST,"/payement/add-payement/*").permitAll()//
	        .antMatchers(HttpMethod.GET,"/payement/get-payement-mensuality/*").permitAll()
	        .antMatchers(HttpMethod.POST,"/payement/add-transaction").permitAll()
	        .antMatchers(HttpMethod.GET,"/payement/get-payement-block/*").permitAll() 
	        .antMatchers(HttpMethod.GET,"/payement/get-payement-financial-service/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/payement/get-payement-financial-service-account/*/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/payement/get-payement-account/*").permitAll()///
	        .antMatchers(HttpMethod.GET,"/payement/list-payement").permitAll()
	        .antMatchers(HttpMethod.GET,"/claim/retrieve-all-reclamations").permitAll() ///
	        .antMatchers(HttpMethod.POST,"/claim/add-claim").permitAll()
	        .antMatchers(HttpMethod.GET,"/communication/retreive-communication/*").permitAll() ///
	        .antMatchers(HttpMethod.POST,"/communication/add-communication").permitAll()
	        .antMatchers(HttpMethod.POST,"/communication/communication-upload/*/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/communication/retreive-all-communication").permitAll()
	        .antMatchers(HttpMethod.DELETE,"/comment/delete-comment/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/transaction/get-account-transaction/*").permitAll()
	        .anyRequest().authenticated(); 
       
       
    }
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .eraseCredentials(true)
                .userDetailsService(authenticationService)
                .passwordEncoder(passwordEncoder());
    }
	
}
