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
    
    @JsonIgnore
    @OneToOne
    User user;
    
    @ManyToMany(cascade =CascadeType.ALL)
    List<FinancialService> financialServices;
    
    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    List<Transaction> transactions;


    
    
}
