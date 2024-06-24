
package business_logic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.AndroidDriver;

import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLPa6a877f1-d8ad-48b0-abc8-2a2b19a26cd2")
public class ClickOnElementUntilTheExpectedPopupIsVisible implements Nlp {
	@InputParams({ @InputParam(name = "Xpath To Tap On Element", type = "java.lang.String"),
			@InputParam(name = "Xpath To Pop-Up", type = "java.lang.String"),
			@InputParam(name = "Explicit Wait", type = "java.lang.Integer"),
			@InputParam(name = "Text To Verify With Pop-Up", type = "java.lang.String") })
	

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
		String xpathToTapOnElement = (String) attributes.get("Xpath To Tap On Element");
		String xpathToPopUp = (String) attributes.get("Xpath To Pop-Up");
		int explicitWait = (int) attributes.get("Explicit Wait");
		String textToVerifyWithPopUp = (String) attributes.get("Text To Verify With Pop-Up");

		// Your program element business logic goes here ...

		try {
			AndroidDriver driver =  nlpRequestModel.getAndroidDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
			try {
				boolean Cond=true;
				while (Cond==true) {
					if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathToPopUp))).getText().contains(textToVerifyWithPopUp)) {
						Cond=false;
					}
					else
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathToTapOnElement))).click();
				}
				if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathToPopUp))).getText().contains(textToVerifyWithPopUp)) {
					nlpResponseModel.setMessage("Successfully got the Expected Pop-up");
					nlpResponseModel.setStatus(CommonConstants.pass);
				}
				else {
					nlpResponseModel.setMessage("Failed to get the Expected the Pop-up");
					nlpResponseModel.setStatus(CommonConstants.fail);
				}
			} catch (NoSuchElementException e) {
				if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathToPopUp))).getText().contains(textToVerifyWithPopUp)) {
					nlpResponseModel.setMessage("Successfully got the Expected Pop-up");
					nlpResponseModel.setStatus(CommonConstants.pass);
				}
				else {
					nlpResponseModel.setMessage("Failed to get the Expected the Pop-up");
					nlpResponseModel.setStatus(CommonConstants.fail);
				}
			}
		} catch (Exception e) {
			nlpResponseModel.setMessage(e.getMessage());
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		
		return nlpResponseModel;
	}

}