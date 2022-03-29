package horizure.micro.finance.services;

import java.util.List;

import horizure.micro.finance.entities.Reaction;

public interface ReactionSerice {
	List<Reaction> retriveAllReaction();
	Reaction updateReaction(Reaction r);
	void deletReactionById(String id);
	void addLike(Reaction r, int post_Id, int user_Id);
	  void addDislike(Reaction r, int post_Id, int user_Id);
	  void addSignal(Reaction r, int post_Id, int user_Id);
	  void addLikeAcomment(Reaction r, int comment_Id, int user_Id);
	  void addSignalAcomment(Reaction r, int comment_Id, int user_Id);

}
