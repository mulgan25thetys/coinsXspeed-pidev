package horizure.micro.finance.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Payement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Payement;
	private double remaining_amount ;
	private double interest ;
	private double amortization ;
	private double mensuality ;
	private double paid_amount ;
	//@Temporal(TemporalType.DATE)
	private LocalDate dateLimit ;
	@Temporal(TemporalType.DATE)
	private Date creation_date ;
	@Temporal(TemporalType.DATE)
	private Date paid_at ;
	
	//@JsonIgnore
	@ManyToOne
	FinancialService financialService ;
	
	//@JsonIgnore
	@ManyToOne
	Account account ;

	public Payement() {
		// TODO Auto-generated constructor stub
	}
	
	 
	public Payement(long id_Payement, long client_id, long sevice_id, double remaining_amount, double interest,
			double amortization, double mensuality, double paid_amount, LocalDate dateLimit, Date creation_date,
			FinancialService financialService) {
		super();
		this.id_Payement = id_Payement;
		this.remaining_amount = remaining_amount;
		this.interest = interest;
		this.amortization = amortization;
		this.mensuality = mensuality;
		this.paid_amount = paid_amount;
		this.dateLimit = dateLimit;
		this.creation_date = creation_date;
		this.financialService = financialService;
	}


	public long getId_Payement() {
		return id_Payement;
	}


	public void setId_Payement(long id_Payement) {
		this.id_Payement = id_Payement;
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

	public LocalDate getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(LocalDate dateLimit2) {
		this.dateLimit = dateLimit2;
	}
	public FinancialService getFinancialService() {
		return financialService;
	}

	public void setFinancialService(FinancialService financialService) {
		this.financialService = financialService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public Date getCreation_date() {
		return creation_date;
	}


	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}


	public Date getPaid_at() {
		return paid_at;
	}


	public void setPaid_at(Date paid_at) {
		this.paid_at = paid_at;
	}
	
	
		
}
