package business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.AppiumDriver;


import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLP2663f7ed-d07b-4f6d-a3be-4b86f49562f9")
public class IOS_IsDisplayedornot implements Nlp {
	@InputParams({ @InputParam(name = "stringXpath", type = "java.lang.String") })
	@ReturnType(name = "getBoolean", type = "java.lang.Boolean")

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
		
		AppiumDriver driver = (AppiumDriver) nlpRequestModel.getIosDriver();
		String stringXpath = (String) attributes.get("stringXpath");
		Boolean IsDisplayed = null;

		try {
			 try{
	                WebElement stringElement = driver.findElement(By.xpath(stringXpath));
	                if(Objects.nonNull(stringElement)) {
	                } else {
	                    nlpResponseModel.setStatus(CommonConstants.pass);
	                    nlpResponseModel.setMessage(stringElement + " " + " not found in first block");
	                }
	            } catch (NoSuchElementException e) {
	                nlpResponseModel.setStatus(CommonConstants.pass);
	                nlpResponseModel.setMessage(stringXpath + " " + " Not found");
	            } catch (Exception e) {
	                nlpResponseModel.setStatus(CommonConstants.pass);
	                nlpResponseModel.setMessage(stringXpath + " " + " Not found");
	            }
					IsDisplayed =driver.findElement(By.xpath(stringXpath)).isDisplayed();
		             IsDisplayed=true;
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Element Is Dispalyed In WebPage");
				} catch (Exception e) {
					IsDisplayed = false;
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Element Is Not Dispalyed In WebPage");
				}

		nlpResponseModel.getAttributes().put("getBoolean", IsDisplayed);
		return nlpResponseModel;
	}
}

