package DilerPack;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class cDilerMain {

	public static RemoteWebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus_5_API_28");	
		capabilities.setCapability("udid", "emulator-5554");		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9");	
		capabilities.setCapability("appPackage", "com.google.android.dialer");
		capabilities.setCapability("appActivity", "com.android.dialer.app.DialtactsActivity");
				
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		
		
		driver = new RemoteWebDriver(url, capabilities);		
			    		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.print("Application started");
		
		Thread.sleep(5000);		
						
		WebElement Element = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"key pad\"]"));
		
		Element.click();	
		
		Thread.sleep(5000);
		
		driver.quit();	
		
		
		System.out.print(System.lineSeparator() + "The END");

	}

}
