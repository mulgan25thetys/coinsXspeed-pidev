package horizure.micro.finance.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Reaction implements Serializable {
	public Reaction(Long id, boolean islike, boolean isdislike, boolean issignal, User user, Post post, postComment comment) {
		super();
		this.id = id;
		this.islike = islike;
		this.isdislike = isdislike;
		this.issignal = issignal;
		this.user = user;
		this.post = post;
		this.comment = comment;
	}
	public Reaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean islike;
	private boolean isdislike;
	private boolean issignal;
	@ManyToOne   
	private User user;
	@ManyToOne
	private Post post;
	@ManyToOne
	private postComment  comment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isLike() {
		return islike;
	}
	public void setLike(boolean islike) {
		this.islike = islike;
	}
	public boolean isDislike() {
		return isdislike;
	}
	public void setDislike(boolean isdislike) {
		this.isdislike = isdislike;
	}
	public boolean isSignal() {
		return issignal;
	}
	public void setSignal(boolean issignal) {
		this.issignal = issignal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public postComment getComment() {
		return comment;
	}
	public void setComment(postComment comment) {
		this.comment = comment;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
