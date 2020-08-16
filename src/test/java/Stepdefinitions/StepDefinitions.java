package Stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.ElementNotVisibleException;
import Page_Objects.HomePage;
import Page_Objects.RegistrationPage;
import Utilities.CommonActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class StepDefinitions extends CommonActions {
	String newAccountID = "";

	RegistrationPage rp = new RegistrationPage();
	public static String userName = "";
	HomePage hp = new HomePage();

	@Given("Open Browser and launch the URL")
	public void open_Browser_and_launch_the_URL() throws IOException {
		launch(Get_Environment_Property("URL"));
	}

	@When("User click on Register button to create a new account")
	public void user_click_on_Register_button_to_create_a_new_account() {
		// highlightElementByJavaScript(driver, rp.getRegister_link());
		rp.clickOnRegisterLink();
	}

	@When("User enters data for all the required fields {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_enters_data_for_all_the_required_fields(String firstName, String lastName, String address,
			String city, String state, String zipCode, String phone, String SSN, String userName, String password,
			String confirm) {

		insertText(driver, rp.getFirstName(), 5, firstName);
		insertText(driver, rp.getLastName(), 5, lastName);
		insertText(driver, rp.getAddress(), 5, address);
		insertText(driver, rp.getCity(), 5, city);
		insertText(driver, rp.getState(), 5, state);
		insertText(driver, rp.getZipCode(), 5, zipCode);
		insertText(driver, rp.getPhoneNumber(), 5, phone);
		insertText(driver, rp.getSSN(), 5, SSN);
		// userName=randomAlphaNumeric();
		insertText(driver, rp.getUsername(), 5, userName);
		insertText(driver, rp.getPassword(), 5, password);
		insertText(driver, rp.getConfirm(), 5, confirm);

	}

	@When("User click on Register button under the registration form")
	public void user_click_on_Register_button_under_the_registration_form() {
		clickOn(driver, rp.getRegister_Submit(), 5);

	}

	@Then("User should displayed the message Your account was created successfully. You are now logged in. {string}")
	public void user_should_displayed_the_message(String loginConfirm) {
		assertEquals(rp.getUserNameError().getText(), loginConfirm);

	}

	@And("User should logout from the application")
	public void User_should_logout_from_the_application() {
		clickOn(driver, hp.getLogOut(), 5);
		//clickOn(driver, hp.getLog_In(), 5);
	}

	@Given("User logged in by his credentials {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_logged_in_by_his_credentials(String userName, String password, String firstName, String lastName,
			String address, String city, String state, String zip_Code, String SSN) throws InterruptedException {
		insertText(driver, hp.getUsername(), 5, userName);
		insertText(driver, hp.getPassword(), 5, password);
		clickOn(driver, hp.getLog_In(), 5);
		assertEquals(hp.getVerifyUsername(), "Welcome" + "" + firstName + "" + lastName);
		// String Veryfiy_user_name = hp.getVerifyUsername().getText();
		// Log.info(Veryfiy_user_name);
		// if(Veryfiy_user_name.equalsIgnoreCase(anotherString))

		try {
			isElementDisplayed(hp.getLoginError());
			highlightElementByJavaScript(driver, hp.getLoginError());
			clickOn(driver, hp.getForgot_Login(), 5);
			insertText(driver, hp.getFirstName(), 5, firstName);
			insertText(driver, hp.getLastName(), 5, lastName);
			insertText(driver, hp.getAddress(), 5, address);
			insertText(driver, hp.getCity(), 5, city);
			insertText(driver, hp.getState(), 5, state);
			insertText(driver, hp.getZipCode(), 5, zip_Code);
			insertText(driver, hp.getSSN(), 5, SSN);
			clickOn(driver, hp.getFind_My_Login_Info(), 5);
		} catch (ElementNotVisibleException e) {
			Log.info("Exception handled");
		}
	}

	@When("User clicks on Home link")
	public void user_clicks_on_Home_link() {
		clickOn(driver, hp.getHome(), 5);
	}

	@When("User write all the name of links present in the notepad")
	public void user_write_all_the_name_of_links_present_in_the_notepad() {
		hp.writeAllHomePageLinks();

	}

	@Then("A new file should be created with name of alllinks.txt in the file folder")
	public void a_new_file_should_be_created_with_name_of_alllinks_txt_in_the_file_folder() {
		hp.verifyFile();
	}

	@When("User click on the Open New Account link on the home page")
	public void user_click_on_the_Open_New_Account_link_on_the_home_page() {
		clickOn(driver, hp.getOpen_New_Account(), 5);

	}

	@And("Create an account by entering the values {string}")
	public void create_an_account_by_entering_the_values(String accountType) {
		selectValueFromDropDownByText(hp.getSelect_Account_Type(), accountType);
		selectValueFromDropDownByIndex(hp.getSelect_Balance(), 0);
		clickOn(driver, hp.getOpen_New_Accnt(), 5);
	}

	@Then("Message will be displayed as Your new account number: xxxxx capture the account number")
	public void message_will_be_displayed_as_Your_new_account_number_xxxxx_capture_the_account_number() {
		highlightElementByJavaScript(driver, hp.getNewAccountId());
		newAccountID = hp.getNewAccountId().getText();
		Log.info(newAccountID);

	}

	@And("Click on the Accounts Overview link and verify the created account number is displayed")
	public void click_on_the_Accounts_Overview_link_and_verify_the_created_account_number_is_displayed()
			throws InterruptedException {
		clickOn(driver, hp.getAccount_Overview(), 5);
		Thread.sleep(5000);
		String actNumber = hp.webtable(newAccountID);
		Log.info(actNumber);
		assertEquals(newAccountID, actNumber);

	}

}
