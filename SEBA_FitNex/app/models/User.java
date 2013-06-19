package models;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Unique;
import play.db.jpa.Model;
 
@Entity
public class User extends Model {
	
	@Unique
    public String email;
	
    public String password;
    public String fullname;
    public Date dateOfBirth;
    public Gender gender;
    public double weight;
    public Date joinDate;
    
    @OneToMany(mappedBy="user")
    public List<ArticleComment> comments;
    
    @OneToMany(mappedBy="user")
    public List<TutorialComment> comments;
    
    @OneToMany(mappedBy="user")
    public List<ExcerciseComment> comments;
    
    @OneToMany(mappedBy="excercise")
    public List<UserPreference> userExcercisePreferences;
    
    @OneToMany(mappedBy="user")
    public List<BMIHistory> BMIHistoryList;
    
    @OneToOne
    @JoinColumn(name="address_id", referencedColumnName="id") 
    public Address address;
    public String phone;
    public String mobile;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, String password, String fullname,
			Date dateOfBirth, Gender gender, double weight,
			Address address, String phone, String mobile) {
		super();
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.weight = weight;
		this.joinDate = new Date();
		this.comments = new ArrayList<ArticleComment>();
		this.BMIHistoryList= new ArrayList<BMIHistory>();
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;
	}
	
}