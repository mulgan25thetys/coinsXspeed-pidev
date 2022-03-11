package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="ScoreProposition")

public class ScoreProposition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_proposition")
	private Long id_proposition;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date created_at;
	
	/*@ManyToMany
	private List<ScoreQuestion> questions;*/
	
	public Long getId_proposition() {
		return id_proposition;
	}
	public void setId_proposition(Long id_proposition) {
		this.id_proposition = id_proposition;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	/*public List<ScoreQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(List<ScoreQuestion> questions) {
		this.questions = questions;
	}*/
	@Override
	public int hashCode() {
		return Objects.hash(description, id_proposition);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreProposition other = (ScoreProposition) obj;
		return Objects.equals(id_proposition, other.id_proposition);
	}
	
	
	
	
}
