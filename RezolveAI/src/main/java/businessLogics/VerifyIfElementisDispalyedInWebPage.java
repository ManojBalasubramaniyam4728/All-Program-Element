package businessLogics;




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

@Component("LIC7818_PJT1001_PE_NLP3206ce23-7702-4888-8a5f-b303a2fe2d93")
public class VerifyIfElementisDispalyedInWebPage implements Nlp {
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

		Boolean IsDisplayed = null;
		try {
			WebElement element = (WebElement) attributes.get("element");
			IsDisplayed = element.isDisplayed();
             IsDisplayed=true;
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Element Is Dispalyed In WebPage");
		} catch (Exception e) {
			IsDisplayed = false;
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Element Is Not Dispalyed In WebPage");

		}

		nlpResponseModel.getAttributes().put("IsDisplayed", IsDisplayed);
		return nlpResponseModel;
	}
}