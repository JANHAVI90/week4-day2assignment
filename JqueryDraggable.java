package Week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDraggable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/draggable/");
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='/resources/demos/draggable/default.html']"));
		driver.switchTo().frame(frame1);
		WebElement drag = driver.findElement(By.id("draggable"));
		Actions builder= new Actions(driver);
		builder.dragAndDropBy(drag,100,100).perform();
		
		// TODO Auto-generated method stub

	}

}
