package home;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeTest {
	WebDriver driver;
	HomePage objHomePage;
	ConfigFileReader objConfigFileReader;
	
//	@Test
//	public void verifyTranslator() {
//		objHomePage = new HomePage(driver);
//		
//		Log.info("Test Case : Translating webpage from english to french and viceversa");
//		
//		Log.info("Asserted home page title");
//		objHomePage.assertTitle();
//		
//		Log.info("Asserted image present on the home page");
//		objHomePage.assertHomePageImage();
//		
//		Log.info("Mouse hovered on English button");
//		objHomePage.mouseHoverOnElement(objHomePage.frenchXpath);
//		
//		Log.info("Clicked on the french button to translate the page into french");
//		objHomePage.clickBtn(objHomePage.frenchBtn);
//		
//		Log.info("Asserted french text of home");
//		objHomePage.getTextAndAssert(objHomePage.englishXpath,"homeInFrench");
//		
//		Log.info("Successfully translated webpage from english to french and asserted");
//		
//		Log.info("Mouse hovered on French button");
//		objHomePage.mouseHoverOnElement(objHomePage.frenchXpath);
//		
//		Log.info("Clicked on the english button to translate the page into english");
//		objHomePage.clickBtn(objHomePage.englishBtn);
//		
//		Log.info("Asserted home text in english");
//		objHomePage.getTextAndAssert(objHomePage.homeBtn, "homeInEnglish");
//		
//		Log.info("Successfully translated webpage from french to english and asserted");
//	}
//	
//	@Test
//	public void verifyMouseHoverEffect() {
//		objHomePage = new HomePage(driver);
//		Log.info("Test Case : Verifying mouse hover effect on products, myaccount and cart");
//
//		Log.info("Asserted home page title");
//		objHomePage.assertTitle();
//		
//		Log.info("Asserted image present on the home page");
//		objHomePage.assertHomePageImage();
//		
//		Log.info("Mouse hovered on products button");
//		objHomePage.mouseHoverOnElement(objHomePage.products);
//		
//		Log.info("Asserted handbags text in products dropdown menu");
//		objHomePage.getTextAndAssert(objHomePage.handBags, "handbags");
//		
//		Log.info("Mouse hovered on English button");
//		objHomePage.mouseHoverOnElement(objHomePage.frenchXpath);
//		
//		Log.info("Asserted french text in the English button dropdown menu");
//		objHomePage.getTextAndAssert(objHomePage.frenchBtn, "frenchBtnText");
//		
//		Log.info("Mouse hovered on my account button");
//		objHomePage.mouseHoverOnElement(objHomePage.myAccount);
//		
//		Log.info("Asserted signin button text in myaccount dropdown menu");
//		objHomePage.getTextAndAssert(objHomePage.signInBtn, "signInBtnText");
//		
//		Log.info("Mouse hovered on cart button");
//		objHomePage.mouseHoverOnElement(objHomePage.cartBtn);
//	}
	
//	@Test
//	public void verifyDiscountedPriceAndColor() {
//		objHomePage = new HomePage(driver);
//		Log.info("Test Case : Verifying discounted price is visible in the red color");
//		
//		Log.info("Asserted home page title");
//		objHomePage.assertTitle();
//		
//		Log.info("Asserted image present on the home page");
//		objHomePage.assertHomePageImage();
//		
//		Log.info("Asserted product name present on the home page");
//		objHomePage.getTextAndAssert(objHomePage.productName, "productTitle");
//		
//		Log.info("Asserted original price of the product");
//		objHomePage.getTextAndAssert(objHomePage.originalPrice, "productOriginalPrice");
//		
//		Log.info("Asserted discounted price of the product");
//		objHomePage.getTextAndAssert(objHomePage.discountedPrice, "productDiscountedPrice");
//		
//		String discountedPriceColor = objHomePage.verifyCssProperty(objHomePage.discountedPrice,"bagProperty");
//		if(discountedPriceColor.equals("rgba(255, 0, 0, 1)")) {
//			Log.info("Discounted price is visible in the red color");
//		}
//	}
	
	@Test
	public void verifyHyperLinks() {
		objHomePage = new HomePage(driver);
		Log.info("Test Case : Verifying all the hyperlinks working coorectly");
		
		Log.info("Asserted home page title");
		objHomePage.assertTitle();
		
		Log.info("Asserted image present on the home page");
		objHomePage.assertHomePageImage();
		
		Log.info("Mouse hovered on products button");
		objHomePage.mouseHoverOnElement(objHomePage.products);
		
		Log.info("Clicked on HandBags button");
		objHomePage.clickBtn(objHomePage.handBags);
		
		Log.info("Mouse hovered on products button");
		objHomePage.mouseHoverOnElement(objHomePage.products);
		
		Log.info("Clicked on BeachBags button");
		objHomePage.clickBtn(objHomePage.beachBags);
		
		Log.info("Mouse hovered on products button");
		objHomePage.mouseHoverOnElement(objHomePage.products);
		
		Log.info("Clicked on LaptopBags button");
		objHomePage.clickBtn(objHomePage.laptopBags);
		
		Log.info("Mouse hovered on products button");
		objHomePage.mouseHoverOnElement(objHomePage.products);
		
		Log.info("Clicked on LaptopBags button");
		objHomePage.clickBtn(objHomePage.bags);
		
		Log.info("Checking whether email is clickable");
		if(objHomePage.isClickEnabled(objHomePage.email))
			Log.info("Email is clickable");
		
		Log.info("Checking whether phone number is clickable");
		if(objHomePage.isClickEnabled(objHomePage.phone))
			Log.info("Phone number is clickable");
		
		Log.info("Mouse hovered on my account button");
		objHomePage.mouseHoverOnElement(objHomePage.myAccount);
		
		Log.info("Clicked Register button");
		objHomePage.clickBtn(objHomePage.registerBtn);
		
		Log.info("Asserted text present on register page");
		objHomePage.getTextAndAssert(objHomePage.registerPageText, "verifyRegisterPageText");
		
		Log.info("Mouse hovered on my account button");
		objHomePage.mouseHoverOnElement(objHomePage.myAccount);
		
		Log.info("Clicked sign in button");
		objHomePage.clickBtn(objHomePage.signInBtn);
		
		Log.info("Asserted text present on sign in page");
		objHomePage.getTextAndAssert(objHomePage.signInPageText, "verifySignInPageText");
		
	}
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		DOMConfigurator.configure("Log4j.xml");
		objConfigFileReader = new ConfigFileReader();
		Log.info("Navigated to the homepage");
		driver.get(objConfigFileReader.getString("homePageURL"));	
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
