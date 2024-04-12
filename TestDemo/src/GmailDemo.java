import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GmailDemo 
{
    @SuppressWarnings("deprecation")
	public static void main(String[] args) 
    {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.edge.driver", "C:\\browserdrivers\\msedgedriver");

        // Initialize an WebDriver / Maximize the browser window
       WebDriver driver = new FirefoxDriver();
       driver.manage().window().maximize();

        // Open a URL (mailtrap email account)
        driver.get("https://mailtrap.io/signin");
    
        //wait for page
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        //accept cookies popup
        driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyButtonAccept\"]")).click();
        
       //wait for page
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        //Select "Use Google Account"
        driver.findElement(By.xpath("/html/body/main/div/div[1]/div[2]/div/a[1]")).click();
        
        //Type Email Address
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("testerteste462@gmail.com");	
       
        //wait for page
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       
        // Locate next button
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button")).click();
        
        //Enter Password
        //driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Testemialpls007");
        ///html/body/div[1]/div[1]/div[2]/c-wiz/div/div[2]/div/div/div[1]/form/span/section[2]/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input
        driver.findElement(By.id("password")).sendKeys("Testemialpls007");
        
        //wait for page
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        
        //submit credentials
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button")).click();
        
        
        //Go to demo inbox
        //driver.findElement(By.xpath("//a[@title='Demo inbox']")).click();
        
        //search email for pass/fail
        //List<WebElement> allMessages = driver.findElements(By.xpath("//*[contains(text(), 'Here comes an attachment')]"));
	     // if(allMessages.isEmpty()) 
	      //{
	    	//  System.out.println("Test not passed");
	      //}
	      	
	     // else 
	     // {
	    	// System.out.println("Test passed");
	      //}
	      
	      //driver.close();
        
    }
}
      
