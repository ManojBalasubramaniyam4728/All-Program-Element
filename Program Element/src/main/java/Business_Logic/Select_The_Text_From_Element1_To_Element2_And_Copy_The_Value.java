package Business_Logic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

@Component("LIC8536_PJT1001_PE_NLPc6cb9b2a-a028-4830-808d-1f8d1fa26f65")
public class Select_The_Text_From_Element1_To_Element2_And_Copy_The_Value implements Nlp {
	@InputParams({ @InputParam(name = "element1", type = "org.openqa.selenium.WebElement"),
			@InputParam(name = "element2", type = "org.openqa.selenium.WebElement") })

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

		try {
			WebDriver driver=(WebDriver)nlpResponseModel.getDriver().getSpecificIDriver();
			WebElement element1 = (WebElement) attributes.get("element1");
			WebElement element2 = (WebElement) attributes.get("element2");
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			element1.click();
			Thread.sleep(1000);
			action.moveToElement(element1).clickAndHold().moveToElement(element2).release().build().perform();
			Thread.sleep(1000);
			action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Select The Text From Element1 To Element2 And Copy The Value");

		}

		catch (Exception e) {

			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Select The Text From Element1 To Element2 And Copy The Value"+e);

		}

		
		return nlpResponseModel;
	}
}