
package Business_Logics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

@Component("LIC12822_PJT1001_PE_NLP00b684fb-6b88-4b21-b816-ff11506517d8")
public class Verify_That_Cursor_Is_Focused_On implements Nlp {
	@InputParams({ @InputParam(name = "Xpath", type = "java.lang.String") })


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
		WebDriver driver=(WebDriver)nlpRequestModel.getWebDriver();
 
		try {
			 // Find the element
	        WebElement  element= driver.findElement(By.xpath(Xpath));

	        // Verify if the cursor is focused on the element
	        boolean isFocused = element.equals(driver.switchTo().activeElement());

	        // Output the result
	        if (isFocused==true) {
	        	nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Cursor Is Focused On The Element");
	        }
	        else {
	        	nlpResponseModel.setStatus(CommonConstants.fail);
				nlpResponseModel.setMessage("Cursor Is Not Focused On The Element");
	        }
		} 
		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Cursor Is Failed To Focused On The Element"+e);
		}

		return nlpResponseModel;
	}
}