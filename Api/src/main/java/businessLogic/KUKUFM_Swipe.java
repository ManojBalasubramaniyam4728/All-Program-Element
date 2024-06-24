package businessLogic;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class KUKUFM_Swipe 
{
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		//dc.setCapability(MobileCapabilityType.UDID, "RZ8TA03EJ7V");
		dc.setCapability("appPackage", "com.vlv.aravali");
		dc.setCapability("appActivity", "com.vlv.aravali.views.activities.SplashActivity");
		dc.setCapability("noReset", "true");
		dc.setCapability("platformName", "Android");
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, dc);
		Thread.sleep(10000);
		System.out.println("Opened the application");
		
		 int screenWidth = driver.manage().window().getSize().getWidth();
	        int screenHeight = driver.manage().window().getSize().getHeight();
	        
	        WebElement element1= driver.findElement(By.xpath("//android.widget.TextView[@text='T20 special']/.."));
	        WebElement element2= driver.findElement(By.xpath("//android.widget.TextView[@text='Top 20']/.."));
	        
	        Point element1Location=element1.getLocation();
	        Dimension element1Size=element1.getSize();
	        
	        Point element2Location=element2.getLocation();
	        Dimension element2Size=element2.getSize();
	        
	        int XCenterOfElement1=element1Location.getX()+element1Size.getWidth()/2;
	        int yCenterOfElement1=element1Location.getY()+element1Size.getHeight()/2;
	        
	        int XCenterOfElement2=element2Location.getX()+element2Size.getWidth()/2;
	        int yCenterOfElement2=element2Location.getY()+element2Size.getHeight()/2;
	        
	        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipe=new Sequence(finger, 1);
	        int max=4;
	        int count=0;
	        for (int i = count; i <max; i++) {
				
	        try {
	        	  WebElement element3= driver.findElement(By.xpath("//android.widget.TextView[@text='Investing']"));
	        	  if(element3.isDisplayed()) {
	        	      break;
	           }
	        }
	        	 catch (NoSuchElementException e) {
	        		 swipe.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), XCenterOfElement1, yCenterOfElement1));
	      	        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	      	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),PointerInput.Origin.viewport(), XCenterOfElement2, yCenterOfElement2));
	      	        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	      	        driver.perform(Arrays.asList(swipe));
			}
	        if (count>=max) {
				System.out.println("After Swipeing"+max+"also not able to find");
			}
	        
	        }
	
		
	}

}
