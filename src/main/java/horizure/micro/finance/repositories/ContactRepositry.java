package horizure.micro.finance.repositories;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import horizure.micro.finance.entities.Contact;

@Repository
public interface ContactRepositry extends JpaRepository<Contact, Long> {
	 @Query( "select c from Contact c where c.nom like :x" )
	    public Page<Contact> listeContactParMC( @Param( "x" ) String mc, PageRequest pageRequest );
	}


