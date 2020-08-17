package Page_Objects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonActions;

public class HomePage extends CommonActions {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement Username;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement Password;
	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement Log_In;
	@FindBy(xpath = "//a[text()='Forgot login info?']")
	private WebElement Forgot_Login;
	@FindBy(id = "firstName")
	private WebElement FirstName;
	@FindBy(id = "lastName")
	private WebElement LastName;
	@FindBy(id = "address.street")
	private WebElement Address;
	@FindBy(id = "address.city")
	private WebElement City;
	@FindBy(id = "address.state")
	private WebElement State;
	@FindBy(id = "address.zipCode")
	private WebElement ZipCode;
	@FindBy(id = "ssn")
	private WebElement SSN;
	@FindBy(xpath = "//input[@value='Find My Login Info']")
	private WebElement Find_My_Login_Info;
	@FindBy(xpath = "//a[text()='home']")
	private WebElement Home;
	@FindBy(tagName = "a")
	private List<WebElement> All_links;
	@FindBy(xpath = "//a[text()='Open New Account']")
	private WebElement Open_New_Account;
	@FindBy(xpath = "//select[@id='type']")
	private WebElement Select_Account_Type;
	@FindBy(xpath = "//select[@id='fromAccountId']")
	private WebElement Select_Balance;
	@FindBy(xpath = "//input[@value='Open New Account']")
	private WebElement Open_New_Accnt;
	@FindBy(id = "newAccountId")
	private WebElement NewAccountId;
	@FindBy(xpath = "//a[text()='Accounts Overview']")
	private WebElement Account_Overview;
	@FindBy(xpath = "//table[@id='accountTable']/tbody/tr/td[1]")
	private List<WebElement> WebTable;
	@FindBy(xpath = "//p[@class='smallText']")
	private WebElement VerifyUsername;
	@FindBy(xpath = "//p[@class='error']")
	private WebElement LoginError;
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement LogOut;
	
	
	public WebElement getLogOut() {
		return LogOut;
	}
	public WebElement getLoginError() {
		return LoginError;
	}

	public WebElement getNewAccountId() {
		return NewAccountId;
	}

	public WebElement getVerifyUsername() {
		return VerifyUsername;
	}

	public WebElement getOpen_New_Accnt() {
		return Open_New_Accnt;
	}

	public WebElement getSelect_Balance() {
		return Select_Balance;
	}

	public WebElement getSelect_Account_Type() {
		return Select_Account_Type;
	}

	public WebElement getOpen_New_Account() {
		return Open_New_Account;
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

	public WebElement getSSN() {
		return SSN;
	}

	public WebElement getFind_My_Login_Info() {
		return Find_My_Login_Info;
	}

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLog_In() {
		return Log_In;
	}

	public WebElement getForgot_Login() {
		return Forgot_Login;
	}

	public List<WebElement> getAll_links() {
		return All_links;
	}

	public WebElement getHome() {
		return Home;
	}
	//To verify a element exists in a webtable
	public String webtable(String value) {
		int size = getWebTable().size();
		Log.info("Size is="+size);
		String acnt_number = "";
		try {
			for (int j = 1; j < size; j++) {
				WebElement findElement = driver
						.findElement(By.xpath("//table[@id='accountTable']/tbody/tr[" + j + "]/td[1]"));
				String text = findElement.getText();
				Log.info(text);
				if (text.equals(value)) {
					acnt_number = text;
				}
			}

		} catch (StaleElementReferenceException e) {
			Log.info(e);

		}catch(NoSuchElementException e) {
			Log.info(e);
		}
		return acnt_number;
	}

	
	// To Match Value with List of Elements and Click on it.
	public String clickOnMatchingValue(List<WebElement> listOfElements, String valueToBeMatched) {
		String actId="";
		System.out.println(listOfElements.size());
		for (WebElement element : listOfElements) {
			if (element.getText().equalsIgnoreCase(valueToBeMatched)) {
			actId=	element.getText();
				
			}
		}
		return actId;
	}
	
	public WebElement getAccount_Overview() {
		return Account_Overview;
	}

	public List<WebElement> getWebTable() {
		return WebTable;
	}
	//To write name of all links present in the home page
	public void writeAllHomePageLinks() {
		try {

			path = ".//TestData//alllinks.txt";
			File file = new File(path);
			// Path path1 = Paths.get(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			List<WebElement> all_links = getAll_links();
			int i = 0;
			for (WebElement link : all_links) {
				Log.info(++i + ") " + link.getText() + " - " + link.getAttribute("href"));
				String value = link.getText() + " - " + link.getAttribute("href");
				bw.write(value);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			Log.info(e);
		}
	}
	
	//To verify if file exists or not
	public void verifyFile() {
		path = ".//TestData//alllinks.txt";
		File file = new File(path);
		boolean exists = file.exists();
		if(exists) {
			Log.info("File verified successfully");
		}else
		Log.info("File not created");
	}

}
