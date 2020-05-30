package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RootPage {
	WebDriver driver=null;
	//PageFactory or OR
	@FindBy(xpath= "html/body/div/div[2]/form/input[1]")
	WebElement fistName;
	public void enterFirstname(String fn) {
		fistName.sendKeys(fn);
	}
	@FindBy( name= "LName")//2
	WebElement lastName;
	public void enterLastname(String ln) {
		lastName.sendKeys(ln);
	}
	@FindBy(name="Email")//3
	WebElement email;
	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}
	@FindBy(name="Pass")//4
	WebElement passWord;
	public void enterPassword(String pw) {
		passWord.sendKeys(pw);
	}
	@FindBy(name="Phone")//5
	WebElement phoneNumber;
	public void phoneNumber(String phn) {
		phoneNumber.sendKeys(phn);
	}
	
	@FindBy(name= "month")//6
	WebElement monthName;
	public void selectMonth(String mn) {
		Select monthselect=new Select(monthName);
		monthselect.selectByVisibleText(mn);
	}
	
	@FindBy(name= "day")//7
	WebElement dayName;
	public void selectDay(String da) {
		Select dayselect=new Select(dayName);
		dayselect.selectByVisibleText(da);
	}
	@FindBy(name= "year")//8
	WebElement yearName;
	public void selectYear(String yr) {
		Select yearselect=new Select(yearName);
		yearselect.selectByVisibleText(yr);
	}
	@FindBy(xpath="html/body/div/div[2]/form/input[6]") //9---/html/body/div/div[2]/form/input[6]
	WebElement sexName;
	public void clickOnMale() {
		sexName.click();
	}
	@FindBy(xpath="html/body/div/div[2]/form/input[7]") //9---/html/body/div/div[2]/form/input[6]
	WebElement female;
	public void clickOnfemale() {
		female.click();
	}
	@FindBy(xpath="//input[@value='Submit']")//10
	WebElement submitbutton;
	public void submitButton() {
		submitbutton.click();
		//NextPage np=new NextPage(driver);
		//return np;
	}
	@FindBy(xpath="//*[contains(text(), 'Submitted')]")
	WebElement text;
	
	public void verifyText(String message){
		String actulaText=text.getText();
		Assert.assertEquals(actulaText, message);
	}
	public RootPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
