package realDevicePack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class cMain {

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Mi Phone");	
		capabilities.setCapability("udid", "7e81c476");		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10");	
		//capabilities.setCapability("appPackage", "com.google.android.dialer");
		//capabilities.setCapability("appActivity", "com.android.dialer.app.DialtactsActivity");
		capabilities.setCapability("appPackage", "com.miui.calculator");
		capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
				
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		
		
		RemoteWebDriver driver =  new RemoteWebDriver(url, capabilities);	
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.print("Application started");
		
		//Thread.sleep(5000);
		
		WebElement Element = driver.findElement(By.xpath("//android.widget.TextView[4]"));
		
		Element.click();
		
		Thread.sleep(5000);
		
		driver.quit();	
		
		
		System.out.print(System.lineSeparator() + "The END");

	}

}
