package horizure.micro.finance.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Payement;
	private long Client_CIN ;
	private long sevice_id ;
	private double remaining_amount ;
	private double interest ;
	private double amortization ;
	private double mensuality ;
	private double paid_amount ;
	@Temporal(TemporalType.DATE)
	private Date dateLimit ;
	@Temporal(TemporalType.DATE)
	private Date perform_on ;
	public long getClient_CIN() {
		return Client_CIN;
	}
	public void setClient_CIN(long client_CIN) {
		Client_CIN = client_CIN;
	}
	public long getSevice_id() {
		return sevice_id;
	}
	public void setSevice_id(long sevice_id) {
		this.sevice_id = sevice_id;
	}
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
	public double getAmortization() {
		return amortization;
	}
	public void setAmortization(double amortization) {
		this.amortization = amortization;
	}
	public double getMensuality() {
		return mensuality;
	}
	public void setMensuality(double mensuality) {
		this.mensuality = mensuality;
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
	
	@OneToMany(mappedBy = "payement")
	private Set<FinancialService> financialService ;

}
