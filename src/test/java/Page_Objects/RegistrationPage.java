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

	public void clickOnRegisterLink() {
		try {
			clickOn(Register_link);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	public void clickOnRegisterSubmit() {
		try {
			clickOn(Register_Submit);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

}
