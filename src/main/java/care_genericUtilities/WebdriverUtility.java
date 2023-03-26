package care_genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtility {

	 public void maximizewindow(WebDriver driver)
	   {
		   driver.manage().window().maximize();
	   }
	   public void minimizewindow(WebDriver driver)
	   {
		   driver.manage().window().minimize();
	   }
	   public void waitforpage(WebDriver driver)
	   {
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   }
	   public void waitforelementTobevisible(WebDriver driver,WebElement element)
	   {
		   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.elementToBeClickable(element));
	   }
	   public void handleDropdown(WebElement element,int index)
	   {
		   Select sel=new Select(element);
		   sel.selectByIndex(index);
	   }
	   public void handleDropdown(WebElement element,String value)
	   {
		   Select sel=new Select(element);
		   sel.selectByValue(value);
	   }
	   public void handleDropdown(String text,WebElement element)
	   {
		   Select sel=new Select(element);
		   sel.selectByVisibleText(text);		   
	   }
	   public void mousehoveraction(WebDriver driver,WebElement element)
	   {
		 Actions act =new Actions(driver);
		 act.moveToElement(element).perform();
	   }
	   public void rightclickaction(WebDriver driver)
	   {
		   Actions act=new Actions(driver);
		   act.contextClick().perform();
	   }
	   public void rightclickAction(WebDriver driver,WebElement element)
	   {
		   Actions act=new Actions(driver);
		   act.contextClick(element).perform();
	   }
	   public void doubleclick(WebDriver driver)
	   {
		   Actions act =new Actions(driver);
		   act.doubleClick().perform();
	   }
	   public void doubleclick(WebDriver driver,WebElement element)
	   {
		   Actions act =new Actions(driver);
		   act.doubleClick(element).perform();
	   }
	   public void draganddropAction(WebDriver driver,WebElement srcelement,WebElement dscelement)
	   {
		   Actions act=new Actions(driver);
		   act.dragAndDrop(srcelement, dscelement).perform(); 
	   }
	   public void acceptalert(WebDriver driver)
	   {
		   driver.switchTo().alert().accept();
	   }
	   public void dismissalert(WebDriver driver)
	   {
		   driver.switchTo().alert().dismiss();
	   }
	   public String getalertText(WebDriver driver)
	   {
		   return driver.switchTo().alert().getText();
	   }
	   public void handleframe(WebDriver driver,String nameorid)
	   {
		   driver.switchTo().frame(nameorid);
	   }
	   public void handleframe(WebDriver driver,WebElement element)
	   {
		   driver.switchTo().frame(element);
	   }
	   public void switchToParentframe(WebDriver driver)
	   {
		   driver.switchTo().defaultContent();
	   }
	   public void switchtodefaultframe(WebDriver driver)
	   {
		   driver.switchTo().defaultContent();
	   }
	   public void Switchtowindow(WebDriver driver,String partialwinTitle)
	   {
		   //step 1:capture all the window Ids
		   Set<String> winIds=driver.getWindowHandles();
		   //step 2:Navigate to each window
		   for(String win:winIds)
		   {
			//step 3:switch to window
			   String winTitle=driver.switchTo().window(win).getTitle();
			//step 4:compare the title with required partial title
			   if(winTitle.contains(partialwinTitle))
			   {
				   break;
			   }
		   }
	   }
	   //this method will take screenshot and save in folder
	   public String takeScreenShot(WebDriver driver,String Screenshotname) throws IOException
	   {
		   TakesScreenshot ts=(TakesScreenshot)driver;
		  File src= ts.getScreenshotAs(OutputType.FILE);
		   File dst = new File(".\\Screenshots"+Screenshotname+".png");
		   Files.copy(src, dst);
		   
		   return dst.getAbsolutePath();//used for extent report
		   
	   }
	   public void scrollAction(WebDriver driver)
	   {
		   JavascriptExecutor js=(JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,500)","");   
	   }
	   //this method will scroll until the element is reached
	   public void scrollAction(WebDriver driver,WebElement element)
	   {
		   JavascriptExecutor js=(JavascriptExecutor) driver;
		   int y=element.getLocation().getY();
		   js.executeScript("window.scrollBY(0,"+y+")",element);
	   }

}
