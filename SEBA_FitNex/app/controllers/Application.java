package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.Address;
import models.User;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index(User signedUser) {
    	System.out.println("INDEX");
    	if (signedUser==null || signedUser.email==null)
    	{
    		System.out.println("No user");
    		render();
    	}
    	else
    	{
    		System.out.println("User signed in");
    		render(signedUser);
    	}
    }
    
    public static void signup(){
    	
    	render();
    }
   
    public static void signupform(String email, String password, String fullname, String dateofbirth, String street, String number, String city, String province, String country, String phonenumber, String mobile){
    	Address address = new Address(street, phonenumber, city, province, country);
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateStr;
		try {
			dateStr = formatter.parse(dateofbirth);
			User user = new User(email, password, fullname, dateStr, address, phonenumber, mobile);
			System.out.println("E-mail: " + user.email);
			address.save();
			user.save();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	index(null);
    }
    
    public static void signinform(String email, String password){
    	System.out.println("Sign in form" + email);
    	
    	User signedUser = User.findById(email);
    	System.out.println("Name:" + signedUser.fullname);
    	renderTemplate("Application/index.html", signedUser);       	
    	
    }
    
    public static void signout(String email)
    {
    	renderTemplate("Application/index.html");
    }


}