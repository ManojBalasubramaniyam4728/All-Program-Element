package businessLogics;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
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

@Component("LIC7818_PJT1001_PE_NLP846b1a59-7328-42be-969d-7c2e36a5d3be")
public class Select_The_Text_From_The_Number_Of_Line_And_Copy_The_Value implements Nlp {
	@InputParams({ @InputParam(name = "xpath1", type = "java.lang.String"),
			@InputParam(name = "xpath2", type = "java.lang.String") })
	// @ReturnType(name = "string3", type = "java.lang.String")

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
		String xpath1 = (String) attributes.get("xpath1");
		String xpath2 = (String) attributes.get("xpath2");
		WebDriver driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
		try {
			Actions actn = new Actions(driver);
			WebElement element1 = driver.findElement(By.xpath(xpath1));
			WebElement element2 = driver.findElement(By.xpath(xpath2));
			actn.dragAndDrop(element1, element2).build().perform();
			Thread.sleep(1000);
			System.setProperty("java.awt.headless", "false");
			Robot robot = new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyPress(java.awt.event.KeyEvent.VK_C);
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyRelease(java.awt.event.KeyEvent.VK_C);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Select The Text From Element1 To Element2 And Copy The Value");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed move " + e);
		}
		return nlpResponseModel;
	}
}