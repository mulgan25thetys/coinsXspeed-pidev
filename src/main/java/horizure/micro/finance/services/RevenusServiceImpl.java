package horizure.micro.finance.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.Revenus;
import horizure.micro.finance.repositories.RevenusRepository;

@Service
public class RevenusServiceImpl implements IRevenusService{
	
	@Autowired
	RevenusRepository revenusRepository;

	@Override
	public Revenus addRevenus(Revenus r) {
		// TODO Auto-generated method stub
		r.setUpdated_at(new Date());
		revenusRepository.save(r);
		return null;
	}

	@Override
	public List<Revenus> getAll(){
		return (List<Revenus>)revenusRepository.findAll();
	}
}
