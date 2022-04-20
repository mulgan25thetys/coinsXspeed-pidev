package horizure.micro.finance.controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import horizure.micro.finance.entities.CommentPost;
import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.PostRepositry;
import horizure.micro.finance.repositories.UserRepository;
import horizure.micro.finance.services.CommentPostService;

@CrossOrigin("*")
@RestController
public class PostCommentController {
	@Autowired
	CommentPostService commentPostService;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PostRepositry postRepository;
    
	
	@GetMapping("/retrieve-all-commentPosts")
	@ResponseBody
	public List<CommentPost> getCommentsPost() {
	List<CommentPost> commentsPost = commentPostService.retrieveAllCommentsPost();
	return commentsPost;
	}
	
	@GetMapping("/retrieve-commentPost/{commentPost-id}")
	@ResponseBody
	public Optional<CommentPost> retrieveCommentPost(@PathVariable("commentPost-id") String idCommentPost) {
	return commentPostService.retrieveCommentPost(idCommentPost);
	}
	
	@PutMapping("/add-commentPost/{idPost}/{idUser}")
	@ResponseBody
	public CommentPost addCommentPost(@RequestBody CommentPost cp, @PathVariable("idPost") int idPost, @PathVariable("idUser") int idUser) {
	commentPostService.addCommentPost(cp, idPost, idUser);
	return cp;
	}
	@DeleteMapping("/remove-commentPost/{commentPost-id}")
	@ResponseBody
	public void removeCommentPost(@PathVariable("commentPost") String id) {
	commentPostService.deleteCommentPostById(id);
	}
	@PutMapping("/modify-commentPost")
	@ResponseBody
	public CommentPost modifyCommentPost(@RequestBody CommentPost commentPost) {
	return commentPostService.updateCommentPost(commentPost);
	}
	
	@GetMapping("/getAllCommentByUser/{userId}")
	public List<CommentPost> getAllCommentByUser(@PathVariable("userId") int userId){
		User user= userRepository.findById((long)userId).get();
		return commentPostService.getAllCommentByUser(user);
	}
	
	@GetMapping("/getNombreCommentByUser/{userId}")
	public int getNombreCommentByUser(@PathVariable("userId") int userId){
		User user= userRepository.findById((long)userId).get();
		return commentPostService.getNombreCommentByUser(user);
		
	}
	
	@GetMapping("getAllCommentByPost/{postId}")
	public List<CommentPost> getAllCommentByPost(@PathVariable("postId") int postId){
		Post post= postRepository.findById((long) postId).get();
		return commentPostService.getAllCommentByPost(post);
	}
	
	@GetMapping("getNombreCommentByPost/{postId}")
	public int getNombreCommentByPost(@PathVariable("postId") int postId){
		Post post= postRepository.findById((long) postId).get();
		return commentPostService.getNombreCommentByPost(post);
		
	}


}

