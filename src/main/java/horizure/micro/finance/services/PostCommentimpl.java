package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.entities.postComment;
import horizure.micro.finance.repositories.PostCommentRepostry;

public class PostCommentimpl  implements CommentPOstService{
	@Autowired
	PostCommentRepostry postCommentRepostry;
	@Autowired
	horizure.micro.finance.repositories.UserRepository  UserRepository ;
	@Autowired
	 horizure.micro.finance.repositories.PostRepositry PostRepositry;
	

	@Override
	public postComment addpostComment(postComment cp, int idPost, int idUser) {
		Post p= PostRepositry.findById((long)idPost).get();
		User  u= UserRepository.findById((long)idUser).get();
		cp.setUser1(u);
		cp.setPost(p);
		p.setNumberCommentpost(p.getNumberCommentpost()+1);
		PostRepositry.save(p);
		
		
		return postCommentRepostry.save(cp);
	}

	@Override
	public void deletepostCommentById(String idpostComment) {
		postCommentRepostry.deleteById(Long.parseLong(idpostComment));
		
		
		
		
	}

	@Override
	public postComment updatepostComment(postComment cp) {
		
		return postCommentRepostry.save(cp) ;
	}

	@Override
	public List<postComment> retrieveAllCommentsPost() {
		 List<postComment> postComments=postCommentRepostry.findAll();
		return postComments ;
	}

	@Override
	public Optional<postComment> retrieveCommentPost(String idpostComment) {
		Optional<postComment> post=postCommentRepostry.findById(Long.parseLong(idpostComment));
		return null;
	}

	@Override
	public List<postComment> getAllCommentByUser(User user) {
		List<postComment> list=postCommentRepostry.getAllCommentByUser(user);
		
		
		return list;
	}

	@Override
	public int getNombreCommentByUser(User user) {
	int a=	postCommentRepostry.getNombreCommentByUser(user);
		
		return a;
	}

	@Override
	public List<postComment> getAllCommentByPost(Post post) {
		 List<postComment> posts=postCommentRepostry.getAllCommentByPost(post);
		return posts;
	}

	@Override
	public int getNombreCommentByPost(Post post) {
		int b=postCommentRepostry.getNombreCommentByPost(post);
		return b;
	}

}
