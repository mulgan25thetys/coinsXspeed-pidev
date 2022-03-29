package horizure.micro.finance.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;


import horizure.micro.finance.entities.Communication;
import horizure.micro.finance.entities.Message;
import horizure.micro.finance.repositories.CommunicationRepositry;

public class GestionCommunicationimpl implements ICommunicationSerice {
	@Autowired
	CommunicationRepositry communicationRepositry;

	@Override
	public Communication findById(Long id) {
		
		return communicationRepositry.findById(id).orElse(null);
				
	}

	@Override
	public List<Communication> retrieveAllCommunication() {
		List<Communication> communications=( List<Communication>)communicationRepositry.findAll();
		
		return communications;
	}

	@Override
	public void deleteCommunication(String id) {
		communicationRepositry.deleteById(Long.parseLong(id));
		
		
	}

	@Override
	public Optional<Communication> retrieveCommunication(String id) {
		Optional<Communication> optional=(Optional<Communication>)communicationRepositry.findById(Long.parseLong(id));
		return  optional;
	}

	@Override
	public void store(Long userId, Message text) throws IOException {
		// TODO Auto-generated method stub
		
	}

	
}
