package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class ArticleComment extends Model{
	
	
	@ManyToOne(fetch=FetchType.LAZY)	
	public Article article;
	
	@ManyToOne(fetch=FetchType.LAZY)
	public User user;
	
	@ManyToOne
    public ArticleComment parent;
    @OneToMany(mappedBy="parent")
    private List<ArticleComment> children;
	
	public String content;
	public Date date;

}
