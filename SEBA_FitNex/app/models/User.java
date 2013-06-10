package models;
 
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.db.jpa.GenericModel;
 
@Entity
public class User extends GenericModel {
	
	@Id
    public String email;
	
    public String password;
    public String fullname;
    public Date dateOfBirth;
    
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
			Date dateOfBirth, Address address, String phone, String mobile) {
		super();
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;
	}
    
}