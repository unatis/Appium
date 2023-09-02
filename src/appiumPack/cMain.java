package appiumPack;

//https://search.maven.org/search?q=g:io.appium%20AND%20a:java-client
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class cMain {

	//public static RemoteWebDriver driver;
		
	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus_5_API_28");	
		capabilities.setCapability("udid", "emulator-5554");		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9");	
		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
						
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		
		
		RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);		
			    		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.print("Application started");
		
		Thread.sleep(5000);		
						
		WebElement Element = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[3]"));
		
		Element.click();
		
		WebElement Element2 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"plus\"]"));
		
		Element2.click();
				
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[7]")).click();
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"equals\"]")).click();
		
		String TextFound = driver.findElement(By.id("com.google.android.calculator:id/result_final"))).getText();
		if(TextFound.contains("10")) 
		{
			System.out.print(System.lineSeparator() + "Result is correct " + TextFound);
		}
		else {
			System.out.print(System.lineSeparator() + "Result is NOT correct " + TextFound);
		}
		
		
		Thread.sleep(5000);		
		
		driver.quit();
		
		System.out.print(System.lineSeparator() + "The END");

	}

}
