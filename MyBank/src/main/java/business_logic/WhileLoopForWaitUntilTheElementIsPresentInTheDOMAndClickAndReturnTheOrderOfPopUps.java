
package business_logic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
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
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.android.AndroidDriver;


import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLP2cf356bc-7730-4b24-99e1-3a30af82338a")
public class WhileLoopForWaitUntilTheElementIsPresentInTheDOMAndClickAndReturnTheOrderOfPopUps implements Nlp {
	@InputParams({ @InputParam(name = "Xpath To Tap On Element", type = "java.lang.String"),
			@InputParam(name = "Xpath To Return Text From The Element", type = "java.lang.String"),
			@InputParam(name = "Explicit Wait", type = "java.lang.Integer") })
	@ReturnType(name = "Assign Step Return Value To", type = "java.util.ArrayList")

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
		String xpathToReturnTextFromTheElement = (String) attributes.get("Xpath To Return Text From The Element");
		int explicitWait = (int) attributes.get("Explicit Wait");

		// Your program element business logic goes here ...
		ArrayList<String> arrayList = new ArrayList<String>();
	
		try {
			AndroidDriver driver = nlpRequestModel.getAndroidDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));

			try {
				while (driver.findElement(By.xpath(xpathToTapOnElement)).isDisplayed()) {
					String getText = driver.findElement(By.xpath(xpathToReturnTextFromTheElement)).getText();
					arrayList.add(getText);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathToTapOnElement))).click();
				}
			} catch (NoSuchElementException e) {
				Collections.reverse(arrayList);
				int count=arrayList.size();
				nlpResponseModel.setMessage("Total number of popups is " + count + " and result is " + arrayList);
				nlpResponseModel.setStatus(CommonConstants.pass);
			}

		} catch (Exception e) {
			nlpResponseModel.setMessage(e.getMessage());
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		nlpResponseModel.getAttributes().put("Assign Step Return Value To", arrayList);
		return nlpResponseModel;
	}

}