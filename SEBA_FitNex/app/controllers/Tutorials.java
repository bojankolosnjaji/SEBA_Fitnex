package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Tutorials extends Controller {

	public static void loadTutorial(long id) {
		Tutorial tutorial = Tutorial.findById(id);
		User signedUser=User.convertToUser(Security.session.get("user"));
        renderTemplate("Tutorials/tutorial.html", tutorial,signedUser);
    }

    public static void tutorials() {
    	List<Tutorial> tutorialList= models.Tutorial.find("order by date desc").fetch();
    	
    	if (tutorialList==null || tutorialList.isEmpty())
    	{
        	
    		
    		Tutorial tutorial=new models.Tutorial("Tutorial5", "Content5", null, new Date(), TutorialCategory.MUSCLE, TutorialLevel.BEGINNER).save();
    		new Step(tutorial,1,"Tutorial5", "Step1Content",null).save();
        	new Step(tutorial,2,"Tutorial5", "Step2Content",null).save();
        	new Step(tutorial,3,"Tutorial5", "Step3Content",null).save();
    		new models.Tutorial("Tutorial1", "Content1", null, new Date(), TutorialCategory.MUSCLE, TutorialLevel.BEGINNER).save();
        	new models.Tutorial("Tutorial2", "Content2", null, new Date(), TutorialCategory.NUTRITION, TutorialLevel.EXPERT).save();
        	new models.Tutorial("Tutorial3", "Content3", null, new Date(), TutorialCategory.RESEARCH, TutorialLevel.BEGINNER).save();
        	new models.Tutorial("Tutorial4", "Content4", null, new Date(), TutorialCategory.RESEARCH, TutorialLevel.BEGINNER).save();
        	tutorialList= models.Tutorial.find("order by date desc").fetch();
        	System.out.println(tutorialList.size() + " Tutorial inserted");
    	}
    	System.out.println("Tutorials fetched");
    	User signedUser=User.convertToUser(Security.session.get("user"));
    	render(tutorialList,signedUser);
    }

    public static void tutorials_beginner() {
    	List<Tutorial> tutorialList= models.Tutorial.find("level=? order by date desc", TutorialLevel.BEGINNER).fetch();
    	User signedUser=User.convertToUser(Security.session.get("user"));
    	render(tutorialList,signedUser);
        
    }

    public static void tutorials_intermediate() {
    	List<Tutorial> tutorialList= models.Tutorial.find("level=? order by date desc", TutorialLevel.INTERMEDIATE).fetch();
    	User signedUser=User.convertToUser(Security.session.get("user"));
    	render(tutorialList,signedUser);
    }

    public static void tutorials_expert() {
    	List<Tutorial> tutorialList= models.Tutorial.find("level=? order by date desc", TutorialLevel.EXPERT).fetch();
    	User signedUser=User.convertToUser(Security.session.get("user"));
    	render(tutorialList,signedUser);
    }

}
