import java.time.Duration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Adding_Items_to_Cart {

	 public static void main(String[] args) {
		
		//Initiating browser 
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please help with valid email addresss & password to login amazon site");
		 String Email = scanner.nextLine();
		 System.out.println("Please help with valid password to login amazon site");
		 String Password = scanner.nextLine();
		 System.out.println("Email provided " + Email + "& Password provided " + Password);

			//Initiating browser 

	    WebDriver driver = new ChromeDriver();   
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Landing on Web Page
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		//Entering Login creds
		
		driver.findElement(By.xpath("(//input[@id='ap_email'])[1]")).sendKeys(Email);
		driver.findElement(By.xpath("(//input[@id='continue'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		//Searching item
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("girnar detox desi kahwa green tea");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		//Adding item to cart
		driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_6']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.findElement(By.id("add-to-cart-button")).click();
        

	}

}
