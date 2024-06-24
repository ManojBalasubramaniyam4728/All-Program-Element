package Bussiness_Logics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

@Component("LIC15257_PJT1002_PE_NLP33dc31c0-9667-4cd4-92ce-462ae4608098")
public class verifyCaptcha implements Nlp {

	@InputParams({@InputParam(name = "Xpath1", type = "java.lang.String"),
		@InputParam(name = "Xpath2", type = "java.lang.String")})
	@ReturnType(name = "Value", type = "java.lang.String")

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

		String xpath1 = (String) attributes.get("Xpath1");
		String xpath2 = (String) attributes.get("Xpath2");
		WebDriver driver=(WebDriver)nlpRequestModel.getWebDriver();

		String Value = "";
		try {
			WebElement ele1=driver.findElement(By.xpath(xpath1));
			WebElement ele2=driver.findElement(By.xpath(xpath2));		
			String txt1 = ele1.getDomProperty("value");
			String txt2 = ele2.getDomProperty("value");



			Integer value1 = Integer.parseInt(txt1);
			Integer value2 = Integer.parseInt(txt2);

			Integer Result = value1+value2;
			Value = Result+" ";



			nlpResponseModel.setMessage("Digits added successfully " + Value);
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("Digits not added successfully" + e);
			nlpResponseModel.setStatus(CommonConstants.fail);
		}

		nlpResponseModel.getAttributes().put("Value", Value);
		return nlpResponseModel;
	}
}
