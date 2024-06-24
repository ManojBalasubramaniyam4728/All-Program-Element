package Bussiness_Logic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


@Component("LIC15856_PJT1001_PE_NLPfc9fd5c5-3d31-4f8b-81ae-7a2481ba5b3b")
public class ElementisDispalyed_Or_Not implements Nlp {
	@InputParams({ @InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
			@InputParam(name = "elementType", type = "java.lang.String"),
			@InputParam(name = "elementName", type = "java.lang.String") })
	@ReturnType(name = "IsDisplayed", type = "java.lang.Boolean")

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
		WebElement element = (WebElement) attributes.get("element");
		String elementType = (String) attributes.get("elementType");
		String elementName = (String) attributes.get("elementName");
		Boolean IsDisplayed = null;
		try {

			IsDisplayed = element.isDisplayed();
			IsDisplayed = true;
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage(elementName + " " + elementType + " is Displayed on the page  ");
		} catch (Exception e) {
			IsDisplayed = false;
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage(elementName + " " + elementType + " is not Displayed on the page ");

		}

		nlpResponseModel.getAttributes().put("IsDisplayed", IsDisplayed);
		return nlpResponseModel;
	}
}