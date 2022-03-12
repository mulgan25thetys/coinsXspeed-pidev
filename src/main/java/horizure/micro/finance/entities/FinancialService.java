package horizure.micro.finance.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FinancialService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_ServiceFinancial ;
	@Enumerated(EnumType.STRING)
	private CategoryFS category ;
	private long transmitter_id;
	private double amount ;
	private float interest_pr ;
	private long duration ;
	@Enumerated(EnumType.STRING)
	private MethodRB reimbment_method ;
	@Enumerated(EnumType.STRING)
	private FlowType flow ;
	private long createdBy_id ;
	@Temporal(TemporalType.DATE)
	private Date created_at ;
	
	@ManyToMany
    private List<Account> accounts;
	
	@OneToMany(mappedBy = "financialService",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Claim> claims;
	
	
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	public CategoryFS getCategory() {
		return category;
	}
	public void setCategory(CategoryFS category) {
		this.category = category;
	}
	public long getTransmitter_id() {
		return transmitter_id;
	}
	public void setTransmitter_id(long transmitter_id) {
		this.transmitter_id = transmitter_id;
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
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public MethodRB getReimbment_method() {
		return reimbment_method;
	}
	public void setReimbment_method(MethodRB reimbment_method) {
		this.reimbment_method = reimbment_method;
	}
	public FlowType getFlow() {
		return flow;
	}
	public void setFlow(FlowType flow) {
		this.flow = flow;
	}
	public long getCreatedBy_id() {
		return createdBy_id;
	}
	public void setCreatedBy_id(long createdBy_id) {
		this.createdBy_id = createdBy_id;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	@ManyToOne
	Payement payement ;

	public long getId_ServiceFinancial() {
		return id_ServiceFinancial;
	}
	public void setId_ServiceFinancial(long id_ServiceFinancial) {
		this.id_ServiceFinancial = id_ServiceFinancial;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public Payement getPayement() {
		return payement;
	}
	public void setPayement(Payement payement) {
		this.payement = payement;
	}
	
	

}
