package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FinancialService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_ServiceFinancial ;
	@Enumerated(EnumType.STRING)
	private CategoryFS category ;
	private double amount ;
	private float interest_pr ;
	private int duration ;
	@Enumerated(EnumType.STRING)
	private MethodRB reimbment_method ;
	private double ceiling ;
	private long createdBy_id ;
	@Temporal(TemporalType.DATE)
	private Date date_of_creation ;
	private Boolean isAccepted ;

	public FinancialService() {
		super();
	}

	@OneToMany(mappedBy = "financialService",cascade = CascadeType.REFRESH)
	private List<Payement> payement ;
	
	@ManyToMany(cascade = CascadeType.ALL)
    private List<Account> accounts;
	



	public long getId_ServiceFinancial() {
		return id_ServiceFinancial;
	}

	public void setId_ServiceFinancial(long id_ServiceFinancial) {
		this.id_ServiceFinancial = id_ServiceFinancial;
	}

	public CategoryFS getCategory() {
		return category;
	}

	public void setCategory(CategoryFS category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public float getInterest_pr() {
		return interest_pr;
	}

	public void setInterest_pr(float interest_pr) {
		this.interest_pr = interest_pr;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public MethodRB getReimbment_method() {
		return reimbment_method;
	}

	public void setReimbment_method(MethodRB reimbment_method) {
		this.reimbment_method = reimbment_method;
	}

	public double getCeiling() {
		return ceiling;
  }
  
	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}

	public long getCreatedBy_id() {
		return createdBy_id;
	}

	public void setCreatedBy_id(long createdBy_id) {
		this.createdBy_id = createdBy_id;
	}

	public Date getDate_of_creation() {
		return date_of_creation;
	}

	public void setDate_of_creation(Date date_of_creation) {
		this.date_of_creation = date_of_creation;
	}

	public Boolean getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public List<Payement> getPayement() {
		return payement;
	}

	public void setPayement(List<Payement> payement) {
		this.payement = payement;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	


}
