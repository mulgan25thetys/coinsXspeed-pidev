package tn.esprit.spring.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
@Entity
public class Request  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id10 ;

}
