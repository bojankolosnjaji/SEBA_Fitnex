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
public class Excercise extends Model{
	String title;
	public String content;

	public String image;
	public Date date;
	public int numberOfVotes;
	public double rank;
	
	public ExcerciseCategory category;	
	
	public ExcerciseLevel level;
    
    @OneToMany(mappedBy="excercise")
    public List<ExcerciseComment> comments;
    
    @OneToMany(mappedBy="excercise")
    public List<UserPreference> userPreferences;
    
	
	
}
