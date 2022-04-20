package horizure.micro.finance.services;

import java.util.List;
import java.util.Optional;

import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User;

public interface PostService {
	Post addPost(Post post, int userId);
	  void deletePostById(String idPost);
	  Post updatePost(Post p);
	  List<Post> retrieveAllPosts();
	  Optional<Post> retrievePost(String idPost);
	  List<Post> getAllPostByUser(User user);
	  int getNombrePostByUser(User user);
	  List<Post> getPostsPrefereParUser(int userId);
	  List<Post> getPostParHashtagAimeParUser(int userId);

}
