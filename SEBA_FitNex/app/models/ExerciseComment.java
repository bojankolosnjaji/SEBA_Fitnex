package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class ExerciseComment extends Model{
	
	
	@ManyToOne(fetch=FetchType.LAZY)	
	public Exercise exercise;
	
	@ManyToOne(fetch=FetchType.LAZY)
	public User user;
	
	@ManyToOne
    public ExerciseComment parent;
    @OneToMany(mappedBy="parent")
    private List<ExerciseComment> children;
	
    
    public String title;
	public String content;
	public Date date;	

}
