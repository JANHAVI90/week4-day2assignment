package Week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		WebElement testLeafcourses = driver.findElement(By.xpath("//a[text()='TestLeaf Courses']"));
		Actions builder= new Actions(driver);
		builder.moveToElement(testLeafcourses).perform();
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		alert.accept();
		List<WebElement> list = driver.findElements(By.tagName("a"));
		for (WebElement eachLinks:list) {
			String text = eachLinks.getText();
			System.out.println("the links in testleafcourse:"+text);
			
			
			
		}
		
		
		
		
		// TODO Auto-generated method stub

	}

}
