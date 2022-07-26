package starter.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://google.com")
public class GoogleHomePage extends PageObject{
	@FindBy(xpath="//input[@title='Search']")
	WebElementFacade searchBox;
	@FindBy(xpath="//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search']")
	WebElementFacade searchButton;
	@FindBy(xpath="//img[@alt='Google']")
	WebElementFacade googleImage;
	
	
	
	public void performGoogleSearch() throws InterruptedException {
	
		this.searchBox.sendKeys("Cricket Game");
		Thread.sleep(5000);
		this.googleImage.click();
		this.searchButton.click();
		Thread.sleep(5000);
	}
}
