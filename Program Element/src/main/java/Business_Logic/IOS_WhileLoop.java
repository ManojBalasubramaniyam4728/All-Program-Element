
package Business_Logic;

import java.util.ArrayList; 
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP9bd6f281-2020-4b57-8257-7311ff42bcd4")
public class IOS_WhileLoop implements Nlp {
	@InputParams({ @InputParam(name = "StaticXpath", type = "java.lang.String"),
			@InputParam(name = "TextXpath", type = "java.lang.String"),
			@InputParam(name = "ExpectedText", type = "java.lang.String") })
	@ReturnType(name = "popUpTextTitle", type = "java.util.ArrayList")

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

		String staticXpath = (String) attributes.get("StaticXpath");
		String textXpath = (String) attributes.get("TextXpath");
		String expectedText = (String) attributes.get("ExpectedText");
		AppiumDriver driver = (AppiumDriver) nlpRequestModel.getIosDriver();
		Boolean result = false;
		ArrayList<String> popUpTextTitle = new ArrayList<>();

		try {
			while (driver.findElement(By.xpath(staticXpath)).isDisplayed()) {
			//	log.info(staticXpath + "elemnet is displayed");
				String actualText = driver.findElement(By.xpath(textXpath)).getText();
				//log.info("actual Text is" + actualText);
				popUpTextTitle.add(actualText);
				//log.info("Successfully add the List");
				result = actualText.contains(expectedText);
				//log.info("The result is" + result);
				if (result == true) {
					break;
				}
				driver.findElement(By.xpath(staticXpath)).click();
				//log.info("Successfully clicked on" + staticXpath);
			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("actualText" + " " + "Contains" + " " + expectedText);
		} catch (NoSuchElementException e) {
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage(staticXpath + " " + "Is Not There In The Application Screen");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("actualText" + " " + "Does not contains" + " " + expectedText + e);

		}
		nlpResponseModel.getAttributes().put("popUpTextTitle", popUpTextTitle);
		return nlpResponseModel;
	}
}