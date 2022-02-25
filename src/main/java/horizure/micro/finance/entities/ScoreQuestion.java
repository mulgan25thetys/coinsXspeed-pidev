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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	private Double points;
	private ScoreProposition answer;
	@Temporal(TemporalType.DATE)
	private Date created_at;
	
	@ManyToOne
	private ScoreForm questionForm;
	
	@ManyToMany(cascade =CascadeType.ALL,mappedBy = "questions",fetch = FetchType.EAGER)
	private List<ScoreProposition> scorePropositions;
	
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
	public Double getPoints() {
		return points;
	}
	public void setPoints(Double points) {
		this.points = points;
	}
	public ScoreProposition getAnswer() {
		return answer;
	}
	public void setAnswer(ScoreProposition answer) {
		this.answer = answer;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public List<ScoreProposition> getPropositions() {
		return scorePropositions;
	}
	public void setPropositions(List<ScoreProposition> scorePropositions) {
		this.scorePropositions = scorePropositions;
	}
	
	

}
