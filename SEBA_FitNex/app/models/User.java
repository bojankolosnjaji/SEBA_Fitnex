package models;
 
import java.util.*;

import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class User extends Model {
 
    public String email;
    public String password;
    public String fullname;
    public Date dateOfBirth;
    
    @OneToOne
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