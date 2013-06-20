import java.util.Date;

import models.Article;
import models.ArticleCategory;
import models.ArticleLevel;

import org.eclipse.jdt.internal.compiler.ast.FakedTrackingVariable;
import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

public class BasicTest extends UnitTest {
    
	@Before
	public void setUp() {
		    Fixtures.deleteAll();
	}
	
	
    @Test
    public void clearDatabase() {
        //Fixtures.executeSQL("CLEAR DATABASE");
    }
    
    @Test
    public void insertArticles(){
    	
    }

}
