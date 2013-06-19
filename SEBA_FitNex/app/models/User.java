package models;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Unique;
import play.db.jpa.GenericModel;
 
@Entity
public class User extends GenericModel {
	@Id @GeneratedValue (strategy = GenerationType.SEQUENCE) 
	public Long id;
	
	@Unique
    public String email;
	
    public String password;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public Gender gender;
    public double weight;
    public Date joinDate;
    
    @OneToMany(mappedBy="user")
    public List<ArticleComment> articleComments;
    
    @OneToMany(mappedBy="user")
    public List<TutorialComment> tutorialComments;
    
    @OneToMany(mappedBy="user")
    public List<ExerciseComment> exerciseComments;
    
    @OneToMany(mappedBy="exercise")
    public List<UserExercisePreference> userExercisePreferences;
    
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
	public User(String email, String password, String firstName,
			String lastName, Date dateOfBirth, Gender gender, double weight,
			Address address, String phone, String mobile) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.weight = weight;
		this.joinDate = new Date();
		this.articleComments = new ArrayList<ArticleComment>();
		this.tutorialComments = new ArrayList<TutorialComment>();
		this.exerciseComments = new ArrayList<ExerciseComment>();
		this.userExercisePreferences = new ArrayList<UserExercisePreference>();
		this.BMIHistoryList= new ArrayList<BMIHistory>();
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;	
		
		System.out.println(email  + "" + password + " " + firstName + " " + lastName + "" + dateOfBirth + " " + gender + " "  + weight + joinDate);
		
	}
	
}