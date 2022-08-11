package starter.stepdefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import starter.Utilities.ReadDataFromExcel;
import starter.pageObjects.AccountsPage;
import starter.pageObjects.SalesforcePage;


public class NssStepDefinitions extends PageObject{
	
	SalesforcePage sfPage;
	AccountsPage accPage;
	ReadDataFromExcel excelData;
	
	@Given("I am on the SalesForce login page")
	public void openSalesForce() throws InterruptedException, IOException {
		Thread.sleep(8000);
		  System.out.println("The user name is---------------------------"+excelData.getData("Login", "System_Administrator", "Username"));
		sfPage.open();
	    
	}

	@When("I login to SalesForce")
	public void loginToSalesForce() throws InterruptedException, IOException {
	  sfPage.login();  
	  
	}
	
	@When("I switch to {string} Application")
	public void switchSfApplication(String app) throws InterruptedException {
		sfPage.switchApplication(app);
	    
	}
	@When("I navigate to {string} page")
	public void navigateToPage(String pageName) throws InterruptedException {
		System.out.println("********************* Page Name is *******************"+pageName);
		switch(pageName) {
		  case "Accounts":
			getDriver().navigate().to("https://centricanss--test.lightning.force.com/lightning/o/Account/list?filterName=Recent");
			Thread.sleep(3000);
			break;
		}
	    
	}
	@When("I create a {string} account on {string} page")
	public void i_create_a_account_on_page(String accountType, String pageName) throws InterruptedException {
		switch(accountType) {
		  case "Consumer":
			accPage.createNewConsumerAccount();
			Thread.sleep(3000);
			break;
		}
	}
}