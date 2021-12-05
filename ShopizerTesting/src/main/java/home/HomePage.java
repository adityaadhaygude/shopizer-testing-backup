package home;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HomePage {
	WebDriver driver;
	ConfigFileReader objConfigFileReader;
	
	By homePageImage = By.cssSelector(".image-content > img");
	By frenchXpath = By.xpath("//a/span ");
	By frenchBtn = By.linkText("French");
	By englishBtn = By.linkText("Anglais");
	By englishXpath = By.linkText("Page d\'accueil");
	By homeBtn = By.linkText("Home");
	By products = By.linkText("Products");
	By handBags = By.linkText("Handbags");
	By myAccount = By.xpath("//li[2]/a/span");
	By signInBtn = By.partialLinkText("Sign");
	By registerBtn = By.linkText("Register");
	By cartBtn = By.xpath("//li[3]/a/span");
	By productName = By.cssSelector(".col-md-3:nth-child(1) h3");
	By originalPrice = By.cssSelector("del");
	By discountedPrice = By.cssSelector(".specialPrice");
	By beachBags = By.partialLinkText("Beach");
	By laptopBags = By.partialLinkText("Laptop");
	By bags = By.linkText("Bags");
	By email = By.xpath("//strong[contains(.,'john@test.com')]");
	By phone = By.xpath("//strong[contains(.,'888-888-8888')]");
	By registerPageText = By.cssSelector(".login-title:nth-child(1) > h3");
	By signInPageText = By.cssSelector(".col-lg-6:nth-child(1) h3");

	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public void assertTitle(){
		objConfigFileReader = new ConfigFileReader();
		assertThat(getHomePageTitle(), is(objConfigFileReader.getString("homeTitle")));
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.presenceOfElementLocated(homePageImage));
		}
	}
	
	public void assertHomePageImage() {
		List<WebElement> elements =  driver.findElements(homePageImage);
		assert(elements.size() > 0);
	}
	
	public void mouseHoverOnElement(By elementName) {
		WebElement element = getWebElement(elementName);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
	}
	
	public void clickBtn(By elementName) {
		getWebElement(elementName).click();
	}
	
	public void getTextAndAssert(By elementName,String stringName) {
		 assertThat(getWebElement(elementName).getText(),is(objConfigFileReader.getString(stringName)));
	}
	
	public String verifyCssProperty(By elementName,String propertyName) {
		String cssPropertyText = getWebElement(elementName).getCssValue(objConfigFileReader.getString(propertyName));
		return cssPropertyText;	
	}
	
	public WebElement getWebElement(By elementName) {
		return driver.findElement(elementName);
	}
	
	public Boolean isClickEnabled(By elementName) {
		return getWebElement(elementName).isEnabled();
	}
}
