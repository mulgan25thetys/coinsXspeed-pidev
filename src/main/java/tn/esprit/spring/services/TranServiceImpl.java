package tn.esprit.spring.services;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.models.Tran;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.TranRepository;
@Service
public class TranServiceImpl implements ITranService {

	
	@Autowired
	TranRepository transactionRepository;
	@Autowired
	ClientRepository cs;
	
	@Override
	public Tran addTransaction(Tran t, Long id_client) {
		t.setClient(cs.findById(id_client).orElse(null));
		return transactionRepository.save(t);
	}



	@Override
	public Tran ModifierTransaction(Tran t , Long id_client) {
		t.setClient(cs.findById(id_client).orElse(null));
		return transactionRepository.save(t);
	}

}
