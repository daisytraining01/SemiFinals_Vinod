package picnic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewTours {
	WebDriver driver;
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/java/latestdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php ");
		driver.manage().window().maximize();
		
	}
	
	public void register(String fname,String lname,String phone,String Email,String address,String city,String state,String pc, String username,String pass,String cnfm_pass ) {
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.id("userName")).sendKeys(Email);
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);	
		driver.findElement(By.name("postalCode")).sendKeys(pc);
		Select sel = new Select(driver.findElement(By.name("country")));
		sel.selectByValue("AUSTRALIA");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("confirmPassword")).sendKeys(cnfm_pass);
		
		
		
		
	}
	
	public void registerprint() {
		String s1 = driver.findElement(By.name("firstName")).getAttribute("value");
		String s2 = driver.findElement(By.name("lastName")).getAttribute("value");
		String s3 = driver.findElement(By.name("phone")).getAttribute("value");
		String s4=driver.findElement(By.id("userName")).getAttribute("value");
		String s5=driver.findElement(By.name("address1")).getAttribute("value");
		String s6=driver.findElement(By.name("city")).getAttribute("value");
		String s7=driver.findElement(By.name("state")).getAttribute("value");
		String s8=driver.findElement(By.name("postalCode")).getAttribute("value");
		String s9=driver.findElement(By.id("email")).getAttribute("value");
		String s10 = driver.findElement(By.name("password")).getAttribute("value");	
    	String s11=	driver.findElement(By.name("confirmPassword")).getAttribute("value");
    	
    	System.out.println("***Register Fields***");
    	System.out.println("Firstname: "+s1);
    	System.out.println("Lastname: "+s2 );
    	System.out.println("Phone: "+s3);
    	System.out.println("Email: "+s4);
    	System.out.println("Address: "+s5);
    	System.out.println("City: "+s6);
    	System.out.println("State: "+s7);
    	System.out.println("PostalCode: "+s8);
    	System.out.println("Username: "+s9);
    	System.out.println("Password: "+s10);
    	System.out.println("Confirm password: "+s11);
    	
    	
    	driver.findElement(By.name("submit")).click();
	}

	public void validation() {
		
		String actual ="Thank you for registering. You may now sign-in using the user name and password you've just entered.";
		String expected = driver.findElement(By.xpath("(//font[@face='Arial, Helvetica, sans-serif'])[3]")).getText();
		 Assert.assertEquals(actual,expected); 
		 System.out.println("Assertion Passed");
		 System.out.println(expected);
		
	}
	
	public void screenshot() throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
		File DestFile=new File("src/main/java/screenshot"+filename);
		FileUtils.copyFile(SrcFile, DestFile);

		
	}
	
	
	//negative scenario
	public void NegativeScenario(String username,String pass,String cnf_pass ) {
		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("confirmPassword")).sendKeys(cnf_pass);
		driver.findElement(By.name("submit")).click();
		
		System.out.println("Negative Scenario:"+driver.findElement(By.xpath("//span")).getText());
		
		
		
		
	}
	
	public void close() {
		driver.close();
	}
	public static void main(String[] args) throws IOException {
		
		//Multiple records can be passed by creating multiple objects
		NewTours ob = new NewTours();
		NewTours ob1 = new NewTours();
		NewTours ob2 = new NewTours();
		
	    ob.Setup();
		ob.register("vinod","jackson", "9123456789", "vinod@gmail.com","henderson circle","melbourne", "melbourne","12345","vinod", "vinod@123", "vinod@123");
		ob.registerprint();
		ob.validation();
		ob.screenshot();
		ob.close();
		
		
		ob1.Setup();
		ob1.register("vinod1","jackson1", "9123456788", "vinod1@gmail.com","henderson circle1","melbourne", "melbourne","12345","vinod1", "vinod@1234", "vinod@1234");
		ob1.registerprint();
		ob1.validation();
		ob1.screenshot();
		ob1.close();
		
		
		//NegativeScenario
		ob2.Setup();
		ob2.NegativeScenario("hey", "vinod@1234","vinod");
		ob2.screenshot();
		ob2.close();
		
		
	}

}
