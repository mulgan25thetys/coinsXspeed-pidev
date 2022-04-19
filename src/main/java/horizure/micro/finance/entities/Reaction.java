package horizure.micro.finance.entities;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition="BOOLEAN DEFAULT false")
	private boolean statusLike;
	private boolean statusDislike;
	private boolean statusSignal;
	@ManyToOne
	private Post post1;
	@ManyToOne
	private User user1;
	@ManyToOne
	private CommentPost commentPost;
	public Reaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reaction(Long id, boolean statusLike, boolean statusDislike, boolean statusSignal, Post post1, User user1) {
		super();
		this.id = id;
		this.statusLike = statusLike;
		this.statusDislike = statusDislike;
		this.statusSignal = statusSignal;
		this.post1 = post1;
		this.user1 = user1;
	}
	public Reaction(boolean statusLike, boolean statusDislike, boolean statusSignal, Post post1, User user1) {
		super();
		this.statusLike = statusLike;
		this.statusDislike = statusDislike;
		this.statusSignal = statusSignal;
		this.post1 = post1;
		this.user1 = user1;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isStatusLike() {
		return statusLike;
	}
	public void setStatusLike(boolean statusLike) {
		this.statusLike = statusLike;
	}
	public boolean isStatusDislike() {
		return statusDislike;
	}
	public void setStatusDislike(boolean statusDislike) {
		this.statusDislike = statusDislike;
	}
	public boolean isStatusSignal() {
		return statusSignal;
	}
	public void setStatusSignal(boolean statusSignal) {
		this.statusSignal = statusSignal;
	}
	public Post getPost1() {
		return post1;
	}
	public void setPost1(Post post1) {
		this.post1 = post1;
	}
	public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public CommentPost getCommentPost() {
		return commentPost;
	}
	public void setCommentPost(CommentPost commentPost) {
		this.commentPost = commentPost;
	}
	
	
	
	
	
	
	
	
	

}

