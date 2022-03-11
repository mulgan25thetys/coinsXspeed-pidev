package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name="ScoreQuestion")
public class ScoreQuestion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_scoreQuestion")
	private Long id_scoreQuestion;
	private String title;
	private String description;
	private int points;
	//private Long idAnswer;
	/*@Transient
	private ScoreProposition answer;*/
	
	@Temporal(TemporalType.DATE)
	private Date created_at;
	
	@JsonIgnore
	@ManyToOne
	private ScoreForm questionForm;
	
	@ManyToMany(cascade =CascadeType.ALL)
	private List<ScoreProposition> propositions;
	
	@OneToOne
	private ScoreProposition answer;
	
	public Long getId_scoreQuestion() {
		return id_scoreQuestion;
	}
	public void setId_scoreQuestion(Long id_scoreQuestion) {
		this.id_scoreQuestion = id_scoreQuestion;
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
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	/*public ScoreProposition getAnswer() {
		return answer;
	}
	public void setAnswer(ScoreProposition answer) {
		this.answer = answer;
	}*/
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public ScoreForm getQuestionForm() {
		return questionForm;
	}
	public void setQuestionForm(ScoreForm questionForm) {
		this.questionForm = questionForm;
	}
	public List<ScoreProposition> getPropositions() {
		return propositions;
	}
	public void setPropositions(List<ScoreProposition> Propositions) {
		this.propositions = Propositions;
	}
	/*public Long getIdAnswer() {
		return idAnswer;
	}
	public void setIdAnswer(Long idAnswer) {
		this.idAnswer = idAnswer;
	}*/
	public ScoreProposition getAnswer() {
		return answer;
	}
	public void setAnswer(ScoreProposition theAnswer) {
		this.answer = theAnswer;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_scoreQuestion, points);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreQuestion other = (ScoreQuestion) obj;
		return Objects.equals(id_scoreQuestion, other.id_scoreQuestion);
	}
	
	
}
