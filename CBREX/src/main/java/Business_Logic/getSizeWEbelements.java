package Business_Logic;

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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC10506_PJT1001_PE_NLP55c39a2e-0255-446e-8251-04200e035e84")
public class getSizeWEbelements implements Nlp {
	@InputParams({ @InputParam(name = "Xpath", type = "java.lang.String") })
	@ReturnType(name = "SizeOfElement", type = "java.lang.Integer")

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
		WebDriver driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
		Integer size1 = 0;
		try {
			List<WebElement> element = driver.findElements(By.xpath(Xpath));
			size1 = element.size();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Size of Web Elements is " + size1);
		}

		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to get size of webelements" + e);

		}
		nlpResponseModel.getAttributes().put("SizeOfElement", size1);
		return nlpResponseModel;
	}
}