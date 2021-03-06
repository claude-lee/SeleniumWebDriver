package selen;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import selen.WebDriverHelper.*;

public class MyWebDriver {

	private WebDriver driver;
	private String systemPath;

	public static void main(String[] args) {

		// mainLocal();

		mainServer();

	}

	public static void mainLocal() {
		MyWebDriver myDriver = new MyWebDriver();

		myDriver.openChromeExplicitWaitElemToBeClickable();

		myDriver.selectTableXPathChrome();
		myDriver.openChromeExplicitWaitVisOfElemLocated();
		myDriver.selectTableXPathChrome();
		myDriver.selectDropDownMethod();
		myDriver.clickAndUnclickCheckBox();
		myDriver.printSelectedRadioButton();
		myDriver.clickImagesImplicitWaitFirefox();
		myDriver.openFireFox();
		myDriver.openInternetExplorer();

	}

	public static void mainServer() {
		MyWebDriver myDriver = new MyWebDriver();
		myDriver.openFireFoxLocal();
	}

	public void openFireFoxLocal() {
		this.setup(Browser.LOCAL);
		this.openHtml(Html.GOOGLE);

		driver.manage().window().maximize();

		System.out.println("The current URL is " + driver.getCurrentUrl());
		// this.tearDown();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void openChromeExplicitWaitElemToBeClickable() {
		this.setup(Browser.FIREFOX);
		openHtml(Html.GOOGLE);

		driver.manage().window().maximize();

		WebElement searchBox = driver.findElement(By.id("lst-ib"));
		searchBox.clear();
		searchBox.sendKeys("pluralsight");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement imageLink = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a.q.qs")));
		imageLink.click();

		System.out.println("The current URL is " + driver.getCurrentUrl());
		this.tearDown();
	}

	public void openChromeExplicitWaitVisOfElemLocated() {
		this.setup(Browser.FIREFOX);
		openHtml(Html.GOOGLE);

		driver.manage().window().maximize();

		WebElement searchBox = driver.findElement(By.id("lst-ib"));
		searchBox.clear();
		searchBox.sendKeys("pluralsight");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement imageLink = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a.q.qs")));
		imageLink.click();

		System.out.println("The current URL is " + driver.getCurrentUrl());
		this.tearDown();
	}

	public void clickImagesImplicitWaitFirefox() {
		this.setup(Browser.FIREFOX);
		this.openHtml(Html.GOOGLE);

		driver.manage().window().maximize();

		WebElement searchBox = driver.findElement(By.id("lst-ib"));
		searchBox.clear();
		searchBox.sendKeys("pluralsight");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement images = driver.findElement(By.cssSelector("a.q.qs"));
		images.click();

		System.out.println("The current URL is " + driver.getCurrentUrl());
		this.tearDown();
	}

	public void selectTableXPathChrome() {
		this.setup(Browser.CHROME);
		this.openHtml(Html.TABLETEST);

		WebElement row = driver.findElement(By
				.xpath("/html/body/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
		System.out.println(row.getText());

		this.tearDown();
	}

	public void selectInnerOuterTable() {
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
		// WebElement tomOption =
		// selectBox.findElements(By.tagName("option")).get(2);
		// tomOption.click();

		this.tearDown();

	}

	public void clickAndUnclickCheckBox() {
		this.setup(Browser.CHROME);
		this.openHtml(Html.TEST);
		WebElement checkBox = driver.findElement(By.id("check1"));
		checkBox.click();
		checkBox.click();
		this.tearDown();
	}

	public void printSelectedRadioButton() {
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
			file = new File(systemPath + "/res/driver/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			break;
		case CHROME:
			file = new File(systemPath + "/res/driver/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					file.getAbsolutePath());
			driver = new ChromeDriver();
			break;
		case LOCAL:
			try {
				// driver = new RemoteWebDriver(new
				// URL("http://127.0.0.1:4444/wd/hub"),
				// DesiredCapabilities.firefox());
				driver = new RemoteWebDriver(
						new URL("http://127.0.0.1:4444/wd/hub"),
						new DesiredCapabilities("firefox", "", Platform.WINDOWS));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("oh oh");
			}
			break;
		default:
			System.out.print("Browser is not supported");
			break;
		}

	}

	public void openHtml(Html html) {
		switch (html) {
		case GOOGLE:
			driver.get("https://www.google.com/");
			break;
		case TEST:
			driver.get("file:///" + systemPath + "/res/html/TestPage.html");
			break;
		case TABLETEST:
			driver.get("file:///" + systemPath + "/res/html/TableTest.html");
			break;
		default:
			System.out.println("HTML not found");
			break;
		}

	}

	public void tearDown() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
