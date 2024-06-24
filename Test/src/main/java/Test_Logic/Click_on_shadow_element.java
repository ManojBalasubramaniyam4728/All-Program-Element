package Test_Logic;

import java.util.ArrayList; 
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.github.sukgu.Shadow;


import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1007_PE_NLP7a145a84-63f4-4e72-9572-7f79ac6d7334")
public class Click_on_shadow_element implements Nlp {
	@InputParams({@InputParam(name="xpath", type = "java.lang.String")})

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
		String xpath =(String)attributes.get("xpath");
		
		try {
			WebDriver driver = nlpRequestModel.getWebDriver();
			Shadow S = new Shadow(driver);
			
			S.findElementByXPath(xpath).click();

			nlpResponseModel.setMessage("Successfully Clicked on Shadow element");
			nlpResponseModel.setStatus(CommonConstants.pass);

		}catch(Throwable e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to handled Shadow element " + e);
		} 
		return nlpResponseModel;
	}
}