package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NextPage {
WebDriver driver=null;
	
	@FindBy(xpath="//*[contains(text(), 'Submitted')]")
	WebElement text;
	
	public void verifyText(String message){
		String actulaText=text.getText();
		Assert.assertEquals(actulaText, message);
	}
	
	
	public NextPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
