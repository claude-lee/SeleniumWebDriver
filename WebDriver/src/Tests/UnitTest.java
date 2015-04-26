package Tests;

import org.junit.*;
import static org.junit.Assert.*;
import TestFramework.Browser;
import TestFramework.Pages;

public class UnitTest {

	@Test
	public void canGoToHomePage() {
		Pages.getHomePage().goToUrl();
		assertTrue(Pages.getHomePage().isAt());

	}

	@Test
	public void canGoToAuthorPage() {
		Pages.getHomePage().goToUrl();
		Pages.getHomePage().selectAuthor("Matt Milner");
	    assertTrue(Pages.getHomePage().isAtAuthorPage("Matt Milner"));
	}
	
	@AfterClass
	public static void tearDown(){
		Browser.quit();
	}

}
