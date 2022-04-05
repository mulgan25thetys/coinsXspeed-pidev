package tn.esprit.spring.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Tran")
public class Tran implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTransaction")
	private Long idTransaction;
	@Enumerated(EnumType.STRING)
	private TypeTrans type;
	private Double amont;
	private Long creditAcc;
	private Long debtorAcc;
	@Temporal(TemporalType.DATE)
	private Date created_at = new Date();;
	private Date date_tran;

	@JsonIgnore
	@ManyToOne
	private Client client;

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setDate_tran(Date date_tran) {
		this.date_tran = date_tran;
	}

	public Date getDate_tran() {
		return date_tran;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public TypeTrans getType() {
		return type;
	}

	public void setType(TypeTrans type) {
		this.type = type;
	}

	public Double getAmont() {
		return amont;
	}

	public void setAmont(Double amont) {
		this.amont = amont;
	}

	public Long getCreditAcc() {
		return creditAcc;
	}

	public void setCreditAcc(Long creditAcc) {
		this.creditAcc = creditAcc;
	}

	public Long getDebtorAcc() {
		return debtorAcc;
	}

	public void setDebtorAcc(Long debtorAcc) {
		this.debtorAcc = debtorAcc;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
