package horizure.micro.finance.entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Mail implements Serializable{
	public Mail(String send_to, String subject, String message) {
		super();
		this.send_to = send_to;
		this.subject = subject;
		this.message = message;
	}
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id_mail;
	@Column(name="send_to")
	private String send_to;
	@Column(name="sujet")
	private String subject;
	@Column(name="message")
	private String message;
	public Long getId_mail() {
		return id_mail;
	}
	public void setId_mail(Long id_mail) {
		this.id_mail = id_mail;
	}
	public String getSend_to() {
		return send_to;
	}
	public void setSend_to(String send_to) {
		this.send_to = send_to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Mail [id_mail=" + id_mail + ", send_to=" + send_to + ", subject=" + subject + ", message=" + message
				+ "]";
	}
	
	
	

}
