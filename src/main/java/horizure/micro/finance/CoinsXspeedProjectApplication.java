package horizure.micro.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
<<<<<<< HEAD

@SpringBootApplication
@EnableScheduling
=======
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableScheduling
@EnableWebSecurity
>>>>>>> 11208f435557d50baba2046c3444ed42ade26693
public class CoinsXspeedProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinsXspeedProjectApplication.class, args);
	}

}
