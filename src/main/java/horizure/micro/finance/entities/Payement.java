package horizure.micro.finance.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Payement;
	private double remaining_amount ;
	private double interest ;
	private double amortization_amont ;
	private double aquired_amont ;
	private double paid_amount ;
	@Temporal(TemporalType.DATE)
	private Date dateLimit ;
	@Temporal(TemporalType.DATE)
	private Date perform_on ;
	
	@ManyToOne
	private FinancialService financialService;
	
	public double getRemaining_amount() {
		return remaining_amount;
	}
	public void setRemaining_amount(double remaining_amount) {
		this.remaining_amount = remaining_amount;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	public double getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(double paid_amount) {
		this.paid_amount = paid_amount;
	}
	public Date getDateLimit() {
		return dateLimit;
	}
	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}
	public Date getPerform_on() {
		return perform_on;
	}
	public void setPerform_on(Date perform_on) {
		this.perform_on = perform_on;
	}
	public double getAmortization_amont() {
		return amortization_amont;
	}
	public void setAmortization_amont(double amortization_amont) {
		this.amortization_amont = amortization_amont;
	}
	public double getAquired_amont() {
		return aquired_amont;
	}
	public void setAquired_amont(double aquired_amont) {
		this.aquired_amont = aquired_amont;
	}
	

	
}
