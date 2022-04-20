package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import horizure.micro.finance.entities.Reaction;

public interface ReactionService {
	void addLike(Reaction r, int postId, int userId);
	  void addDislike(Reaction r, int postId, int userId);
	  void addSignal(Reaction r, int postId, int userId);
	  void addLikeAcomment(Reaction r, int commentId, int userId);
	  void addSignalAcomment(Reaction r, int commentId, int userId);
	  void deleteReactionById(String idReaction);
	  Reaction updateReaction(Reaction r);
	  List<Reaction> retrieveAllReactions();
	  Optional<Reaction> retrieveReaction(String idReaction);
	 

}
