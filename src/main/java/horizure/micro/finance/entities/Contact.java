package horizure.micro.finance.entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Contact  implements Serializable{
	public Contact(String nom, String prenom, String email, Long telphone, String mesaage) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telphone = telphone;
		this.mesaage = mesaage;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private Long telphone;
	private String mesaage;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTelphone() {
		return telphone;
	}
	public void setTelphone(Long telphone) {
		this.telphone = telphone;
	}
	public String getMesaage() {
		return mesaage;
	}
	public void setMesaage(String mesaage) {
		this.mesaage = mesaage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
