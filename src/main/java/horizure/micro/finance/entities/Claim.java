package horizure.micro.finance.entities;

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

@Entity
@Table(name="Claim")
public class Claim implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idClaim")
	private Long idClaim;
	@Enumerated(EnumType.STRING)
	private TypeClaim type;
	private String message;
	@Enumerated(EnumType.STRING)
	private StatusClaim answerStatus;
	private Long claimantId;
	@Temporal(TemporalType.DATE)
	private Date created_at;
	private Long traitBy;
	
	@ManyToOne
	private FinancialService financialService;

	public Long getIdClaim() {
		return idClaim;
	}

	public void setIdClaim(Long idClaim) {
		this.idClaim = idClaim;
	}

	public TypeClaim getType() {
		return type;
	}

	public void setType(TypeClaim type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StatusClaim getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(StatusClaim answerStatus) {
		this.answerStatus = answerStatus;
	}

	public Long getClaimantId() {
		return claimantId;
	}

	public void setClaimantId(Long claimantId) {
		this.claimantId = claimantId;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Long getTraitBy() {
		return traitBy;
	}

	public void setTraitBy(Long traitBy) {
		this.traitBy = traitBy;
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
	
	
}
