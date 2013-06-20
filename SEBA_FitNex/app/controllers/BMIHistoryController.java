package controllers;

import java.util.Date;

import models.BMIHistory;
import models.User;
import play.mvc.Controller;
import play.mvc.With;


@With(Secure.class)
public class BMIHistoryController extends Controller{
	
	public static void bmihistoryadd(String weight, String height, String bmivalue)
	{
		String email = Security.connected();
		User user = (User) User.find("byEmail", email).fetch();
		BMIHistory history = new BMIHistory(user, new Date(), Float.parseFloat(weight), Float.parseFloat(height), Float.parseFloat(bmivalue));
		history.save();
	}
	
	public static void bmihistory()
	{
		String email = Security.connected();
		User user = (User) User.find("byEmail", email).first();
		if (user!=null)
			renderTemplate("Application/bmi_history.html", user.BMIHistoryList);		
	}

}
