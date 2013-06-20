package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.With;


@With(Secure.class)
public class BMIHistoryController extends Controller{
	
	public static void bmihistory(User signedUser)
	{
		
	}

}
