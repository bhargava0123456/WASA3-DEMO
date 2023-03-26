package test_Cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Care_Login {

	WebDriver ldriver;
	 public Care_Login(WebDriver rdriver)
	  {
		  ldriver = rdriver;
		  PageFactory.initElements(rdriver,this);
	  }
   
	 @FindBy(name="mobileno")
	 private WebElement mobileno;
	 @FindBy(xpath="//span[text()='Get OTP']")
	 private WebElement getotpbtn;
	 @FindBy(id="otp")
	 private WebElement otp;
	 @FindBy(xpath="//span[text()='Sign In']")
	 private WebElement signinbtn;
	public WebDriver getLdriver() {
		return ldriver;
	}
	public WebElement getMobileno() {
		return mobileno;
	}
	public WebElement getGetotpbtn() {
		return getotpbtn;
	}
	public WebElement getOtp() {
		return otp;
	}
	public WebElement getSigninbtn() {
		return signinbtn;
	}
	 
}
