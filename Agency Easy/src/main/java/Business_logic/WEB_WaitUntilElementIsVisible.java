package Business_logic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;


@Component("LIC12844_PJT1001_PE_NLP796a494a-23bc-4aaf-85b5-672284c641d8")
public class WEB_WaitUntilElementIsVisible implements Nlp {
	@InputParams({ @InputParam(name = "Xpath", type = "java.lang.String"),
		@InputParam(name = "Wait", type = "java.lang.Integer") })

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
		Integer Wait = (Integer) attributes.get("Wait");

		try {
			WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
			new WebDriverWait(driver, Duration.ofSeconds(Wait))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));

			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("waited successfully until element is visible ");

		} 
		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to wait until element is visible");
		}

		return nlpResponseModel;
	}
}

