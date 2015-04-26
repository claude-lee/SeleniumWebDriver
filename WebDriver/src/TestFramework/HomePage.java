package TestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private static String url = "http://pluralsight.com";
	private static String pageTitle = "Pluralsight – Hardcore Developer and IT Training";

	@FindBy(linkText = "Authors")
	private WebElement authorLink;

	public void goToUrl() {
		Browser.goToUrl(url);
	}

	public boolean isAt() {
		return Browser.getTitle().equals(pageTitle);
	}

	public void selectAuthor(String authorName) {
		authorLink.click();
		WebElement author = Browser.webDriver.findElement(By
				.linkText(authorName));
		author.click();
	}

	public boolean isAtAuthorPage(String authorName) {
		AuthorPage authorPage = new AuthorPage();
		PageFactory.initElements(Browser.webDriver, authorPage);
		return authorPage.getAuthorName().equals(authorName);
	}

}
