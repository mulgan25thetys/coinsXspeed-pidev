package horizure.micro.finance.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "NoFinancialService")
public class NoFinancialService implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_NoFinancialService")
	
	  private int id;
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TypeCat getCategory() {
		return category;
	}
	public void setCategory(TypeCat category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public TypeAct getActivityType() {
		return activityType;
	}
	public void setActivityType(TypeAct activityType) {
		this.activityType = activityType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public TypeCont getContentType() {
		return contentType;
	}
	public void setContentType(TypeCont contentType) {
		this.contentType = contentType;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	public int getNbr_views() {
		return nbr_views;
	}
	public void setNbr_views(int nbr_views) {
		this.nbr_views = nbr_views;
	}
	public int getNbr_like() {
		return nbr_like;
	}
	public void setNbr_like(int nbr_like) {
		this.nbr_like = nbr_like;
	}
	public int getNbr_unlike() {
		return nbr_unlike;
	}
	public void setNbr_unlike(int nbr_unlike) {
		this.nbr_unlike = nbr_unlike;
	}
	public String getBeneficiaries() {
		return beneficiaries;
	}
	public void setBeneficiaries(String beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	public String getTrainers() {
		return trainers;
	}
	public void setTrainers(String trainers) {
		this.trainers = trainers;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Enumerated(EnumType.STRING)
	private TypeCat category;
	  private String title;
	  
	@Enumerated(EnumType.STRING)
	  private TypeAct activityType;
	  private String content;
	  
	  @Enumerated(EnumType.STRING)
	  private TypeCont contentType;
	  private String slug;
	  private String image;
	  private boolean published;
	  private int nbr_views;
	  private int nbr_like;
	  private int nbr_unlike;
	  private String beneficiaries;
	  private String trainers;
	  private double price;
	  @Temporal(TemporalType.DATE)
	  private Date start_date;
	  @Temporal(TemporalType.DATE)
	  private Date end_date;
	  @Temporal(TemporalType.DATE)
	  private Date created_at;
	  @Temporal(TemporalType.DATE)
	  private Date updated_at;
	  
	  @ManyToMany(mappedBy="usernoservice", cascade = CascadeType.ALL)
	  private Set<User> users;
	  
	  @OneToMany(cascade = CascadeType.ALL, mappedBy="nofinancialservices")
	  private Set<Comment> Comments;
	

}
