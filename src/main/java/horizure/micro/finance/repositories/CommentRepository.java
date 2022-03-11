package horizure.micro.finance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Comment;

 @Repository
 public interface CommentRepository extends CrudRepository<Comment,Long>{

}
