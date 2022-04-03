package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Notification")
public class Notification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idNotification")
	private Long idNotification;
	@Enumerated(EnumType.STRING)
	private TypeNotification type;
	private String object;
	private String message;
	@Enumerated(EnumType.STRING)
	private EsentOn sent_on;
	private Long recepientId;
	private boolean isSended;
	private Long sendBy;
	@Temporal(TemporalType.DATE)
	private Date created_at;

	@ManyToMany
	private List<User> users;

	public Long getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(Long idNotification) {
		this.idNotification = idNotification;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TypeNotification getType() {
		return type;
	}

	public void setType(TypeNotification type) {
		this.type = type;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EsentOn getSent_on() {
		return sent_on;
	}

	public void setSent_on(EsentOn sent_on) {
		this.sent_on = sent_on;
	}

	public boolean isSended() {
		return isSended;
	}

	public void setSended(boolean isSended) {
		this.isSended = isSended;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Long getRecepientId() {
		return recepientId;
	}

	public void setRecepientId(Long recepientId) {
		this.recepientId = recepientId;
	}

	public Long getSendBy() {
		return sendBy;
	}

	public void setSendBy(Long sendBy) {
		this.sendBy = sendBy;
	}
	
	
}
