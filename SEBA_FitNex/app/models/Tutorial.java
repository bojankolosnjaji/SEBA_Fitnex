package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Tutorial extends Model{
	String title;
	public String content;

	public String image;
	public Date date;
	public int numberOfVotes;
	public double rank;
	
	public TutorialCategory category;	
	
	public TutorialLevel level;
    
    @OneToMany(mappedBy="tutorial")
    public List<TutorialComment> comments;
    
   
    @OneToMany(mappedBy="tutorial")
    
    public List<Step> steps;
    
    public Tutorial(String title, String content, String image, Date date,
    		TutorialCategory category, TutorialLevel level) {
		super();
		this.title = title;
		this.content = content;
		this.image = image;
		this.date = date;
		this.category = category;
		this.level = level;
		
		steps=Step.find("tutorial_id=? order by stepOrder desc", this.id).fetch();
	}
    
    public Tutorial(String title, String content, String image, Date date,
    		TutorialCategory category, TutorialLevel level,List<Step> steps) {
		super();
		this.title = title;
		this.content = content;
		this.image = image;
		this.date = date;
		this.category = category;
		this.level = level;
		
		this.steps = steps;
	}
	
	
}
