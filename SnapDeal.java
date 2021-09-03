package Week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.xpath("(//span[@class='catText'])[6]")).click();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String string = driver.findElement(By.xpath("//span[@class='category-count']")).getText();		// TODO Auto-generated method stub
         System.out.println("total no of items:"+string);
         driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
         WebElement sortby = driver.findElement(By.xpath("//span[text()='Sort by:']"));
         sortby.click();
         WebElement lowToHigh = driver.findElement(By.xpath("//li[@class='search-li']"));
         lowToHigh.click();
         if(sortby.equals(lowToHigh)) {
        	 System.out.println("the order not  sorted");
         }
        	 else
        		 System.out.println("the order is sorted");
         
         
 		 WebElement shoe = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
 		 Actions builder= new Actions(driver);
 		 builder.moveToElement(shoe).perform();
 		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)", "");
 		 driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
 		Set<String>windowHandleSet= driver.getWindowHandles();
		List<String>windowHandleList= new ArrayList<String>(windowHandleSet);
		driver.switchTo().window(windowHandleList.get(0));
		String text1 = driver.findElement(By.xpath("//div[@class=' pdp-e-i-PAY clearfix']")).getText();	
		System.out.println("the price and discount:"+text1);
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap/SnapDeal.png");
		FileUtils.copyFile(src1, dst);
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		driver.findElement(By.xpath("//input[@id='inputValEnter']")).sendKeys("Puma sport shoe");
		driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
		
 		 
 				
         
         }
         
         
         
	}
	
	


