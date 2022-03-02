package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name="ScoreForm")
public class ScoreForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_scoreFrom")
	private Long id_scoreForm;
	private String title;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date created_at;
	
	@OneToMany(mappedBy = "questionForm",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<ScoreQuestion> questions;

	public Long getId_scoreForm() {
		return id_scoreForm;
	}

	public void setId_scoreForm(Long id_scoreForm) {
		this.id_scoreForm = id_scoreForm;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public List<ScoreQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<ScoreQuestion> questions) {
		this.questions = questions;
	}
	
	
}
