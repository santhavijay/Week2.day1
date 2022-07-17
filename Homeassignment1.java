package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homeassignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		String property = System.getProperty("webdriver.chrome.driver");
		System.out.println(property);
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement logOut = driver.findElement(By.className("decorativeSubmit"));
		String attribute = logOut.getAttribute("value");
		System.out.println(attribute);
		if (attribute.equals("Logout")) {
			System.out.println("Login successfully");
		} else {
			System.out.println("Login failed");
		}
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(3000);
		// click lead tab
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Create")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Jasmin");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Santha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("kumari");
		WebElement dropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select obj = new Select(dropdown);
		obj.selectByVisibleText("Conference");
		Thread.sleep(3000);
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Santha");
		driver.findElement(By.name("departmentName")).sendKeys("ECE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Welcome to testleaf");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("santha1.vijay@gmail.com");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sobj = new Select(state);
		sobj.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String leadTitle = "View Lead | opentaps CRM";
		if(title.equals(leadTitle))
		{
			System.out.println("Navigated to Leaftab page successfully");
		}
		else
			System.out.println("failed to navigate to Leaftab");
	}

}
