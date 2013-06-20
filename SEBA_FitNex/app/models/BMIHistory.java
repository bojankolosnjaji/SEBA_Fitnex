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
	
	public float height;
	
	public float BMIValue;

	public BMIHistory(User user, Date date, float weight, float height,
			float bMIValue) {
		super();
		this.user = user;
		this.date = date;
		this.weight = weight;
		this.height = height;
		BMIValue = bMIValue;
	}

	
	
	

}
