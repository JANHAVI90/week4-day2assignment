package Week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resizable/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	    driver.switchTo().frame(frame);
	    WebElement reSize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
	    Actions builder= new Actions(driver);
	    builder.dragAndDropBy(reSize, 200,120).perform();
	    
	    
	    
	    
		// TODO Auto-generated method stub

	}

}
