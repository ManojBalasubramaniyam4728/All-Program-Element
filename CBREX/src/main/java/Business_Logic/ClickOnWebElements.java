package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

@Component("LIC10506_PJT1001_PE_NLP338a181c-b9d2-457b-a7d6-2c2ce904eb19")
public class ClickOnWebElements implements Nlp {
	@InputParams({ @InputParam(name = "Xpath", type = "java.lang.String"),
			@InputParam(name = "Size Of Elements", type = "java.lang.Integer") })

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
		Integer size1 = (Integer) attributes.get("Size Of Elements");
		WebDriver driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
		try {

			for (int i = 1; i <= size1; i++) {
				WebElement Options = driver.findElement(By.xpath("(" + Xpath + ")[" + (i) + "]"));

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", Options);
				Thread.sleep(1000);
				Actions actn = new Actions(driver);
				Thread.sleep(1000);
				actn.moveToElement(Options).build().perform();
			    executor.executeScript("arguments[0].click();", Options);
				
			//	actn.click(Options).build().perform();
				Thread.sleep(1000);
			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Clicked Element");

		}

		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed Tso Click On Element " + e);

		}
		return nlpResponseModel;
	}
}