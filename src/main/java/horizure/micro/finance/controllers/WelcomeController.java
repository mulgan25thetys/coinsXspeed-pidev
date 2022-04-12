package horizure.micro.finance.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
    public String index() {
        return "Spring Boot POC Welcomes You!";
    }

}
