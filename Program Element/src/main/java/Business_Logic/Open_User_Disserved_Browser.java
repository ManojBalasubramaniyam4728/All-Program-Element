package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP746c1c1d-fabd-41ed-b2f4-d0d3967e8920")
public class Open_User_Disserved_Browser implements Nlp {

	@InputParams({ @InputParam(name = "DriverPath", type = "java.lang.String"),
			@InputParam(name = "BrowserName", type = "java.lang.String") })

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
		String driverPath = (String) attributes.get("DriverPath");
		String browserName = (String) attributes.get("BrowserName");
		WebDriver driver = null;
		try {
			// This For Chrome
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", driverPath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");// Allow cross-origin requests
				driver = new ChromeDriver(options);
				nlpResponseModel.setWebDriver(driver);
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Successfully Opened Chrome Browser");
			}
			// This For Firefox
			else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", driverPath);
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference("security.fileuri.strict_origin_policy", false); // Allow cross-origin requests
				driver = new FirefoxDriver(options);
				nlpResponseModel.setWebDriver(driver);
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Successfully Opened Firefox Browser");
			}
			// This For Edge
			else if (browserName.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver", driverPath);
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--remote-allow-origins=*");// Allow cross-origin requests
				driver = new EdgeDriver(options);
				nlpResponseModel.setWebDriver(driver);
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Successfully Opened Edge Browser");
			}
		}

		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Open User Disserved Browser"+e);
		}

		return nlpResponseModel;
	}
}
