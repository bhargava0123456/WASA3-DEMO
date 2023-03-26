package test_Cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import care_genericUtilities.PropertyFileUtility;
import care_genericUtilities.WebdriverUtility;

public class Login {
	static PropertyFileUtility pu=new PropertyFileUtility();
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String url = pu.datafrompropertyfile("url");
		String otp =pu.datafrompropertyfile("otp");
		String mobile=pu.datafrompropertyfile("mobile");
		
		WebdriverUtility wdu=new WebdriverUtility();
		WebDriver driver =new ChromeDriver();
		Care_Login l=new Care_Login(driver);
		wdu.maximizewindow(driver);
		wdu.waitforpage(driver);
		driver.get(url);
		l.getMobileno().sendKeys(mobile);
		l.getGetotpbtn().click();
		l.getOtp().sendKeys(otp);
		
		
	}

}
