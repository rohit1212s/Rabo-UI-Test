package Stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
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
	static int wait = 5;
	public static String userName = "";
	RegistrationPage rp = new RegistrationPage();
	HomePage hp = new HomePage();
	

	@Given("Open Browser and launch the URL")
	public void open_Browser_and_launch_the_URL() throws IOException {
		launch(Get_Environment_Property("URL"));
	}

	@When("User click on Register button to create a new account")
	public void user_click_on_Register_button_to_create_a_new_account() {
		//highlightElementByJavaScript(driver, rp.getRegister_link());
		rp.clickOnRegisterLink();
	}

	@When("User enters data for all the required fields {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_enters_data_for_all_the_required_fields(String firstName, String lastName, String address,
			String city, String state, String zipCode, String phone, String SSN, String userName, String password,
			String confirm) {

		insertText(driver, rp.getFirstName(), wait, firstName);
		insertText(driver, rp.getLastName(), wait, lastName);
		insertText(driver, rp.getAddress(), wait, address);
		insertText(driver, rp.getCity(), wait, city);
		insertText(driver, rp.getState(), wait, state);
		insertText(driver, rp.getZipCode(), wait, zipCode);
		insertText(driver, rp.getPhoneNumber(), wait, phone);
		insertText(driver, rp.getSSN(), wait, SSN);
		// userName=randomAlphaNumeric();
		insertText(driver, rp.getUsername(), wait, userName);
		insertText(driver, rp.getPassword(), wait, password);
		insertText(driver, rp.getConfirm(), wait, confirm);
	}

	@When("User click on Register button under the registration form")
	public void user_click_on_Register_button_under_the_registration_form() {
		clickOn(driver, rp.getRegister_Submit(), wait);
	}

	@Then("User should displayed the message Your account was created successfully. You are now logged in. {string}")
	public void user_should_displayed_the_message(String loginConfirm) {
		assertEquals("Login Successful", rp.getUserNameError().getText(), loginConfirm);

	}

	@And("User should logout from the application")
	public void User_should_logout_from_the_application() {
		clickOn(driver, hp.getLogOut(), wait);
		// clickOn(driver, hp.getLog_In(), wait);
	}

	@Given("User logged in by his credentials {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_logged_in_by_his_credentials(String userName, String password, String firstName, String lastName,
			String address, String city, String state, String zip_Code, String SSN) throws InterruptedException {
		insertText(driver, hp.getUsername(), wait, userName);
		insertText(driver, hp.getPassword(), wait, password);
		clickOn(driver, hp.getLog_In(), wait);

		// String Veryfiy_user_name = hp.getVerifyUsername().getText();
		// Log.info(Veryfiy_user_name);
		// if(Veryfiy_user_name.equalsIgnoreCase(anotherString))
		try {
		if (isElementDisplayed(hp.getLoginError())) {

			changeColorByJavaScript("Yellow", hp.getLoginError(), driver);
			clickOn(driver, hp.getForgot_Login(), wait);
			insertText(driver, hp.getFirstName(), wait, firstName);
			insertText(driver, hp.getLastName(), wait, lastName);
			insertText(driver, hp.getAddress(), wait, address);
			insertText(driver, hp.getCity(), wait, city);
			insertText(driver, hp.getState(), wait, state);
			insertText(driver, hp.getZipCode(), wait, zip_Code);
			insertText(driver, hp.getSSN(), wait, SSN);
			clickOn(driver, hp.getFind_My_Login_Info(), wait);
		}
				assertEquals("Login Failed", hp.getVerifyUsername(), "Welcome" + "" + firstName + "" + lastName);
			} catch (NoSuchElementException E) {
				assertNotEquals("login Failed", E, hp.getVerifyUsername());
				//Log.info("login Failed");
			}
		
	}

	@When("User clicks on Home link")
	public void user_clicks_on_Home_link() {
		clickOn(driver, hp.getHome(), wait);
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
		clickOn(driver, hp.getOpen_New_Account(), wait);

	}

	@And("Create an account by entering the values {string}")
	public void create_an_account_by_entering_the_values(String accountType) {
		selectValueFromDropDownByText(hp.getSelect_Account_Type(), accountType);
		selectValueFromDropDownByIndex(hp.getSelect_Balance(), 0);
		clickOn(driver, hp.getOpen_New_Accnt(), wait);
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
		clickOn(driver, hp.getAccount_Overview(), wait);
		String actNumber = hp.clickOnMatchingValue(hp.getWebTable(),newAccountID);
		//String actNumber = hp.webtable(newAccountID);
		Log.info(actNumber);
		assertEquals("Account number verified", newAccountID, actNumber);

	}

}
