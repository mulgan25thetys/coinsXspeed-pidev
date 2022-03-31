package horizure.micro.finance.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.entities.postComment;
import horizure.micro.finance.repositories.PostRepositry;
import horizure.micro.finance.repositories.UserRepository;
import horizure.micro.finance.services.CommentPOstService;
import horizure.micro.finance.services.PostService;

@RestController
public class PostCommentRest {
	@Autowired
	CommentPOstService commentPOstService;
	UserRepository userRepositry;
	PostService postservice;
	@Autowired
	PostRepositry postRepositry;
	@GetMapping("/retrieve_all_commentPosts")
	@ResponseBody
	public List<postComment> getCommentsPost() {
	List<postComment> commentsPost = commentPOstService.retrieveAllCommentsPost();
	return commentsPost;
	}
	
	@GetMapping("/retrieve_commentPost/{commentPost_id}")
	@ResponseBody
	public Optional<postComment> retrieveCommentPost(@PathVariable("commentPost_id") String idCommentPost) {
	return  commentPOstService.retrieveCommentPost(idCommentPost);
	}
	
	@PutMapping("/add_commentPost/{idPost}/{idUser}")
	@ResponseBody
	public postComment addCommentPost(@RequestBody postComment cp, @PathVariable("idPost") int idPost, @PathVariable("idUser") int idUser) {
	commentPOstService.addpostComment(cp, idPost, idUser);
	return cp;
	}
	@DeleteMapping("/delet_commentPost/{commentPost_id}")
	@ResponseBody
	public void removeCommentPost(@PathVariable("commentPost_id") String id) {
		commentPOstService.deletepostCommentById(id);
	}
	@PutMapping("/modify-commentPost")
	@ResponseBody
	public postComment updatepostComment(@RequestBody postComment commentPost) {
	return commentPOstService.updatepostComment(commentPost);
	}
	
	@GetMapping("/getAllCommentByUser/{user_Id}")
	public List<postComment> getAllCommentByUser(@PathVariable("user_Id") int userId){
		User user= userRepositry.findById((long)userId).get();
		return commentPOstService.getAllCommentByUser(user);
	}
	
	@GetMapping("/getNombreCommentByUser/{userId}")
	public int getNombreCommentByUser(@PathVariable("userId") int userId){
		User user= userRepositry.findById((long)userId).get();
		return  commentPOstService.getNombreCommentByUser(user);
		
	}
	
	@GetMapping("getAllCommentByPost/{postId}")
	public List<postComment> getAllCommentByPost(@PathVariable("postId") int postId){
		Post post= postRepositry.findById((long) postId).get();
		return commentPOstService.getAllCommentByPost(post);
	}
	
	@GetMapping("getNombreCommentByPost/{postId}")
	public int getNombreCommentByPost(@PathVariable("postId") int postId){
		Post post= postRepositry.findById((long) postId).get();
		return commentPOstService.getNombreCommentByPost(post);
		
	}


}



