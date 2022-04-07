package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Comment;

 @Repository
 public interface CommentRepository extends JpaRepository<Comment,Long>{
	    //search the number of comments grouped by the reply_id = id_no_financial_service
	 
		@Query(value = "SELECT count(*) FROM Comment FULL JOIN no_financial_service ON no_financial_service.id_no_financial_service = reply_id",nativeQuery = true)
		int getNbCommentsByReplyID(@Param("reply_id") Long reply_id);

}
