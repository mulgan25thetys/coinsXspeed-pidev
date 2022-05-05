package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.Revenus;

public interface IRevenusService {

	Revenus addRevenus(Revenus r);

	List<Revenus> getAll();
}
