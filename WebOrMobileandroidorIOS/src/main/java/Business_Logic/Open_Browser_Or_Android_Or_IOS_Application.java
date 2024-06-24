
package Business_Logic;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

@Component("LIC3168_PJT1031_PE_NLP8112ab69-1bcc-4682-8ed7-902bc8c2d4cb")
public class Open_Browser_Or_Android_Or_IOS_Application implements Nlp {
	@InputParams({ @InputParam(name = "appPackage", type = "java.lang.String"),
			@InputParam(name = "appActivity", type = "java.lang.String"),
			@InputParam(name = "bundleId", type = "java.lang.String"),
			@InputParam(name = "noReset", type = "java.lang.Boolean"),
			@InputParam(name = "MOBUrl", type = "java.lang.String") })

	@Override
	public List<String> getTestParameters() throws NlpException {
		List<String> params = new ArrayList<>();
		return params;
	}

	@Override
	public StringBuilder getTestCode() throws NlpException {
		StringBuilder sb = new StringBuilder();
		return sb;
	}

	public static DesiredCapabilities launchAndroidApp(String appPackage, String appActivity, Boolean noReset) {
		DesiredCapabilities androidCaps = new DesiredCapabilities();

		androidCaps.setCapability("platformName", "Android");
		androidCaps.setCapability("appPackage", appPackage);
		androidCaps.setCapability("appActivity", appActivity);
		androidCaps.setCapability("noReset", noReset);
		return androidCaps;
	}

	public static DesiredCapabilities launchiOSApp(String bundleId, Boolean noReset) {
		DesiredCapabilities iosCaps = new DesiredCapabilities();
		iosCaps.setCapability("platformName", "iOS");
		iosCaps.setCapability("bundleId", bundleId);
		iosCaps.setCapability("noReset", noReset);
		return iosCaps;
	}

	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> programElementsInput = nlpRequestModel.getAttributes();
		String appPackage = (String) programElementsInput.get("appPackage");
		String appActivity = (String) programElementsInput.get("appActivity");
		String bundleId = (String) programElementsInput.get("bundleId");
		Boolean noReset = (Boolean) programElementsInput.get("noReset");
		String MOBUrl = (String) programElementsInput.get("MOBUrl");
		WebDriver driver = null;

		try {
			
			try {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try {
			DesiredCapabilities androidCaps = launchAndroidApp(appPackage, appActivity, noReset);
			driver = new AndroidDriver(new URL(MOBUrl), androidCaps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
			DesiredCapabilities iosCaps = launchiOSApp(bundleId, noReset);
			driver = new IOSDriver(new URL(MOBUrl), iosCaps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			
			nlpResponseModel.setWebDriver(driver);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Opened the browser or App ");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to due to : " + e);
		}

		return nlpResponseModel;
	}
}