package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	/**
	 * 
	 * @param element
	 * @see Method used to handle the explicit wait and it will wait until the element found.
	 */
	public void elementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * 
	 * @return byte[]
	 * @see Method  used to take screenshot
	 */
	public byte[] screenshot() {
		TakesScreenshot screenshot =(TakesScreenshot)driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
		
	}
	/**
	 * 
	 * @param key
	 * @return value
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see Method used to get the value from the property file 
	 */
public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		
	Properties properties = new Properties();
		
	properties.load(new FileInputStream(System.getProperty("user.dir")+
				"\\Config\\config.properties"));
		
	String value =(String)properties.get(key);
		return value;
		
	}
	/**
	 * 
	 * @param browserType
	 * @see Method used to launch the browser based on the browser type
	 */
	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			//WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(co);
			break;
		case "firefox":
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break; 
		case "ie":
			//WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		default:
			break;
		}
	}
	/**
	 * 
	 * @param url
	 * @see Method used for get url to launch the webpage
	 */
		
		public  static void enterURL(String url) {
		driver.get(url);
	}
		/**
		 * @see Method used to maximizing the window
		 */
	public static void maximizewindow() {//3
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param element
	 * @param data
	 * @see Method used to inserting the values in textbox
	 * 
	 */
	public void elementSendkeys(WebElement element,String data) {
		elementVisibility(element);
		clear(element);
		element.sendKeys(data);
	}
	/**
	 * 
	 * @param element
	 * @param data
	 * @see Method used to inserting the values in textbox using javascript
	 */
	public void elementSendkeysJS(WebElement element,String data) {
		elementVisibility(element);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('value',"+ data+")",element);
	}
	/**
	 * 
	 * @param element
	 * @see Method used to click the button
	 */
	public void elementClick(WebElement element) {
		elementVisibility(element);
		element.click();
	}
	public void elementClick1(WebElement element) {
		elementVisibility(element);
		element.sendKeys(Keys.ENTER);
	}
	/**
	 * 
	 * @param String
	 * @return text
	 * @see Method used to get the text from the webpage
	 */
	public String getText(WebElement element) {
		elementVisibility(element);
		String text = element.getText();
		return text;
	}
	/**
	 * 
	 * @param attributevalue
	 * @return WebElement
	 * @see Method  used to findelement by using Id
	 */
	public WebElement findLocatorById(String attributevalue) {//8
	
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}
	/**
	 * 
	 * @param attributevalue
	 * @return WebElement
	 * @see Method  used to findelement by using name
	 */
	public WebElement findLocatorByName(String attributevalue) {//9
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}
	/**
	 * 
	 * @param attributevalue
	 * @return WebElement
	 * @see Method used to findelement by using classname
	 */
	public WebElement findLocatorByclassName(String attributevalue) {//10
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}
	/**
	 * 
	 * @param attributevalue
	 * @return WebElement
	 * @see Method used to findelement by using xpath
	 */
	
	public WebElement findLocatorByXpath(String xpath) {//10
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	/**
	 * @see Method  used to closing current window
	 */
	public void windowclosed() {
		driver.close();
	}
	/**
	 * @see Method  used to closing all windows
	 */
	public static void quit() {
		driver.quit();
	}
	/**
	 * 
	 * @return String
	 * @see Method  used to fetch title from the web page
	 */
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	/**
	 * 
	 *  @return String
	 *  @see Method  used to fetch url from  the web page
	 */
	
	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	/**
	 *  
	 * @param id
	 * @return String
	 * @see Method  used to get the attribute value of the given attribute
	 */
	
		public String elementGetAttributeValue(WebElement element) {
			elementVisibility(element);
			String attribute = element.getAttribute("value");
			return attribute;
		}

	/**
	 * 
	 * @param data
	 * @see Method  used to select the option by visible text  in dropdown
	 */
	
	public void selectByText(WebElement element,String text) {//17
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * 
	 * @param data
	 * @see Method  used to select the option by  value  in dropdown
	 */
	public void selectByvalue(WebElement element,String value) {//18
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * 
	 * @param data
	 * @see Method  used to select the option by index in dropdown
	 */
	
	public void selectByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * 
	 * @param data
	 * @return List<WebElement>
	 * @see Method  used to fetch the alltOptions in dropdown
	 */
	
	public List<WebElement> getOptions(WebElement element) {
		Select s = new Select(element);
List<WebElement> options = s.getOptions();
return options;
	}
	/**
	 * 
	 * @param data
	 * @return List<WebElement>
	 * @see Method used to get all selected options  in dropdown
	 */
	
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
List<WebElement> options = s.getAllSelectedOptions();
return options;
	}
	/**
	 * 
	 * @param data
	 * @return WebElement
	 * @see Method  used to get firstselected Options in dropdown
	 */
	
	public WebElement getFirstSelectedOptions(WebElement element) {
		Select s = new Select(element);
  WebElement firstSelectedOption = s.getFirstSelectedOption();
return firstSelectedOption;
	}
	/**
	 * 
	 * @param data
	 * @see Method  used to deselect all option in dropdown 
	 */
	
	public void deSelectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}
	/**
	 * 
	 * @param data
	 * @see Method used to deselect the options by using index in dropdown
	 */
	
	public void deSelectBtIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	/**
	 * 
	 * @param data
	 * @see Method used to deselect the option by using visible text in dropdown
	 */
	
	public void deSelectByVisibleText(WebElement element,String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
	/**
	 * 
	 * @param data
	 * @see Method  used to deselect the option by using value in dropdown
	 */
	
	public void deSelectByValue(WebElement element,String value ) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}
	
	
	
	/**
	 * 
	 * @param data
	 * @see Method used to accept the alert
	 */
	public void accept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	/**
	 * 
	 * @param data
	 * @see Method used to dismiss the alert
	 */
	public void dismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	/**
	 * 
	 * @param data
	 * @see Method used to insert value in alert text box
	 */
	public void sendKeysToiInsertValue(String data) {//36
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
	}
	
/**
	 * 
	 * @param element
	 * @return String
	 * @see Method used to get the input what we have passed 
	 */
	public String getAttribute(WebElement element) {
		
		elementVisibility(element);
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		return attribute;
}
	/**
	 * 
	 * @param value
	 * @see Method used to avoid time out exception
	 */
	public static void implicitlyWaits(int value) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));

	}
	/**
	 * 
	 * @param element
	 * @see Method used to clear the text boxes
	 */
	public void clear(WebElement element) {
		elementVisibility(element);
		element.clear();
	}
	public void clear1(WebElement element) {
		elementVisibility(element);
		element.clear();
	}
	

}
