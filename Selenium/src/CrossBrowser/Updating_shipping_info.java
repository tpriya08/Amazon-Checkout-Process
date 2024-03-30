package CrossBrowser;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Updating_shipping_info {
	
	@Test
	public void Updating_shipping() throws MalformedURLException, URISyntaxException 
	{
		Scanner scanner = new Scanner(System.in);
		//Inputs for login page
		System.out.println("Please help with valid email addresss & password to login amazon site");
		 String Email = scanner.nextLine();
		 System.out.println("Please help with valid password to login amazon site");
		 String Password = scanner.nextLine();
		 System.out.println("Email provided " + Email + "& Password provided " + Password);
		 
		 //Inputs for new address
		 System.out.println("Please help with valid Full Name");
		 String Name = scanner.nextLine();
		 System.out.println("Please help with valid contact number");
		 String contact = scanner.nextLine();
		 System.out.println("Please help with valid AddressPostalCode");
		 String PostalCode = scanner.nextLine();
		 System.out.println("Please help with valid AddressLine1");
		 String AddressLine1 = scanner.nextLine();
		 System.out.println("Please help with valid AddressLine2");
		 String AddressLine2 = scanner.nextLine();
		 System.out.println("Full Name provided " + Name);
		 System.out.println("Contact number provided " + PostalCode);
		 System.out.println("AddressPostalCode provided " + PostalCode);
		 System.out.println("AddressLine1e provided " + AddressLine1);
		 System.out.println("AddressLine2 provided " + AddressLine2);
		
		 //crossbrowser
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("Chrome");
		WebDriver driver = new RemoteWebDriver (new URI("http://192.168.0.105:4444").toURL(), caps ) ;

		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
			driver.findElement(By.xpath("(//input[@id='ap_email'])[1]")).sendKeys(Email);
			driver.findElement(By.xpath("(//input[@id='continue'])[1]")).click();
			driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(Password);
			driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("girnar detox desi kahwa green tea");
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_6']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();
	        Set<String> ids = driver.getWindowHandles();
	        Iterator<String> it = ids.iterator();
	        String parentId = it.next();
	        String childId = it.next();
	        driver.switchTo().window(childId);
	        driver.findElement(By.id("add-to-cart-button")).click();
	        Set<String> ids2 = driver.getWindowHandles();
	        Iterator<String> it2 = ids2.iterator();
	        String parentId2 = it2.next();
	        String childId2 = it2.next();
	        driver.switchTo().window(childId2);
	        driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
	        
	       Set<String> ids3 = driver.getWindowHandles();
	        Iterator<String> it3 = ids3.iterator();
	        String parentId3 = it3.next();
	        String childId3 = it3.next();
	        driver.switchTo().window(childId3);
	      // driver.findElement(By.id("addressChangeLinkId")).click();
	        driver.findElement(By.xpath("//a[@id='add-new-address-popover-link']")).click(); 
	        
	        
	       WebElement popoverTrigger = driver.findElement(By.id("a-popover-content-1")); // Change 'popover-trigger' to the actual ID or selector of the trigger element
	        Actions actions = new Actions(driver);
	        actions.moveToElement(popoverTrigger).click().perform();
	      
	        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']")).sendKeys(Name);
	        driver.findElement(By.xpath("(//input[@id='address-ui-widgets-enterAddressPhoneNumber'])[1]")).sendKeys(contact);
	        driver.findElement(By.xpath("(//input[@id='address-ui-widgets-enterAddressPostalCode'])[1]")).sendKeys(PostalCode );
	        driver.findElement(By.xpath(" (//input[@id='address-ui-widgets-enterAddressLine1'])[1]")).sendKeys(AddressLine1);

	       driver.findElement(By.xpath("(//input[@id='address-ui-widgets-enterAddressLine2'])[1] ")).sendKeys(AddressLine2);
	       driver.findElement(By.xpath(" (//span[@role='button'])[2]")).click();
	       driver.findElement(By.xpath("(//a[normalize-space()='DELHI'])[1]")).click();
	       WebElement saveButton = driver.findElement(By.cssSelector("input[aria-labelledby='address-ui-widgets-form-submit-button-announce']")); // Change 'saveButton' to the actual ID or selector of the save button within the popover
	       saveButton.click(); 
}
}