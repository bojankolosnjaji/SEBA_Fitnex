import models.User;

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
        System.out.println("Size = " + User.findAll().size());
        
        
        
    }

}
