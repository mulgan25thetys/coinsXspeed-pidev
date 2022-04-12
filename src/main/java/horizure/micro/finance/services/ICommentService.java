package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.Comment;

public interface ICommentService {
	
     List<Comment> retrieveComments ();   
     
	   Comment getComment(Long id);
     
      Comment addComment(Comment c);            
	
	 Comment updateComment(Comment c);         
	
	  void removeComment(Long id);
	  
	  int  getNbCommentsByReplyID(Long id );


}
