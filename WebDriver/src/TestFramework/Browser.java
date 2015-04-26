package TestFramework;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Browser {

	static WebDriver webDriver = new FirefoxDriver();

	public static void goToUrl(String url) {
		webDriver.get(url);
	}

	public static String getTitle() {
		return webDriver.getTitle();
	}

	public static SearchContext Driver() {
		return webDriver;
	}

	public static void quit() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.quit();
	}

}
