package horizure.micro.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import horizure.micro.finance.entities.Comment;
import horizure.micro.finance.repositories.CommentRepository;

public class CommentServiceImpl implements ICommentService {

	
	@Autowired
	CommentRepository commentRepository;
	
	
	@Override
	public List<Comment> retrieveComments() {
		 return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public Comment addComment(Comment c) {
		commentRepository.save(c);
		   return c;
	}

	@Override
	public Comment updateComment(Comment c) {
		commentRepository.save(c);
		  return c;
	}

	@Override
	public void removeComment(Long id) {
		commentRepository.deleteById(id);
		}

}
