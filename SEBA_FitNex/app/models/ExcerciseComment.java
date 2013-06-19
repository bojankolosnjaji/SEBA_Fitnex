package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class ExcerciseComment extends Model{
	
	
	@ManyToOne(fetch=FetchType.LAZY)	
	public Excercise excercise;
	
	@ManyToOne(fetch=FetchType.LAZY)
	public User user;
	
	@ManyToOne
    public ExcerciseComment parent;
    @OneToMany(mappedBy="parent")
    private List<ExcerciseComment> children;
	
    
    public String title;
	public String content;
	public Date date;	

}
