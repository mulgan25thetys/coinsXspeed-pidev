package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="Account")
@DynamicUpdate
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_account")
    private Long id_account;
    
    @Enumerated(EnumType.STRING)
    private AccountType type;
    
    @Column(unique = true)
    private Long account_number;
    
    private Double capital;
    
    private int score;
    
    private Boolean isApproved;
    
    @Enumerated(EnumType.STRING)
    private AccountStatus state;
    
    @Temporal(TemporalType.DATE)
    private Date updated_at;
    
    @Temporal(TemporalType.DATE)
    private Date created_at;
    
    @JsonIgnore
    @OneToOne
    private User user;
    
    @ManyToMany(cascade =CascadeType.ALL)
    private List<FinancialService> financialServices;
    
    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    private List<Transaction> transactions;
    
    
    
	public Long getId_account() {
		return id_account;
	}
	public void setId_account(Long id_account) {
		this.id_account = id_account;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public Long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(Long account_number) {
		this.account_number = account_number;
	}
	public Double getCapital() {
		return capital;
	}
	public void setCapital(Double capital) {
		this.capital = capital;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public AccountStatus getState() {
		return state;
	}
	public void setState(AccountStatus state) {
		this.state = state;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<FinancialService> getF_services() {
		return financialServices;
	}
	public void setF_services(List<FinancialService> financialServices) {
		this.financialServices = financialServices;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Account(Long id_account, AccountType type, Long account_number) {
		super();
		this.id_account = id_account;
		this.type = type;
		this.account_number = account_number;
	}
	public Account() {
		super();
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
    
    
}
