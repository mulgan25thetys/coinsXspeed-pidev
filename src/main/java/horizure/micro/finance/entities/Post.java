package horizure.micro.finance.entities;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_Post")
public class Post implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPost;
	@Temporal(TemporalType.DATE)
	private Date datePublicationPost= new Date();
	private String subjectPost;
	private String descriptionPost;
	private int numbCommentPost;
	private int numbLikePost;
	private int numbDislikePost;
	private int numbSignalPost;
	
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	public Post(Long idPost, Date datePublicationPost, String subjectPost, String descriptionPost, int numbCommentPost,
			int numbLikePost, int numbDislikePost, int numbSignalPost) {
		super();
		this.idPost = idPost;
		this.datePublicationPost = datePublicationPost;
		this.subjectPost = subjectPost;
		this.descriptionPost = descriptionPost;
		this.numbCommentPost = numbCommentPost;
		this.numbLikePost = numbLikePost;
		this.numbDislikePost = numbDislikePost;
		this.numbSignalPost = numbSignalPost;
		
	}





	@OneToMany(mappedBy="post", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<CommentPost> commentsPost;
	
	
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="post1", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Reaction> reactions;
	
	
	

	

	

	
    
	
    @JsonIgnore
	public List<Reaction> getReactions() {
		return reactions;
	}

	public void setReactions(List<Reaction> reactions) {
		this.reactions = reactions;
	}
    @JsonIgnore
	public List<CommentPost> getCommentsPost() {
		return commentsPost;
	}

	public void setCommentsPost(List<CommentPost> commentsPost) {
		this.commentsPost = commentsPost;
	}

	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	public Date getDatePublicationPost() {
		return datePublicationPost;
	}
	public void setDatePublicationPost(Date datePublicationPost) {
		this.datePublicationPost = datePublicationPost;
	}
	public String getSubjectPost() {
		return subjectPost;
	}
	public void setSubjectPost(String subjectPost) {
		this.subjectPost = subjectPost;
	}
	public String getDescriptionPost() {
		return descriptionPost;
	}
	public void setDescriptionPost(String descriptionPost) {
		this.descriptionPost = descriptionPost;
	}
	
	public int getNumbCommentPost() {
		return numbCommentPost;
	}


	public void setNumbCommentPost(int numbCommentPost) {
		this.numbCommentPost = numbCommentPost;
	}


	public int getNumbLikePost() {
		return numbLikePost;
	}
	public void setNumbLikePost(int numbLikePost) {
		this.numbLikePost = numbLikePost;
	}
	public int getNumbDislikePost() {
		return numbDislikePost;
	}
	public void setNumbDislikePost(int numbDislikePost) {
		this.numbDislikePost = numbDislikePost;
	}
	public int getNumbSignalPost() {
		return numbSignalPost;
	}
	public void setNumbSignalPost(int numbSignalPost) {
		this.numbSignalPost = numbSignalPost;
	}
	
	


	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
