package ResumeUpdate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

# Dharesh Latest git Push
Here my snippet code helps lazy and smart people who want to update their Naukri portal profile regularly with 0 effort by login to
	the profile every day but just running my code can able to upload their Resume in any format 

		
@Test
public class UpdateNaukriProfile {
	WebDriver driver;

	@BeforeMethod
	public void Weblaunch() {
		System.setProperty("webdriver.chrome.driver", "./softwaree/chromedriver23.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/mnjuser/homepage");
	}

	@Test(invocationCount = 1, groups = { "naukriResumeUpdates" })
	public void NaukriUpdate() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("usernameField")).sendKeys("please enter Naukri user name here/mail id");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("please enter your Naukri password");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement viewProfile = driver.findElement(By.xpath("//div[@class='view-profile-wrapper']"));
			wait.until(ExpectedConditions.visibilityOf(viewProfile));
			viewProfile.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebElement k = driver.findElement(By.id("attachCV"));
			Actions act = new Actions(driver);
			act.moveToElement(k).perform();
			Thread.sleep(5000);
			k.sendKeys(
					"Please provide your resume location here to upload your CV(ex:E:\\Resume\\updateQAResume23p.pdf)");
			System.out.println("Resume Updated");

		} catch (Exception e) {
			System.out.println("Handled main code");
		} finally {
			driver.quit();
		}
	}
}
