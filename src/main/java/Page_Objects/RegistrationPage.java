package Page_Objects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonActions;

public class RegistrationPage extends CommonActions {

	public RegistrationPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement Register_link;
	@FindBy(id = "customer.firstName")
	private WebElement FirstName;
	@FindBy(id = "customer.lastName")
	private WebElement LastName;
	@FindBy(id = "customer.address.street")
	private WebElement Address;
	@FindBy(id = "customer.address.city")
	private WebElement City;
	@FindBy(id = "customer.address.state")
	private WebElement State;
	@FindBy(id = "customer.address.zipCode")
	private WebElement ZipCode;
	@FindBy(id = "customer.phoneNumber")
	private WebElement PhoneNumber;
	@FindBy(id = "customer.ssn")
	private WebElement SSN;
	@FindBy(id = "customer.username")
	private WebElement Username;
	@FindBy(id = "customer.password")
	private WebElement Password;
	@FindBy(id = "repeatedPassword")
	private WebElement Confirm;
	@FindBy(xpath = "//input[@type='submit' and @value='Register']")
	private WebElement Register_Submit;
	@FindBy(xpath = "//p[contains(text(),'You are now logged in.')]")
	private WebElement UserNameError;
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement LogOut;
	@FindBy(id = "[id='customer.username.errors']")
	private WebElement UserAlreadyExist;
	
	
	
	public WebElement getUserAlreadyExist() {
		return UserAlreadyExist;
	}

	public WebElement getLogOut() {
		return LogOut;
	}

	public WebElement getUserNameError() {
		return UserNameError;
	}

	public WebElement getRegister_link() {
		return Register_link;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getAddress() {
		return Address;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getState() {
		return State;
	}

	public WebElement getZipCode() {
		return ZipCode;
	}

	public WebElement getPhoneNumber() {
		return PhoneNumber;
	}

	public WebElement getSSN() {
		return SSN;
	}

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getConfirm() {
		return Confirm;
	}

	public WebElement getRegister_Submit() {
		return Register_Submit;
	}
	//To click on register link to enter the value in register page
	public void clickOnRegisterLink() {
		try {
			clickOn(driver, Register_link, 5);
		} catch (NoSuchElementException e) {
			Log.info(e);
		}
	}
	//To click on registration page link after entering value 
	public void clickOnRegisterSubmit() {
		try {
			clickOn(driver, Register_Submit, 5);
		} catch (NoSuchElementException e) {
			Log.info(e);
		}
	}

}
