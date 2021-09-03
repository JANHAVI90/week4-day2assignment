package Week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.nykaa.com/");
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder= new Actions(driver);
		builder.moveToElement(brand).perform();
		WebElement popular = driver.findElement(By.xpath("//div[@id='list_brands_Popular']"));
		builder.moveToElement(popular).perform();
		WebElement lorealParis = driver.findElement(By.xpath("(//li[@class='brand-logo menu-links'])[5]/a"));
		lorealParis.click();
		Set<String>windowHandleSet= driver.getWindowHandles();
		List<String>windowHandleList= new ArrayList<String>(windowHandleSet);
		driver.switchTo().window(windowHandleList.get(1));
		System.out.println(driver.getTitle());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.xpath("//div[@class='sort-btn clearfix']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//div[@class='control__indicator']")).click();
		String text = driver.findElement(By.xpath("//label[@class='control control--checkbox']")).getText();
		System.out.println("The filter appiled for"+text);
		WebElement shampoo = driver.findElement(By.xpath("//div[@id='listingContainer']/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[21]/div[1]/a[1]/div[1]/div[1]/div[1]/div[1]/img[1]"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", shampoo);
        shampoo.click();
        Set<String>windowHandleSet1= driver.getWindowHandles();
		List<String>windowHandleList1= new ArrayList<String>(windowHandleSet1);
		driver.switchTo().window(windowHandleList1.get(2));  
        driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();
        driver.findElement(By.className("AddBagIcon")).click();
        String text2 = driver.findElement(By.className("value medium-strong")).getText();
        System.out.println("The grand Total:"+text2);
        driver.findElement(By.xpath("//span[text()='Proceed']")).click();
        driver.findElement(By.xpath("(//button[contains(@class,'btn full')])[2]")).click();
        String text3 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
        if(text3.equals(text2)) {
        	System.out.println("The price is same");
        	}
        	else 
        		System.out.println("The price are not same");
        	
        }
        
		
		
		
		
		
		// TODO Auto-generated method stub

	}


