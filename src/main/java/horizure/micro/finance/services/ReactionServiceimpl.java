package horizure.micro.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.Reaction;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.entities.postComment;
import horizure.micro.finance.repositories.PostRepositry;
import horizure.micro.finance.repositories.ReactionRepositry;
import horizure.micro.finance.repositories.UserRepository;
import horizure.micro.finance.repositories.PostCommentRepostry;

public class ReactionServiceimpl implements ReactionSerice{
	@Autowired
	ReactionRepositry reactionRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	 PostRepositry  postRepository;
	@Autowired
	PostCommentRepostry PostCommentRepostry ;
	

	@Override
	public List<Reaction> retriveAllReaction() {
		List<Reaction> reactions=reactionRepository.findAll();
		return reactions;
	}

	@Override
	public Reaction updateReaction(Reaction r) {
		
		
		return  reactionRepository.save(r);
	}

	@Override
	public void deletReactionById(String id) {
		reactionRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public void addLike(Reaction r, int post_Id, int user_Id) {
		Post post= postRepository.findById((long)post_Id).get();
		User user= userRepository.findById((long)user_Id).get();
		
		int i=0;
		boolean test=false;
		while((test==false) &&(i==post.getReactions().size()-1)){
			if(post.getReactions().get(i).isLike()==true && post.getReactions().get(i).getPost().getId()==(long)post_Id && (post.getReactions().get(i).getUser().getUserId()==(long)user_Id)){
				post.getReactions().get(i).setLike(false);
				post.setNumberlikepost(post.getNumberlikepost()-1);
				postRepository.save(post);
				reactionRepository.save(post.getReactions().get(i));
				test=true;
				
				
				
			}
			if(post.getReactions().get(i).isLike()==false &&(post.getReactions().get(i).getPost().getId()==(long)post_Id &&(post.getReactions().get(i).getUser().getUserId()==(long)user_Id))){
				post.getReactions().get(i).setLike(true);
				post.setNumberlikepost(post.getNumberlikepost()+1);
				postRepository.save(post);
				reactionRepository.save(post.getReactions().get(i));
				test=true;
			
		}
			i++;
			}
		if(test==false){
			r.setPost(post);
			r.setUser(user);
			r.setLike(true);
			post.setNumberlikepost(post.getNumberlikepost()+1);
			postRepository.save(post);
			reactionRepository.save(r);
		
			
		}
		
		}
	

	@Override
	public void addDislike(Reaction r, int post_Id, int user_Id) {
		Post post= postRepository.findById((long)post_Id).get();
		User user= userRepository.findById((long)user_Id).get();
		
		int i=0;
		boolean test=false;
		while((test==false) &&(i==post.getReactions().size()-1)){
			if(post.getReactions().get(i).isDislike()==true && post.getReactions().get(i).getPost().getId()==(long)post_Id && (post.getReactions().get(i).getUser().getUserId()==(long)user_Id)){
				post.getReactions().get(i).setLike(false);
				post.setNumberdislikpost(post.getNumberdislikpost()-1);
				postRepository.save(post);
				reactionRepository.save(post.getReactions().get(i));
				test=true;
				
				
				
			}
			if(post.getReactions().get(i).isDislike()==false &&(post.getReactions().get(i).getPost().getId()==(long)post_Id &&(post.getReactions().get(i).getUser().getUserId()==(long)user_Id))){
				post.getReactions().get(i).setDislike(true);
				post.setNumberdislikpost(post.getNumberdislikpost()+1);
				postRepository.save(post);
				reactionRepository.save(post.getReactions().get(i));
				test=true;
			
		}
			i++;
			}
		if(test==false){
			r.setPost(post);
			r.setUser(user);
			r.setDislike(true);
			post.setNumberdislikpost(post.getNumberdislikpost()+1);
			postRepository.save(post);
			reactionRepository.save(r);
			test=true;}
		}

	@Override
	public void addSignal(Reaction r, int post_Id, int user_Id) {
		Post post=postRepository.findById((long)post_Id).get();
		User user=userRepository.findById((long)user_Id).get();
		int i=0;
		boolean test=false;
				while(test==false &&(i==post.getReactions().size()-1)) {
					if(post.getReactions().get(i).isSignal()==false && (post.getReactions().get(i).getPost().getId()==(long)post_Id)&& (post.getReactions().get(i).getUser().getUserId()==(long)user_Id)) {
						post.getReactions().get(i).setSignal(true);
						post.setNumbersignalpost(post.getNumbersignalpost()+1);
						postRepository.save(post);
						reactionRepository.save(post.getReactions().get(i));
						test=true;
					}
					i++;
				}
				if(test==false){
					r.setPost(post);
					r.setUser(user);
					r.setDislike(true);
					post.setNumbersignalpost(post.getNumbersignalpost()+1);
					postRepository.save(post);
					reactionRepository.save(r);
					test=true;}
				
		
	}

	@Override
	public void addLikeAcomment(Reaction r, int comment_Id, int user_Id) {
		
		}

	@Override
	public void addSignalAcomment(Reaction r, int comment_Id, int user_Id) {
		// TODO Auto-generated method stub
		
	}
	

}

