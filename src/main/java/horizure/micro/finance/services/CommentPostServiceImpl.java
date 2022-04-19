package horizure.micro.finance.services;



import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.CommentPost;
import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.CommentPostRepositry;
import horizure.micro.finance.repositories.PostRepositry;
import horizure.micro.finance.repositories.UserRepository;


@Service
public class CommentPostServiceImpl implements CommentPostService {
	@Autowired
	CommentPostRepositry commentPostRepository;
	@Autowired
	PostRepositry postRepository;

	
	@Autowired
	UserRepository userRepository;



	@Override
	public CommentPost addCommentPost(CommentPost cp, int idPost, int idUser) {
		Post post= postRepository.findById((long)idPost).get();
		User user= userRepository.findById((long)idUser).get();
		cp.setPost(post);
		cp.setUser2(user);
		post.setNumbCommentPost(post.getNumbCommentPost()+1);
		postRepository.save(post);
		return commentPostRepository.save(cp);
	}

	@Override
	public void deleteCommentPostById(String idCommentPost) {
		commentPostRepository.deleteById(Long.parseLong(idCommentPost));
		
	}

	@Override
	public CommentPost updateCommentPost(CommentPost cp) {
		
		return commentPostRepository.save(cp);
	}

	@Override
	public List<CommentPost> retrieveAllCommentsPost() {
		List<CommentPost> commentsPost = (List<CommentPost>) commentPostRepository.findAll();
		
		return   commentsPost ;
	}

	@Override
	public Optional<CommentPost> retrieveCommentPost(String idCommentPost) {
		Optional<CommentPost> cp = commentPostRepository.findById(Long.parseLong(idCommentPost));
		return  cp ;
		
	}
	
	
	
	@Override
	public List<CommentPost> getAllCommentByUser(User user){
		return commentPostRepository.getAllCommentByUser(user);
	}
	
	@Override
	public int getNombreCommentByUser(User user){
		return commentPostRepository.getNombreCommentByUser(user);
	}
	
	@Override
	public List<CommentPost> getAllCommentByPost(Post post){
		return commentPostRepository.getAllCommentByPost(post);
	}
	
	@Override
	public int getNombreCommentByPost(Post post){
		return commentPostRepository.getNombreCommentByPost(post);
	}
	
	
	

}

