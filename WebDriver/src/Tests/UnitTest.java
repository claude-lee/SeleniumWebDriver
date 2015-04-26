package Tests;
import org.junit.*;

import TestFramework.Browser;
import TestFramework.HomePage;
import TestFramework.Pages;

public class UnitTest {
	
//            @Test
//            public void canGoToHomePage()
//            {
//                Pages.getHomePage().goToUrl();
//                Assert.assertTrue(Pages.getHomePage().isAt());
//            		
//            }

            @Test
            public void canGoToAuthorPage()
            {
                Pages.getHomePage().goToUrl();
                Pages.getHomePage().selectAuthor("Matt Milner");
                Assert.assertTrue(Pages.getHomePage().isAtAuthorPage("Matt Milner"));
            }

            @After
            public void cleanUp()
            {
                Browser.close();
            }

}
