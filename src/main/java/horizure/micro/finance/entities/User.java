package horizure.micro.finance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_User")
	 private Long id;
	 private String password;
	 private String first_name;
	 private String last_name;
	 private String email;
	 private String city;
	 private String country;
	 private String address;
	 private int phone;
	 
	 @Temporal(TemporalType.DATE)
	 private Date date_of_birth;
	 private int age;
	 private double salary;
	 
	 @Temporal(TemporalType.DATE)
	 private Date holidays;
	 
	 @Temporal(TemporalType.DATE)
	 private Date updated_at;
	 
	 @Temporal(TemporalType.DATE)
	 private Date banned_at;
	 private boolean only;
	 private int failed_login_attemp;
	 private int session_per_user;
	 
	 
	 @Enumerated(EnumType.STRING)
	 private ERole erole;
	 
	 @Enumerated(EnumType.STRING)
	 private Egroup egroup;
	 
	 @Enumerated(EnumType.STRING)
	 private Status status;
	 
	 
	 @Temporal(TemporalType.DATE)
	 private Date join_groupe;
	 
	 private Long idle_time;
	 
	 @Temporal(TemporalType.DATE)
	 private Date created_at;
	 
	@OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Privilege> privileges;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHolidays() {
		return holidays;
	}

	public void setHolidays(Date holidays) {
		this.holidays = holidays;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getBanned_at() {
		return banned_at;
	}

	public void setBanned_at(Date banned_at) {
		this.banned_at = banned_at;
	}

	public boolean isOnly() {
		return only;
	}

	public void setOnly(boolean only) {
		this.only = only;
	}

	public int getFailed_login_attemp() {
		return failed_login_attemp;
	}

	public void setFailed_login_attemp(int failed_login_attemp) {
		this.failed_login_attemp = failed_login_attemp;
	}

	public int getSession_per_user() {
		return session_per_user;
	}

	public void setSession_per_user(int session_per_user) {
		this.session_per_user = session_per_user;
	}

	public ERole getErole() {
		return erole;
	}

	public void setErole(ERole erole) {
		this.erole = erole;
	}

	public Egroup getEgroup() {
		return egroup;
	}

	public void setEgroup(Egroup egroup) {
		this.egroup = egroup;
	}

	public Date getJoin_groupe() {
		return join_groupe;
	}

	public void setJoin_groupe(Date join_groupe) {
		this.join_groupe = join_groupe;
	}

	public Long getIdle_time() {
		return idle_time;
	}

	public void setIdle_time(Long idle_time) {
		this.idle_time = idle_time;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	 
	
	 
}
