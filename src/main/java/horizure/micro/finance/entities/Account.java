package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;




@Entity
@Table(name="Account")
@DynamicUpdate
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account implements Serializable{

	/**
	 * 
	 */
	static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_account")
    Long id_account;
    
    @Enumerated(EnumType.STRING)
    AccountType type;
    
    @Column(unique = true)
    Long account_number;
    
    Double capital;
    
    int score;
    
    Boolean isApproved;
    
    @Enumerated(EnumType.STRING)
    AccountStatus state;
    
    @Temporal(TemporalType.DATE)
    Date updated_at;
    
    @Temporal(TemporalType.DATE)
    Date created_at;
    
    //@ManyToMany(cascade =CascadeType.ALL,mappedBy = "accounts")
    //List<FinancialService> financialServices;
    
    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    List<Transaction> transactions;
    
    //@JsonBackReference
	@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    List<Payement> payments = new ArrayList<Payement>();
    
    @JsonIgnore
    @OneToOne
    User user;

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

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
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

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<Payement> getPayments() {
		return payments;
	}

	public void setPayments(List<Payement> payments) {
		this.payments = payments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
    
}
