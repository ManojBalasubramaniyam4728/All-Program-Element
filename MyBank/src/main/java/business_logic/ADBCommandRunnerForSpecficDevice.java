package business_logic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.AndroidDriver;

import java.util.Map;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLP8e36e2e0-3faf-4971-9b3b-770345d3254f")
public class ADBCommandRunnerForSpecficDevice implements Nlp {
	@InputParams({ @InputParam(name = "UDID", type = "java.lang.String"),
			@InputParam(name = "Command", type = "java.lang.String") })

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
		String command = (String) attributes.get("Command");
		String udid = (String) attributes.get("UDID");

		try {
			AndroidDriver driver = nlpRequestModel.getAndroidDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			// Execute the command and get the process
			@SuppressWarnings("deprecation")
			Process process = Runtime.getRuntime().exec("adb -s " + udid + " " + command);

			if (udid.contains("75qgivvofqkb7lpj")) {
				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='Install']"))).click();
			}

			int exitCode = process.waitFor();

			if (exitCode == 0) {
				nlpResponseModel.setMessage("Successfully ADB Command runned on " + udid);
				nlpResponseModel.setStatus(CommonConstants.pass);
			} else {
				nlpResponseModel.setMessage("Failed to run ADB Command on " + udid);
				nlpResponseModel.setStatus(CommonConstants.fail);
			}
		} catch (Exception e) {
			nlpResponseModel.setMessage(e.getMessage());
			nlpResponseModel.setStatus(CommonConstants.fail);
		}

		return nlpResponseModel;
	}
}