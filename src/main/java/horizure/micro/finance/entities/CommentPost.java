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
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="T_CommentPost")
public class CommentPost implements Serializable  {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String content;
		private int numbLikeComment;
		private int numbSignalComment;

		@ManyToOne(fetch=FetchType.LAZY)
		private Post post;
		
		
		
		@ManyToOne
		private User user2;
		
		@OneToMany(mappedBy="commentPost", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
		private List<Reaction> reactions1;

		public Long getId() {
			return id;
		}
		

		

		public void setId(Long id) {
			this.id = id;
		}




		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public int getNumbLikeComment() {
			return numbLikeComment;
		}

		public void setNumbLikeComment(int numbLikeComment) {
			this.numbLikeComment = numbLikeComment;
		}

		public int getNumbSignalComment() {
			return numbSignalComment;
		}

		public void setNumbSignalComment(int numbSignalComment) {
			this.numbSignalComment = numbSignalComment;
		}
        @JsonIgnore
		public Post getPost() {
			return post;
		}

		public void setPost(Post post) {
			this.post = post;
		}
		
		
		

		

		
        @JsonIgnore
		public User getUser2() {
			return user2;
		}




		public void setUser2(User user2) {
			this.user2 = user2;
		}
		
		



        @JsonIgnore
		public List<Reaction> getReactions1() {
			return reactions1;
		}




		public void setReactions1(List<Reaction> reactions1) {
			this.reactions1 = reactions1;
		}




		public CommentPost() {
			super();
			// TODO Auto-generated constructor stub
		}




		public CommentPost(Long id, String content, int numbLikeComment, int numbSignalComment, Post post, User user2) {
			super();
			this.id = id;
			this.content = content;
			this.numbLikeComment = numbLikeComment;
			this.numbSignalComment = numbSignalComment;
			this.post = post;
			this.user2 = user2;
		}




		public CommentPost(String content, int numbLikeComment, int numbSignalComment, Post post, User user2) {
			super();
			this.content = content;
			this.numbLikeComment = numbLikeComment;
			this.numbSignalComment = numbSignalComment;
			this.post = post;
			this.user2 = user2;
		}

		




		
		
		
		
		
		
		
		
		
		
		

}

