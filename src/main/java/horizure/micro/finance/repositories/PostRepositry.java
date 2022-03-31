package horizure.micro.finance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User;

public interface PostRepositry extends JpaRepository<Post, Long> {
	@Query("Select "
			+ "DISTINCT post from Post post "
			+ "join post.user us "
			+ "where us=:user")
    public List<Post> getAllPostByUser(@Param("user") User user);
	
	@Query("Select count(*) from Post post JOIN post.user user1 WHERE user1=:user")
	public int getNombrePostByUser(@Param("user") User user);
	

}

