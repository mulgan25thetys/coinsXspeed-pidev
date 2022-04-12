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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user")

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="user_name")
	private String userName;
		
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	 
	@Enumerated(EnumType.STRING)
	private StLevel level;
	
	@Enumerated(EnumType.STRING)
	private SocialSituation situation;
	
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
	 private Egroup egroup;
	 
	 @Enumerated(EnumType.STRING)
	 private Status status;
	 
	  @Temporal(TemporalType.DATE)
	 private Date join_groupe;
	 
	 private Long idle_time;
	 
	 @Temporal(TemporalType.DATE)
	 private Date created_at;
	 
	@OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL)
	private List<Privilege> privileges;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<NoFinancialService> usernoservice;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	private Account account;
	
	@ManyToOne
	private ScoreForm scoreform;
	
	@ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
	private List<Communication> communication;
	
	@ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
	private List<Notification> notifications;
	
	@OneToMany(mappedBy = "user")
	private List<Claim> claim ;
		
	public User(Long userId, String userName, String password, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}


	public User( Long userId,String userName, String password) {
		super();
	
		this.userName = userName;
		this.password = password;
		this.userId=userId;
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		
		if(obj==null || !(obj instanceof User) )
			return false;
		return this.userId==((User)obj).getUserId();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public StLevel getLevel() {
		return level;
	}

	public void setLevel(StLevel level) {
		this.level = level;
	}

	public SocialSituation getSituation() {
		return situation;
	}

	public void setSituation(SocialSituation situation) {
		this.situation = situation;
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

	public Egroup getEgroup() {
		return egroup;
	}

	public void setEgroup(Egroup egroup) {
		this.egroup = egroup;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public Set<NoFinancialService> getUsernoservice() {
		return usernoservice;
	}

	public void setUsernoservice(Set<NoFinancialService> usernoservice) {
		this.usernoservice = usernoservice;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public ScoreForm getScoreform() {
		return scoreform;
	}

	public void setScoreform(ScoreForm scoreform) {
		this.scoreform = scoreform;
	}

	public List<Communication> getCommunication() {
		return communication;
	}

	public void setCommunication(List<Communication> communication) {
		this.communication = communication;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Claim> getClaim() {
		return claim;
	}

	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
	



	
	
	
}
