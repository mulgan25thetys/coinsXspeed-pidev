package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import horizure.micro.finance.entities.User;
import horizure.micro.finance.entities.postComment;
import horizure.micro.finance.entities.Post;


@Repository
public interface PostCommentRepostry extends JpaRepository<postComment,Long>{
	@Query("Select "
			+ "DISTINCT cp from PostComment cp "
			+ "join cp.user1 user1 "
			+ "where user1=:user")
    public List<postComment> getAllCommentByUser(@Param("user1") User user);
	
	@Query("Select count(*) from CommentPost cp JOIN cp.user1 user1 WHERE user1=:user")
	public int getNombreCommentByUser(@Param("user1") User user);
	
	@Query("Select "
			+ "DISTINCT cp from postComment cp "
			+ "join cp.post ps "
			+ "where ps=:post")
    public List<postComment> getAllCommentByPost(@Param("post") Post post);
	
	@Query("Select count(*) from postComment commentpost JOIN commentpost.post ps WHERE ps=:post")
	public int getNombreCommentByPost(@Param("post") Post  post);
	


}
