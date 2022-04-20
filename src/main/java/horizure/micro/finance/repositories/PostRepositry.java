package horizure.micro.finance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import horizure.micro.finance.entities.Post;
import horizure.micro.finance.entities.User;
@Repository
public interface PostRepositry extends JpaRepository<Post, Long> {
	@Query("Select "
			+ "DISTINCT post from Post post "
			+ "join post.user us "
			+ "where us=:user")
    public List<Post> getAllPostByUser(@Param("user") User user);
	
	@Query("Select count(*) from Post post JOIN post.user us WHERE us=:user")
	public int getNombrePostByUser(@Param("user") User user);
	

}
