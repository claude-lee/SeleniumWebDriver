package selen;

import java.io.File;
import java.net.URL;
import java.security.CodeSource;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.browserlaunchers.locators.GoogleChromeLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import com.thoughtworks.selenium.webdriven.Timer;


public class MyWebDriver {

	WebDriver driver;
	String systemPath;
	
	public MyWebDriver() {
		
	}

	public enum Browser {
		FIREFOX, IE, CHROME
	}

	public enum Html {
		GOOGLE, TEST, TABLETEST
	}

	
	
	public static void main(String[] args) {
		MyWebDriver myDriver = new MyWebDriver();

		myDriver.selectTableXPath();
//      myDriver.selectTableMethod();
//		myDriver.selectDropDownMethod();
//		myDriver.checkBoxMethod();
//		myDriver.radioButtonMethod();
//		myDriver.openChrome(); // problem with opening Images Link
//		myDriver.openFireFox();
//		myDriver.openInternetExplorer();

	}

	

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void openHtml(Html html) {
		switch (html) {
		case GOOGLE:
			driver.get("https://www.google.com");
			break;
		case TEST:
			driver.get("file:///" + systemPath +"/res/html/TestPage.html");
			break;
		case TABLETEST:
			driver.get("file:///" + systemPath +"/res/html/TableTest.html");
			break;
		default:
			System.out.println("HTML not found");
			break;
		}

	}

	
	public void selectTableXPath() {
		this.setup(Browser.CHROME);
		this.openHtml(Html.TABLETEST);
		
	    WebElement row = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
		System.out.println(row.getText());
		
		this.tearDown();
	}
	
	
	public void selectTableMethod() {
		this.setup(Browser.CHROME);
		this.openHtml(Html.TABLETEST);
		
		WebElement outerTable = driver.findElement(By.tagName("table"));
		WebElement innerTable = outerTable.findElement(By.tagName("table"));
	    WebElement row = innerTable.findElements(By.tagName("td")).get(1);
		System.out.println(row.getText());
		
		this.tearDown();
	}
	

	public void selectDropDownMethod() {
		this.setup(Browser.CHROME);
		this.openHtml(Html.TEST);

		WebElement selectBox = driver.findElement(By.id("select1"));
		
		Select select = new Select(selectBox);
		select.selectByVisibleText("Tom");
		//WebElement tomOption = selectBox.findElements(By.tagName("option")).get(2);
		//tomOption.click();
		
		this.tearDown();

	}

	public void checkBoxMethod() {
		this.setup(Browser.CHROME);
		this.openHtml(Html.TEST);
		WebElement checkBox = driver.findElement(By.id("check1"));
		checkBox.click();
		checkBox.click();
		this.tearDown();
	}

	public void radioButtonMethod() {
		this.setup(Browser.CHROME);
		this.openHtml(Html.TEST);

		List<WebElement> radioButtons = driver.findElements(By.name("color"));
		for (int i = 0; i < radioButtons.size(); i++) {
			if (radioButtons.get(i).isSelected()) {
				System.out.println(radioButtons.get(i).getAttribute("value"));
			}
		}
		this.tearDown();
	}

	public void openChrome() {
		this.setup(Browser.CHROME);
		this.openHtml(Html.GOOGLE);

		driver.manage().window().maximize();

		WebElement searchBox = driver.findElement(By.id("lst-ib"));
		searchBox.sendKeys("pluralsight");
		searchBox.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement imageLink = driver.findElement(By.cssSelector("a.vasq.srp")); //By.linkText("url")
		imageLink.click();

		System.out.println("The current URL is " + driver.getCurrentUrl());
		this.tearDown();
	}

	public void openInternetExplorer() {
		this.setup(Browser.IE);
		this.openHtml(Html.GOOGLE);
		driver.manage().window().maximize();

		System.out.println("The current URL is " + driver.getCurrentUrl());
		this.tearDown();
	}

	public void openFireFox() {
		this.setup(Browser.FIREFOX);
		this.openHtml(Html.GOOGLE);

		driver.manage().window().maximize();

		System.out.println("The current URL is " + driver.getCurrentUrl());
		this.tearDown();
	}
	
	public void setup(Browser browser) {
		systemPath = System.getProperty("user.dir").replace("\\", "/");
		 
		File file;
		switch (browser) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case IE:
			file = new File(
					systemPath + "/res/driver/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			break;
		case CHROME:
			file = new File(
					systemPath + "/res/driver/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					file.getAbsolutePath());
			driver = new ChromeDriver();
			break;
		default:
			System.out.print("Browser is not supported");
			break;
		}

	}
	
	public void tearDown(){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
