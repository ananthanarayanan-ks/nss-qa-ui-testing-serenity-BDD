package starter.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://test.salesforce.com")
public class SalesforcePage extends PageObject {
	@FindBy(xpath="//input[@id='username']")
	public WebElementFacade userName;
	@FindBy(xpath="//input[@id='password']")
	WebElementFacade password;
	@FindBy(xpath="//input[@id='Login']")
	WebElementFacade loginButton;
	@FindBy(xpath="//div[@role='navigation']//button[contains(@class,'slds-button')]")
	WebElementFacade appLauncher;
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElementFacade appSearchTextBox;
	@FindBy(xpath="(//lightning-formatted-rich-text//b[contains(text(),'Sales')])[1]")
	WebElementFacade salesAppSearchResult;
	@FindBy(xpath="//a[@title='Accounts']")
	public WebElementFacade accountsTab;
	
	
	public void login() throws InterruptedException {
		this.userName.sendKeys("ananthanarayanan.ks@centricanss.com.test");
		this.password.sendKeys("Centrica#1234");
		this.loginButton.waitUntilVisible();
		this.loginButton.click();
		Thread.sleep(8000);
	}
	public void switchApplication(String app) throws InterruptedException {
		switch(app) {
		  case "Sales":
		    this.appLauncher.waitUntilClickable();
		    this.appLauncher.click();
		    this.appSearchTextBox.waitUntilClickable();
		    this.appSearchTextBox.sendKeys(app);
		    this.salesAppSearchResult.waitUntilClickable();
		    this.salesAppSearchResult.click();
		    Thread.sleep(8000);
		    break;
		  
		}
	}

}
