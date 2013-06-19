package controllers;

import play.mvc.Controller;
import models.Tutorial;
import models.User;

public class TutorialController extends Controller {

	public static void show(Tutorial tutorial) {
    	System.out.println("INDEX");
    	if (tutorial==null)
    	{
    		System.out.println("No tutorial");
    		renderTemplate("Application/tutorial.html");
    	}
    	else
    	{
    		System.out.println("tutorial:"+ tutorial.content);
    		renderTemplate("Application/tutorial.html", tutorial);
    	}
    	
    	
    }
	
}
