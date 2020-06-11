package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import picnic.NewTours;

public class StepDefinition {
	
	
	NewTours ob = new NewTours();
	NewTours ob1 = new NewTours();
	

	@Given("^user navigates to webpage$")
	public void user_navigates_to_webpage(){
		ob.Setup();
	    
	}

	@Given("^user enters the details$")
	public void user_enters_the_details() {
		ob.register("vinod","jackson", "9123456789", "vinod@gmail.com","henderson circle","melbourne", "melbourne","12345","vinod", "vinod@123", "vinod@123");
	}

	@When("^user clicks submit button$")
	public void user_clicks_submit_button() {
		ob.registerprint();
		
	}

	@Then("^user validates the information$")
	public void user_validates_the_information()  {
		ob.validation();
		ob.close();
	}
	
	@Given("^navigate to webpage$")
	public void navigate_to_webpage() throws Throwable {
	    System.out.println("Given in Second feature file ");
	    
	}

	@Given("^enter the details$")
	public void enter_the_details() {
		System.out.println("And in Second feature file ");
	    
	}

	@When("^click submit button$")
	public void click_submit_button()  {
		System.out.println("when in Second feature file ");
	    
	}

	@Then("^validate the information$")
	public void validate_the_information()  {
		System.out.println("Then in Second feature file ");
	    
	}

	@Given("^user navigates to newtours webpage$")
	public void user_navigates_to_newtours_webpage()  {
	  
	   ob1.Setup();
	}

	@Given("^user enters the details in registration page$")
	public void user_enters_the_details_in_registration_page()  {
		ob1.register("vinod1","jackson1", "9123456788", "vinod1@gmail.com","henderson circle1","melbourne", "melbourne","12345","vinod1", "vinod@1234", "vinod@1234");
	    
	}

	@When("^user clicks submit button in registration page$")
	public void user_clicks_submit_button_in_registration_page()  {
	    ob1.registerprint();
	   
	}

	@Then("^user validates the information in confirmation page$")
	public void user_validates_the_information_in_confirmation_page()  {
	    ob1.validation();
	    ob1.close();
	   
	}

}
