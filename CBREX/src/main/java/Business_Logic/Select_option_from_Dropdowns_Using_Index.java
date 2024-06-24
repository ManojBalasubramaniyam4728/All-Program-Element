package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

@Component("LIC10506_PJT1001_PE_NLP80faa6e5-79d6-432f-86bd-1d60ced364f5")
public class Select_option_from_Dropdowns_Using_Index implements Nlp {
	@InputParams({ @InputParam(name = "Xpath", type = "java.lang.String"),
			@InputParam(name = "Index", type = "java.lang.Integer"),
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
		Integer Index = (Integer) attributes.get("Index");
		Integer size1 = (Integer) attributes.get("Size Of Elements");
		WebDriver driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
		try {
			Actions actn = new Actions(driver);
			for (int i = 1; i <= size1; i++) {
				WebElement dropdown = driver.findElement(By.xpath("(" + Xpath + ")[" + (i) + "]"));
				actn.moveToElement(dropdown).build().perform();
				Thread.sleep(1000);
				Select select = new Select(dropdown);
				select.selectByIndex(Index);
			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Selected Option");

		}

		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Select Option" + e);

		}
		return nlpResponseModel;
	}
}
