package Tests;

import org.junit.*;

import static org.junit.Assert.*;
import TestFramework.Browser;
import TestFramework.LoginPage;
import TestFramework.Pages;

public class UnitTest extends BaseTest{

	@Test
	public void canGoToHomePage() {
		Pages.getHomePage().goToUrl();
		assertTrue(Pages.getHomePage().isAt());

	}
	
	@Test
	public void adminUserCanLogin(){
		LoginPage.GoTo();
		LoginPage.LoginAs("admin").WithPassword("psswrd").Login();
		assertTrue("admin", DashboardPage.isAt());	
	}

	@Test
	public void canGoToAuthorPage() {
		Pages.getHomePage().goToUrl();
		Pages.getHomePage().selectAuthor("Matt Milner");
	    assertTrue(Pages.getHomePage().isAtAuthorPage("Matt Milner"));
	}
	
	

}
