package horizure.micro.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.Comment;
import horizure.micro.finance.repositories.CommentRepository;

@Service
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

	@Override
	public Comment getComment(Long id) {
		return commentRepository.getById(id);
	}

	@Override
	public int getNbCommentsByReplyID(Long id) {

		
		return commentRepository.getNbCommentsByReplyID(id);
		
		
		
		
	}

}
