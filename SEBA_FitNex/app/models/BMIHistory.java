package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class BMIHistory extends Model{
	
	@ManyToOne(fetch = FetchType.LAZY)
    public User user;
	
	public Date date;
	
	public float weight;

}
