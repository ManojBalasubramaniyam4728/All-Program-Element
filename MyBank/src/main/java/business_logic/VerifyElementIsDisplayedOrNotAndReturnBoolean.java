package business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLP38cce18e-efed-4e80-b719-9780cb65a12b")
public class VerifyElementIsDisplayedOrNotAndReturnBoolean implements Nlp {
	@InputParams({ @InputParam(name = "Element", type = "org.openqa.selenium.WebElement") })
	@ReturnType(name = "Assign Step Return Value To", type = "java.lang.Boolean")

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
		Boolean isDisplayed = null;
		try {
			WebElement element = (WebElement) attributes.get("Element");
			isDisplayed = element.isDisplayed();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Element is Displayed");
		} catch (Exception e) {
			isDisplayed=false;
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Element is not Displayed");
		}
		
		nlpResponseModel.getAttributes().put("Assign Step Return Value To", isDisplayed);
		return nlpResponseModel;
	}
}