package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import horizure.micro.finance.entities.CommentPost;
import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User;

public interface CommentPostService {
	CommentPost addCommentPost(CommentPost cp, int idPost, int idUser);
	  void deleteCommentPostById(String idCommentPost);
	  CommentPost updateCommentPost(CommentPost cp);
	  List<CommentPost> retrieveAllCommentsPost();
	  Optional<CommentPost> retrieveCommentPost(String idCommentPost);
	  List<CommentPost> getAllCommentByUser(User user);
	  int getNombreCommentByUser(User user);
	  List<CommentPost> getAllCommentByPost(Post post);
	  int getNombreCommentByPost(Post post);

}
