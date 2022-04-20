 package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User; 
import horizure.micro.finance.repositories.PostRepositry;
import horizure.micro.finance.repositories.UserRepository;
@Service
public class PostServiceimpl  implements PostService{
	@Autowired
	PostRepositry postRepositry;
	@Autowired
	UserRepository userRepositry;


	@Override
	public Post addPost(Post post, int userId) {
		
		User user= userRepositry.findById((long)userId).get();
		post.setUser(user);
		return postRepositry.save(post);
	
	}

	@Override
	public void deletePostById(String idPost) {
		postRepositry.deleteById(Long.parseLong(idPost));
		
	}

	@Override
	public Post updatePost(Post p) {
		// TODO Auto-generated method stub
		return postRepositry.save(p);
	}

	@Override
	public List<Post> retrieveAllPosts() {
		 List<Post> posts=postRepositry.findAll();
		 return posts;
		
	}

	@Override
	public Optional<Post> retrievePost(String idPost) {
		Optional<Post> post=postRepositry.findById(Long.parseLong(idPost));
		return post;
	}

	@Override
	public List<Post> getAllPostByUser(User user) {
		return postRepositry.getAllPostByUser(user);
		
	}

	@Override
	public int getNombrePostByUser(User user) {
	 return postRepositry.getNombrePostByUser(user);
		
	}

	@Override
	public List<Post> getPostsPrefereParUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostParHashtagAimeParUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
