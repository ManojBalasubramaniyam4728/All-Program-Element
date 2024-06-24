
package Business_Logic;

import java.util.ArrayList; 
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

@Component("LIC11364_PJT1001_PE_NLP03a09330-0b66-43db-8f17-206148a1a557")
public class Verify_Added_Action_In_Teams implements Nlp {
	@InputParams({ @InputParam(name = "size", type = "java.lang.Integer"),
			@InputParam(name = "Xpath", type = "java.lang.String"),
			@InputParam(name = "NextPage", type = "org.openqa.selenium.WebElement") })

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
			Integer size = (Integer) attributes.get("size");
			String Xpath = (String) attributes.get("Xpath");
			WebElement NextPage = (WebElement) attributes.get("NextPage");
			WebDriver driver=(WebDriver) nlpRequestModel.getWebDriver();
			
			WebElement element=driver.findElement(By.xpath(Xpath));
			
			for (int i = 0; i <= size; i++) {
				try {
					if (element.isDisplayed()) {
						Thread.sleep(500);
						JavascriptExecutor scroll=(JavascriptExecutor)driver;
				    	 scroll.executeScript("arguments[0].scrollIntoView(true);", element);
				    	 Thread.sleep(500);
						element.click();
						break;
					}
				} catch (Exception e) {
					JavascriptExecutor scroll=(JavascriptExecutor)driver;
			    	 scroll.executeScript("arguments[0].scrollIntoView(true);", NextPage);
			    	 Thread.sleep(500);
			    	 NextPage.click();
				}

			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Findelement And Click On It");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Field To Findelement And Click On It"+e);
		}
		return nlpResponseModel;
	}
}