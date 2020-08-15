package Stepdefinitions;

import java.io.IOException;
import Page_Objects.HomePage;
import Page_Objects.RegistrationPage;
import Utilities.CommonActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class Step_Definitions {
	String newAccountID = "";
	

	RegistrationPage rp = new RegistrationPage();
	CommonActions ca = new CommonActions();
	public static String userName="";
	HomePage hp = new HomePage();

	@Given("Open Browser and launch the URL")
	public void open_Browser_and_launch_the_URL() throws IOException {
		ca.launch(ca.Get_Environment_Property("URL"));
	}

	@When("User click on Register button to create a new account")
	public void user_click_on_Register_button_to_create_a_new_account() {
		// ca.driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		// rp.test1();
		rp.clickOnRegisterLink();
	}

	@When("User enters data for all the required fields {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_enters_data_for_all_the_required_fields(String First_Name, String Last_Name, String Address,
			String City, String State, String Zip_Code, String Phone, String SSN, String UserName, String Password,
			String Confirm) {
		ca.insertText(rp.getFirstName(), First_Name);
		ca.insertText(rp.getLastName(), Last_Name);
		ca.insertText(rp.getAddress(), Address);
		ca.insertText(rp.getCity(), City);
		ca.insertText(rp.getState(), State);
		ca.insertText(rp.getZipCode(), Zip_Code);
		ca.insertText(rp.getPhoneNumber(), Phone);
		ca.insertText(rp.getSSN(), SSN);
		//userName=ca.randomAlphaNumeric();
		ca.insertText(rp.getUsername(), UserName);
		ca.insertText(rp.getPassword(), Password);
		ca.insertText(rp.getConfirm(), Confirm);
	}

	@When("User click on Register button under the registration form")
	public void user_click_on_Register_button_under_the_registration_form() {
		ca.clickOn(rp.getRegister_Submit());

	}

	@Then("User should displayed the message Your account was created successfully. You are now logged in.")
	public void user_should_displayed_the_message() {
		// Assert.assertEquals(Expected, String actual);

	}

	@Given("User logged in by his credentials {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_logged_in_by_his_credentials(String UserName, String Password, String First_Name, String Last_Name,
			String Address, String City, String State, String Zip_Code, String SSN) throws InterruptedException {
		ca.insertText(hp.getUsername(), UserName);
		ca.insertText(hp.getPassword(), Password);
		ca.clickOn(hp.getLog_In());
		String Veryfiy_user_name = hp.getVerifyUsername().getText();
		System.out.println(Veryfiy_user_name);
		// if(Veryfiy_user_name.equalsIgnoreCase(anotherString))
//		ca.clickOn(hp.getForgot_Login());
//		ca.insertText(hp.getFirstName(), First_Name);
//		ca.insertText(hp.getLastName(), Last_Name);
//		ca.insertText(hp.getAddress(), Address);
//		ca.insertText(hp.getCity(), City);
//		ca.insertText(hp.getState(), State);
//		ca.insertText(hp.getZipCode(), Zip_Code);
//		ca.insertText(hp.getSSN(), SSN);
//		 Thread.sleep(4000);
//		ca.clickOn(hp.getFind_My_Login_Info());

	}

	@When("User clicks on Home link")
	public void user_clicks_on_Home_link() {
		ca.clickOn(hp.getHome());
	}

	@When("User write all the name of links present in the notepad")
	public void user_write_all_the_name_of_links_present_in_the_notepad() {
		hp.writeAllHomePageLinks();

	}

	@Then("A new file should be created with name of alllinks.txt in the file folder")
	public void a_new_file_should_be_created_with_name_of_alllinks_txt_in_the_file_folder() {
		// ca.verifyFile(ca.path);

	}

	@When("User click on the Open New Account link on the home page")
	public void user_click_on_the_Open_New_Account_link_on_the_home_page() {
		ca.clickOn(hp.getOpen_New_Account());

	}

	@And("Create an account by entering the values")
	public void create_an_account_by_entering_the_values() {
		ca.selectValueFromDropDownByText(hp.getSelect_Account_Type(), "SAVINGS");
		ca.selectValueFromDropDownByIndex(hp.getSelect_Balance(), 0);
		ca.clickOn(hp.getOpen_New_Accnt());
	}

	@Then("Message will be displayed as Your new account number: xxxxx capture the account number {string}")
	public void message_will_be_displayed_as_Your_new_account_number_xxxxx_capture_the_account_number(String msg) {
		newAccountID = hp.getNewAccountId().getText();
		System.out.println(newAccountID);

	}

	@And("Click on the Accounts Overview link and verify the created account number is displayed")
	public void click_on_the_Accounts_Overview_link_and_verify_the_created_account_number_is_displayed()
			throws InterruptedException {
		ca.clickOn(hp.getAccount_Overview());
		Thread.sleep(5000);
		String actNumber = hp.webtable(newAccountID);
		System.out.println(actNumber);
		Assert.assertEquals(newAccountID, actNumber);

	}

}
