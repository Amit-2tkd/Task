import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//STEP-1 : Navigate to the FitPeo HomepageNavigate to the FitPeo Homepage
		driver.get("https://fitpeo.com/");
		//STEP-2 : Navigate to the Revenue Calculator Page:
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		//STEP-3 : Scroll Down to the Slider section:
		WebElement ele = driver.findElement(By.xpath("//span[text()='Patients should be between 0 to 2000']"));
		//Actions
		Actions action = new Actions(driver);
	//	action.scrollToElement(ele).perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
	//	js.executeScript("window.scrollBy(0,300)");
	//action.sendKeys(Keys.PAGE_DOWN).perform();
		WebElement slider = driver.findElement(By.xpath("//input[@data-index='0' and @aria-valuenow='200']"));
		
     	action.clickAndHold(slider).moveToLocation(907, 431).release().perform();
     	slider.getLocation().getX();
     	
     	//STEP-4 : UPDATE THE TEXT TO 560
       WebElement textbox = driver.findElement(By.xpath("//input[@type='number' and @aria-invalid='false']"));
	   js.executeScript("arguments[0].value='560'",textbox);
		int xposition = slider.getLocation().getX();
		System.out.println(xposition);
		
	   
	    //STEP-5 : CHECKBOX
	   driver.findElement(By.xpath("//span[text()='57']/..//input[@type='checkbox']")).click();
	   driver.findElement(By.xpath("//span[text()='19.19']/..//input[@type='checkbox']")).click();
	   driver.findElement(By.xpath("//span[text()='63']/..//input[@type='checkbox']")).click();
	   driver.findElement(By.xpath("//span[text()='15']/..//input[@type='checkbox']")).click();
	   
	   //STEP-6 : VALIDATING THE HEADER
	  WebElement finalMoney = driver.findElement(By.xpath("(//p[contains(text(),'$')])[3]"));
	  String output = finalMoney.getText();
	  System.out.println(output);
	  
	  
	  
	 
	  //STEP-7 : TO CLOSE THE BROWSER
	  driver.quit();
	 	  
	}

}
