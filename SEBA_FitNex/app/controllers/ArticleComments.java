package controllers;

import java.util.Date;

import models.Article;
import models.ArticleComment;
import models.User;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class ArticleComments extends Controller{
	
	public static void addComment(long id, String txtComment)
	{
		String email = Security.connected();
		System.out.println("Looking for email... " + email);
		User user = (User) User.find("byEmail", email).first();
		if (user==null)
		{
			Application.index(null);
		}
		System.out.println("User:" + user.firstName);
		Article article = Article.findById(id);
		System.out.println("Article: "+ article.content);
		ArticleComment comment = new ArticleComment(article, user, null, null, "", txtComment, new Date());
		comment.save();
		Articles.loadArticle(article.getId());
		
	}

}
