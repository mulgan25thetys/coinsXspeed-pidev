package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class postComment implements Serializable {
	public postComment(Long id, String content, int numberlike, int numbersignal, Post post, User user1,
			List<Reaction> reactions1) {
		super();
		this.id = id;
		Content = content;
		this.numberlike = numberlike;
		this.numbersignal = numbersignal;
		this.post = post;
		this.user1 = user1;
		this.reactions1 = reactions1;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Content;
	private int numberlike;
	private int numbersignal;
	@ManyToOne(fetch=FetchType.LAZY)
	private Post post;
	
	
	
	@ManyToOne
	private User user1;
	
	@OneToMany(mappedBy="comment", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Reaction> reactions1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getNumberlike() {
		return numberlike;
	}

	public void setNumberlike(int numberlike) {
		this.numberlike = numberlike;
	}

	public int getNumbersignal() {
		return numbersignal;
	}

	public void setNumbersignal(int numbersignal) {
		this.numbersignal = numbersignal;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public List<Reaction> getReactions1() {
		return reactions1;
	}

	public void setReactions1(List<Reaction> reactions1) {
		this.reactions1 = reactions1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
