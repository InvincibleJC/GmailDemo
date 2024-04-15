
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class EmailAPI {
    public static void main(String[] args) 
    {
   	  //create a Selenium WebDriver instance
   	  System.setProperty("webdriver.edge.driver", "C:\\browserdrivers\\msedgedriver");
   	  WebDriver driver = new FirefoxDriver();
   	  
   	driver.manage().window().maximize();
   	  
      	//launch the Firefox browser and navigate to the website
      	driver.get("https://mailtrap.io/signin");
      	
      	//puts an implicit wait for 10 seconds before throwing exceptions
      	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      	
      	 // Open a URL (mailtrap email account)
        driver.get("https://mailtrap.io/signin");
    
        //wait for page
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        //accept cookies popup
        driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyButtonAccept\"]")).click();
      	
      	
      	//locate the email field
      	WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
      	
      	//set the field's value
      	email.sendKeys("testerteste462@gmail.com");
      	
      	//locate the password field
      	WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
      	
      	//set the password's value
      	password.sendKeys("Testemialpls007");
      	
      	//locate and click the submit button
      	driver.findElement(By.xpath("//input[@type='submit']")).click();
      	
      	//locate Demo Inbox and click it
      	driver.findElement(By.xpath("//a[@title='Demo inbox']")).click();
      	
      	//look for the given text in the list of web elements
      	List<WebElement> allMessages = driver.findElements(By.xpath("//*[contains(text(), 'Here comes an attachment')]"));
      	
      	//check if text has been found or not
      	if(allMessages.isEmpty()) 
      	
      	{
   		   System.out.println("Test not passed");
   		   
      	}
      	
      	else 
      	{
   		   System.out.println("Test passed");
   		   
      	}
      	
    	//close the Firefox browser.
      	driver.close();
      	
    }
}