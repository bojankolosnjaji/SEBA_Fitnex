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
public class Article extends Model{
	String title;
	public String content;
	
	public String image;
	public Date date;
	public int numberOfVotes;
	public double rank;
	
	public ArticleCategory category;	
	
	public ArticleLevel level;
	
	@ManyToMany
	  @JoinTable(
	      name="ARTICLE_RELATION",
	      joinColumns={@JoinColumn(name="ART_RELATEE_ID", referencedColumnName="ID")},
	      inverseJoinColumns={@JoinColumn(name="ART_RELATER_ID", referencedColumnName="ID")})
    public List<Article> relatedArticles;
    
    @OneToMany(mappedBy="article")
    public List<ArticleComment> comments;
	
	
}
