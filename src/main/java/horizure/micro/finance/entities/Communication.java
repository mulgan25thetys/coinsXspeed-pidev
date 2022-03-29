package horizure.micro.finance.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
@Table(name="Communication")
public class Communication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Communication(Set<Message> messages) {
		super();
		this.messages = messages;
	}
	
	
	public Communication(Set<User> users, Set<Message> messages) {
		super();
		this.users = users;
		this.messages = messages;
	}
	public Communication() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "user_conversations", joinColumns = @JoinColumn(name = "communication_id_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id")) 
	private Set<User> users;
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy=" communication")
	private Set<Message> messages;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

}