package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Revenus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "revenus_id")
	private Long idRevenus;
	private Double amount;
	@Temporal(TemporalType.DATE)
	private Date updated_at;
	public Long getIdRevenus() {
		return idRevenus;
	}
	public void setIdRevenus(Long idRevenus) {
		this.idRevenus = idRevenus;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
