package starter.stepdefinitions;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.pageObjects.GoogleHomePage;

public class googleSearchStepDefinitions {
	GoogleHomePage goog;
	

	@Given("I am on google search page")
	public void i_am_on_google_search_page() {
	    goog.open();
	}

	@Given("I enter Cricket Game in search bar")
	public void i_enter_cricket_game_in_search_bar() throws InterruptedException {
	  goog.performGoogleSearch();  
	}
}
