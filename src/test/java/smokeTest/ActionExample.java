package smokeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionExample {
	WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test(priority = 0)
	public void open() throws InterruptedException {
			driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
			Actions act = new Actions(driver);
			driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame.lazyloaded")));
			System.out.println("Frame is open!!");
			Thread.sleep(3000);
			WebElement source = driver.findElement(By.xpath("//img[contains(@src,'images/high_tatras_min.jpg')]"));
			WebElement target = driver.findElement(By.xpath("//div[contains(@id,'trash')]"));
			Thread.sleep(3000);
			act.dragAndDrop(source, target).build().perform();
			// act.clickAndHold(target).moveToElement(source).release().build().perform();
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
