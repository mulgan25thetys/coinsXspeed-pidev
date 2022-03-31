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
import horizure.micro.finance.repositories.PostRepositry;
import horizure.micro.finance.repositories.UserRepository;
import horizure.micro.finance.services.PostService;

@RestController
public class PostRest {
	@Autowired
	PostService postService;
	@Autowired
	PostRepositry postRepositry;
	@Autowired
	UserRepository repository;
	@GetMapping("/retrieve_all_posts")
	@ResponseBody
	public List<Post> list() {
	List<Post> Posts = postService.retrieveAllPosts();
	return Posts;
	}
	@GetMapping("/retrieve_post/{post_id}")
	@ResponseBody
	public Optional<Post> retrievePost(@PathVariable("post_id") String idPost) {
	return postService.retrievePost(idPost);
	}
	@PutMapping("/add_post/{userId}")
	@ResponseBody
	public Post addPost(@RequestBody Post post, @PathVariable int userId) {
	postService.addPost(post, userId);
	return post;
	}
	@DeleteMapping("/delet-post/{post_id}")
	@ResponseBody
	public void deletPost(@PathVariable("post_id") String id) {
	postService.deletePostById(id);
	}
	@PutMapping("/update_post")
	@ResponseBody
	public Post updatePost(@RequestBody Post post) {
	return postService.updatePost(post);
	}
	@GetMapping("/getAllPostByUser/{userId}")
	public List<Post> getAllPostByUser(@PathVariable("userId") int userId){
		User  user= repository.findById((long)userId).get();
		return postService.getAllPostByUser(user);
	}
	
	@GetMapping("/getNombrePostByUser/{userId}")
	public int getNombrePostByUser(@PathVariable("userId") int userId){
		User user= repository.findById((long)userId).get();
		return postService.getNombrePostByUser(user);
		
	}

}
