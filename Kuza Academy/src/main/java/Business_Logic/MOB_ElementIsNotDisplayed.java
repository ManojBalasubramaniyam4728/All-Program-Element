
package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

@Component("LIC14333_PJT1001_PE_NLP847ebeb1-a0b9-4c6d-9e1c-eee662d9e9a6")
public class MOB_ElementIsNotDisplayed implements Nlp {
	@InputParams({ @InputParam(name = "Xpath", type = "java.lang.String") })
	@ReturnType(name = "isNotDisplayed", type = "java.lang.Boolean")

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
		String Xpath = (String) attributes.get("Xpath");
		Boolean isNotDisplayed = false;

		// Your program element business logic goes here ...
		
		try {
			WebDriver driver = (WebDriver) nlpRequestModel.getAndroidDriver();
			if (driver.findElement(By.xpath(Xpath)).isDisplayed()) {
				isNotDisplayed = false;
				nlpResponseModel.setMessage("Element is displayed");
				nlpResponseModel.setStatus(CommonConstants.fail);
			}

		} catch (Exception e) {
			isNotDisplayed = true;
			nlpResponseModel.setMessage("Element is  not displayed");
			nlpResponseModel.setStatus(CommonConstants.pass);

		}

		nlpResponseModel.getAttributes().put("isNotDisplayed", isNotDisplayed);
		return nlpResponseModel;
	}
}