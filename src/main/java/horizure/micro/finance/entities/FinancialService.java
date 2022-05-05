package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	//private long createdBy_id ;
	@Temporal(TemporalType.DATE)
	private Date date_of_creation ;
	@Temporal(TemporalType.DATE)
	private Date date_of_updating ;
	//private Boolean isAccepted ;

	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "financialService",cascade = CascadeType.REFRESH)
	private List<Payement> payement = new ArrayList<Payement>();
	
	public FinancialService() {
		super();
	}

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

	public Date getDate_of_creation() {
		return date_of_creation;
	}

	public void setDate_of_creation(Date date_of_creation) {
		this.date_of_creation = date_of_creation;
	}

	public List<Payement> getPayement() {
		return payement;
	}

	public void setPayement(List<Payement> payement) {
		this.payement = payement;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDate_of_updating() {
		return date_of_updating;
	}

	public void setDate_of_updating(Date date_of_updating) {
		this.date_of_updating = date_of_updating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, category, date_of_creation, duration);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinancialService other = (FinancialService) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && category == other.category
				&& Objects.equals(date_of_creation, other.date_of_creation) && duration == other.duration;
	}

}
