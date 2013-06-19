package controllers;
//test
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.Address;
import models.Gender;
import models.User;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index(User signedUser) {
    	System.out.println("INDEX");
    	if (signedUser==null || signedUser.email==null)
    	{
    		System.out.println("No user");
    		renderTemplate("Application/home.html");
    	}
    	else
    	{
    		System.out.println("User signed in");
    		renderTemplate("Application/home.html", signedUser);
    	}
    	
    	
    }
    
    public static void signup(){
    	
    	renderTemplate("Application/registration.html");
    }
   
    public static void signupform(String txtEmail, String txtPassword, String txtFirstName, String txtLastName, String txtDateOfBirth, String txtWeight, String rdGender, String txtStreet, String txtNumber, String txtCity, String txtProvince, String txtCountry, String txtPhoneNumber, String txtMobile, String selPref, String chkAgree){
    	Address address = new Address(txtStreet, txtNumber, txtCity, txtProvince, txtCountry);
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateStr;
		try {
			dateStr = formatter.parse(txtDateOfBirth);
			
			Gender engender;
			if (rdGender.equals("male"))
				engender = Gender.MALE;
			else
				engender = Gender.FEMALE;
			User user = new User(txtEmail, txtPassword, txtFirstName, txtLastName, dateStr, engender, Double.parseDouble(txtWeight), address, txtPhoneNumber, txtMobile);
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
    	System.out.println("Name:" + signedUser.firstName + " " + signedUser.lastName);
    	renderTemplate("Application/index.html", signedUser);       	
    	
    }
    
    public static void signout(String email)
    {
    	renderTemplate("Application/index.html");
    }
    
    


}