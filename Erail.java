package Week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://erail.in/");
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("ms",Keys.ENTER);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("mdu",Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).clear();
		WebElement webTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		WebElement rowList = webTable.findElement(By.tagName("tr"));
		
			
		
		
	
	
			
			
		}
		
		
		
		// TODO Auto-generated method stub

	}


