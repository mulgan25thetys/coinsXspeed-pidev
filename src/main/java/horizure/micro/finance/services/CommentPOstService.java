package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.entities.postComment;

public interface CommentPOstService {
	postComment addpostComment(postComment cp, int idPost, int idUser);
	  void deletepostCommentById(String idpostComment);
	  postComment updatepostComment(postComment cp);
	  List<postComment> retrieveAllCommentsPost();
	  Optional<postComment> retrieveCommentPost(String idpostComment);
	  List<postComment> getAllCommentByUser(User user);
	  int getNombreCommentByUser(User user);
	  List<postComment> getAllCommentByPost(Post post);
	  int getNombreCommentByPost(Post post);

}
