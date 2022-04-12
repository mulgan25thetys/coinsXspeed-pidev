package horizure.micro.finance.entities;

import java.io.Serializable;

//import java.util.Date;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "message")
public class Message implements Serializable{
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", communication=" + communication + "]";
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private long id;
	
	@Lob
	private String text;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="communication_id") 
	private Communication communication;
	
	public Message() {

	}

	public Message(String text, Communication communication) {
		super();
		this.text = text;
		this.communication = communication;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Communication getCommunication() {
		return communication;
	}

	public void setCommunication(Communication communication) {
		this.communication = communication;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	

}
