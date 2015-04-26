package TestFramework;

import org.openqa.selenium.support.PageFactory;

public final class Pages {

  public static HomePage homePage;
  
  public static HomePage getHomePage() 
  { 
	  homePage = new HomePage();
      PageFactory.initElements(Browser.webDriver, homePage);
      return homePage;
  }

}
