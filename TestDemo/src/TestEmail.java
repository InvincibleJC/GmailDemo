import org.json.JSONArray;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

public class TestEmail {
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException 
	{
		final String apiToken = "1f127006694ac73cbd900da1de28c59e";
		final String accountId = "1892975";
		final String host = "https://mailtrap.io";
		final String testNotPassed = "Test not passed";
      	
		
		// initialize client for API calls
      	AsyncHttpClient client = new DefaultAsyncHttpClient();
      	
      	String mailtrap;
		// get all inboxes for the account
      	Response inboxesResponse = client.prepare("GET", mailtrap + "/api/accounts/" + accountId + "/inboxes/")
      	  .setHeader("Content-Type", "application/json")
      	  .setHeader("Api-Token", apiToken)
      	  .execute()
      	  .get();
      	
      	if (inboxesResponse.getStatusCode() != 200) {
		   System.out.println("Cannot find inboxes for the account");
		   System.out.println(testNotPassed);
		   System.exit(0);
	   	}
      	
      	String inboxesResponseBody = inboxesResponse.getResponseBody();
      	JSONArray inboxes = new JSONArray(inboxesResponseBody);
      	
      	// get first inbox
      	String inboxId = inboxes.getJSONObject(0).getBigInteger("id").toString();
      	
      	// get messages from first inbox
		Response inboxMessagesResponse = client.prepare("GET", mailtrap + "/api/accounts/" + accountId + "/inboxes/" + inboxId + "/messages/")
      	  .setHeader("Content-Type", "application/json")
      	  .setHeader("Api-Token", apiToken)
      	  .execute()
      	  .get();
		
		if (inboxesResponse.getStatusCode() != 200) {
		   System.out.println("Cannot find inbox " + inboxId);
		   System.out.println(testNotPassed);
		   System.exit(0);
	   	}
		
		String inboxMessagesResponseBody = inboxMessagesResponse.getResponseBody();
		JSONArray messages = new JSONArray(inboxMessagesResponseBody);
		
		// get first message
		String messageId = messages.getJSONObject(0).getBigInteger("id").toString();
		String messageHtmlPath = messages.getJSONObject(0).getString("html_path");
		
		Response messagesResponse = client.prepare("GET", mailtrap + messageHtmlPath)
		      	  .setHeader("Content-Type", "application/json")
		      	  .setHeader("Api-Token", apiToken)
		      	  .execute()
		      	  .get();
		
		if (messagesResponse.getStatusCode() != 200) {
		   System.out.println("Cannot find message " + messageId);
		   System.out.println(testNotPassed);
		   System.exit(0);
	   	}
		String messagesResponseBody = messagesResponse.getResponseBody();
		
		client.close();

      	System.setProperty("webdriver.gecko.driver", "/Users/exampleusertest/geckodriver");
        // create a Selenium WebDriver instance
		WebDriver driver = new FirefoxDriver();
      	//launch the Firefox browser and navigate to the HTML version of the email
      	driver.get(mailtrap + messageHtmlPath + "?api_token=" + apiToken);
      	//puts an implicit wait for 10 seconds before throwing exceptions
      	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      	
      	Boolean htmlDisplayed = driver.findElement(By.xpath("//*[contains(text(), 'Congrats for sending test email with Mailtrap!')]")).isDisplayed();
      	
      	if(htmlDisplayed) {
      		System.out.println("HTML of email is displayed. Test passed");
		   
	   	} else {
	   		System.out.println(testNotPassed);
	   	}
	 	//close the Firefox browser.
	   	driver.close();
	}
}