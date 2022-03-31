package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Post implements Serializable {
	
	public Post(Long id, String subjectPost, String descrptionPost, Date datepost, int numberlikepost,
			int numberdislikpost, int numbersignalpost, int numberCommentpost, User user, List<Reaction> reactions,
			List<postComment> postcomments) {
		super();
		this.id = id;
		this.subjectPost = subjectPost;
		this.descrptionPost = descrptionPost;
		this.datepost = datepost;
		this.numberlikepost = numberlikepost;
		this.numberdislikpost = numberdislikpost;
		this.numbersignalpost = numbersignalpost;
		this.numberCommentpost = numberCommentpost;
		this.user = user;
		this.reactions = reactions;
		this.postcomments = postcomments;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subjectPost;
	private String descrptionPost;
	@Temporal(TemporalType.DATE)
	private Date datepost=new Date();
	private int numberlikepost;
	private int numberdislikpost;
	private int numbersignalpost;
	private int numberCommentpost;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy="post1", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Reaction> reactions;
	@OneToMany
	private List<postComment> postcomments;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubjectPost() {
		return subjectPost;
	}
	public void setSubjectPost(String subjectPost) {
		this.subjectPost = subjectPost;
	}
	public String getDescrptionPost() {
		return descrptionPost;
	}
	public void setDescrptionPost(String descrptionPost) {
		this.descrptionPost = descrptionPost;
	}
	public Date getDatepost() {
		return datepost;
	}
	public void setDatepost(Date datepost) {
		this.datepost = datepost;
	}
	public int getNumberlikepost() {
		return numberlikepost;
	}
	public void setNumberlikepost(int numberlikepost) {
		this.numberlikepost = numberlikepost;
	}
	public int getNumberdislikpost() {
		return numberdislikpost;
	}
	public void setNumberdislikpost(int numberdislikpost) {
		this.numberdislikpost = numberdislikpost;
	}
	public int getNumbersignalpost() {
		return numbersignalpost;
	}
	public void setNumbersignalpost(int numbersignalpost) {
		this.numbersignalpost = numbersignalpost;
	}
	public int getNumberCommentpost() {
		return numberCommentpost;
	}
	public void setNumberCommentpost(int numberCommentpost) {
		this.numberCommentpost = numberCommentpost;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Reaction> getReactions() {
		return reactions;
	}
	public void setReactions(List<Reaction> reactions) {
		this.reactions = reactions;
	}
	public List<postComment> getPostcomments() {
		return postcomments;
	}
	public void setPostcomments(List<postComment> postcomments) {
		this.postcomments = postcomments;
	}

}
