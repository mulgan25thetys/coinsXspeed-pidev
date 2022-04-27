package horizure.micro.finance.services;


public interface EmailService {

	public void sendSimpleMessage(String username,String to,String subject,String message,String redirection); 
	
}
