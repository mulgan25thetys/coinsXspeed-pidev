package tn.esprit.spring.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SmsService {

	    
	    private final String ACCOUNT_SID ="ACf1f64f6d4fda668119a788adf33b1252";

	    private final String AUTH_TOKEN = "fac6721a923dcda366fe40382aea6381";

	    private final String FROM_NUMBER = "+18109574765";

	    public void send(SmsPojo sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}
