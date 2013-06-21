package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Tutorials extends Controller {

	public static void loadTutorial(long id) {
		Tutorial tutorial = Tutorial.findById(id);
        renderTemplate("Tutorials/tutorial.html", tutorial);
    }

    public static void tutorials() {
    	List<Tutorial> tutorialList= models.Tutorial.find("order by date desc").fetch();
    	if (tutorialList==null || tutorialList.isEmpty())
    	{
    		models.Step step1=new models.Step(1,"Tutorial1", "Step1Content",null).save();
    		models.Step step2=new models.Step(2,"Tutorial1", "Step2Content",null).save();
    		models.Step step3=new models.Step(3,"Tutorial1", "Step3Content",null).save();
    		
    		List<Step> steps=new ArrayList<Step>();
    		steps.add(step1);
    		steps.add(step2);
    		steps.add(step3);
    		
    		new models.Tutorial("Tutorial1", "Content1", null, new Date(), TutorialCategory.MUSCLE, TutorialLevel.BEGINNER, steps).save();
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
