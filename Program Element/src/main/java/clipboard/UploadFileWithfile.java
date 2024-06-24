
package clipboard;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import java.util.Map;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP1b5b9bdd-fec8-402b-9728-f40ef39c4858")
public class UploadFileWithfile implements Nlp {
	@InputParams({ @InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
	 @InputParam(name = "elementName", type = "java.lang.String"),
	 @InputParam(name = "elementType", type = "java.lang.String"),
	 @InputParam(name = "Filepath", type = "java.lang.String")})
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
		WebElement element = (WebElement) attributes.get("element");
		 String Filepath = (String) attributes.get("Filepath");

		try {
			System.setProperty("java.awt.headless", "false");
			 WebDriver driver= (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
			 StringSelection stringSelection = new StringSelection(Filepath);
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			 Robot robot = null;
			 Actions act = new Actions(driver);
			 act.click(element).perform();
			 robot = new Robot();
			 robot.delay(7000);
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 robot.keyRelease(KeyEvent.VK_V);
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.delay(150);
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.keyRelease(KeyEvent.VK_ENTER);
			
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Uploaded ");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Uploaded");

		}
		// String string3 = "Return Value";
		// nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}