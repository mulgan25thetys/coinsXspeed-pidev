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

import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.repositories.UserRepository;
import horizure.micro.finance.services.PostService;

@CrossOrigin("*")
@RestController
public class PostCOntroller {
	@Autowired
	PostService postService;
	@Autowired
	UserRepository userRepository;
    
	
	@GetMapping("/retrieve-all-posts")
	@ResponseBody
	public List<Post> getPosts() {
	List<Post> Posts = postService.retrieveAllPosts();
	return Posts;
	}
	
	@GetMapping("/retrieve-post/{post-id}")
	@ResponseBody
	public Optional<Post> retrievePost(@PathVariable("post-id") String idPost) {
	return postService.retrievePost(idPost);
	}
	
	@PutMapping("/add-post/{userId}")
	@ResponseBody
	public Post addPost(@RequestBody Post post, @PathVariable int userId) {
	postService.addPost(post, userId);
	return post;
	}
	@DeleteMapping("/remove-post/{post-id}")
	@ResponseBody
	public void removePost(@PathVariable("post-id") String id) {
	postService.deletePostById(id);
	}
	@PutMapping("/modify-post")
	@ResponseBody
	public Post modifyPost(@RequestBody Post post) {
	return postService.updatePost(post);
	}
	
	
	
	@GetMapping("/getAllPostByUser/{userId}")
	public List<Post> getAllPostByUser(@PathVariable("userId") int userId){
		User user= userRepository.findById((long)userId).get();
		return postService.getAllPostByUser(user);
	}
	
	@GetMapping("/getNombrePostByUser/{userId}")
	public int getNombrePostByUser(@PathVariable("userId") int userId){
		User user= userRepository.findById((long)userId).get();
		return postService.getNombrePostByUser(user);
		
	}
	
	@GetMapping("/getPostsPrefereParUser/{userId}")
	public List<Post> getPostsPrefereParUser(@PathVariable("userId") int userId){
		return postService.getPostsPrefereParUser(userId);
	}
	
	@GetMapping("/getPostParHashtagAimeParUser/{userId}")
	public List<Post> getPostParHashtagAimeParUser(@PathVariable("userId")int userId){
		return postService.getPostParHashtagAimeParUser(userId);
	}


}

