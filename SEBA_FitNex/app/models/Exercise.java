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
public class Exercise extends Model{
	String title;
	public String content;

	public String image;
	public Date date;
	public int numberOfVotes;
	public double rank;
	
	public ExerciseCategory category;	
	
	public ExerciseLevel level;
    
    @OneToMany(mappedBy="exercise")
    public List<ExerciseComment> comments;
    
    @OneToMany(mappedBy="exercise")
    public List<UserExercisePreference> userPreferences;
    
    public Exercise(String title, String content, String image, Date date,
    		ExerciseCategory category, ExerciseLevel level) {
		super();
		this.title = title;
		this.content = content;
		this.image = image;
		this.date = date;
		this.category = category;
		this.level = level;
		
	}
	
}
