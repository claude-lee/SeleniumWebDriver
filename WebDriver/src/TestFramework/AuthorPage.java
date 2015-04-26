package TestFramework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorPage {

	
	 @FindBy(css = "html#ng-app.js.no-touch.svg.inlinesvg.svgclippaths.no-ie8compat.ng-scope body div.ng-scope div.ng-scope section.red-diamond-bg.orange-bg.hero.small-text-center div.row.author-header div.small-12.large-10.medium-9.columns.pull-over h1.small-text-center.ng-binding")
     private WebElement authorName;

	 	 
	 public String getAuthorName()
	 {
	     return authorName.getText();
	 }

}
