package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.Address;
import models.User;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void signup(){
    	render();
    }
   
    public static void signupform(String email, String password, String fullname, String dateOfBirth, String street, String number, String city, String province, String country, String phonenumber, String mobile){
    	Address address = new Address(street, phonenumber, city, province, country);
    	address.save();
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateStr;
		try {
			dateStr = formatter.parse(dateOfBirth);
			User user = new User(email, password, fullname, dateStr, address, phonenumber, mobile);
			user.save();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	index();
    }

}