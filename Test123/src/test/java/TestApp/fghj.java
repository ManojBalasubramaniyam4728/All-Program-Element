package TestApp;



import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class fghj {

    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        // Specify your device details
        capabilities.setCapability("deviceName", "Galaxy A13");
        capabilities.setCapability("platformName", "Android");

        // Specify the path to your APK file or app package name
        capabilities.setCapability("appPackage", "com.dpm.DPMApp");
        capabilities.setCapability("appActivity", "com.dpm.DPMApp.MainActivity"); // Activity to launch

        // Initialize the Android driver using Appium server URL and capabilities
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        Thread.sleep(5000);
     
    }
}


