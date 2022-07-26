package starter.pageObjects;

import java.util.Random;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountsPage extends PageObject{
	@FindBy(xpath="//div[@title='New']")
	public WebElementFacade newButton;
	@FindBy(xpath="//legend[contains(text(),'Select a record type')]/following::span[contains(text(),'Consumer')]")
	public WebElementFacade consumerRadio;
	@FindBy(xpath="//button[@data-aura-class='uiButton']/span[contains(text(),'Next')]")
	public WebElementFacade nextButton;
	@FindBy(xpath="(//h2[contains(text(),'New Account')]/following::span[contains(text(),'Account Name')]/following::input)[1]")
	public WebElementFacade accountName;
	@FindBy(xpath="//button[@title='Save']")
	public WebElementFacade saveButton;
	
	
	public void selectStatusDropdown(String data){
		  $("(//h2[contains(text(),'New Account')]/following::span[contains(text(),'Status')]/following::a)[1]").click();
		  
		  $("(//h2[contains(text(),'New Account')]/following::span[contains(text(),'Status')]/following::a[@title='"+data+"'])[1]").click();
		}
	public void createNewConsumerAccount() throws InterruptedException {
		Thread.sleep(3000);
		this.newButton.click();
		this.consumerRadio.click();
		this.nextButton.click();
		Random random = new Random(); 
		long p = random.nextLong(); 
		System.out.println(p);
		String accountName = "Account"+p;
		System.out.println(accountName);
		this.accountName.sendKeys(accountName);
		this.selectStatusDropdown("Active");
		this.saveButton.click();
		Thread.sleep(8000);
		String accountUrl = getDriver().getCurrentUrl();
		System.out.println("The account url is: "+accountUrl);
		
	}
}