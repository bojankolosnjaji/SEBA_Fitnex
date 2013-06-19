package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Step extends Model{
	
	
	@ManyToOne(fetch=FetchType.LAZY)	
	public Tutorial tutorial;
	
	public int stepOrder;
	public String title;
	public String content;
	public String image;

}
