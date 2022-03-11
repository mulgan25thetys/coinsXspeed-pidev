package horizure.micro.finance.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.ScoreForm;

@Repository
public interface ScoreFormRepository extends CrudRepository<ScoreForm, Long>{

	@Modifying
	@Query(value = "UPDATE User u set u.scoreform_id_score_from  =:idform WHERE u.id_user =:iduser",nativeQuery = true)
	int assynFormToUser(@Param("iduser") Long iduser,@Param("idform") Long idform);
	
}
