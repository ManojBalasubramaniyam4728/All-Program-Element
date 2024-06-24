package Business_Logic;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.android.AndroidDriver;

@Component("LIC4966_PJT1001_PE_NLP56a6b6e0-a6a4-4191-9a87-24e0a4c9044d")
public class Mob_OpenApplication implements Nlp {
	@InputParams({@InputParam(name = "udid", type = "java.lang.String") , @InputParam(name = "AppPackage", type = "java.lang.String") , @InputParam(name = "AppActivity", type = "java.lang.String")})

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
	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		String udid = (String) attributes.get("udid");
		String AppPackage = (String) attributes.get("AppPackage");
		String AppActivity = (String) attributes.get("AppActivity");
		AndroidDriver driver=null;

		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName","Android");
			cap.setCapability("udid", udid);
			cap.setCapability("appPackage", AppPackage);
			cap.setCapability("appActivity", AppActivity);
			cap.setCapability("noReset",true);

			URL url = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver(url,cap);
			Thread.sleep(5000);
			nlpResponseModel.setAndroidDriver(driver);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Application Opened Successfully");	
		}
		catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Create Driver Instance");
		}
     
		return nlpResponseModel;
	}
} 