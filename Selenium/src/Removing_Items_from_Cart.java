import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Removing_Items_from_Cart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please help with valid email addresss & password to login amazon site");
		 String Email = scanner.nextLine();
		 System.out.println("Please help with valid password to login amazon site");
		 String Password = scanner.nextLine();
		 System.out.println("Email provided " + Email + "& Password provided " + Password);

			//Initiating browser	
		WebDriver driver = new ChromeDriver();
		
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.xpath("(//input[@id='ap_email'])[1]")).sendKeys("priya.february08@gmail.com");
		driver.findElement(By.xpath("(//input[@id='continue'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Friends@12");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		 
		  WebElement quantityDropdown = driver.findElement(By.xpath("(//span[@id='a-autoid-1-announce'])[1]"));

	        // Click on the quantity dropdown to open it
	        Actions actions1 = new Actions(driver);
	        actions1.moveToElement(quantityDropdown).click().perform();

	        // Select the desired quantity from the dropdown
	        WebElement quantityOption = driver.findElement(By.xpath("(//a[normalize-space()='2'])[1]")); // Change "2" to the desired quantity
	        quantityOption.click();
		

	}

}
