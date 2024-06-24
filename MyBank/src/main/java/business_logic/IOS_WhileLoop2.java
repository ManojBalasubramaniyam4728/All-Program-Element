
package business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;


import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLP53ed1b3c-cab7-42e4-bdbf-ae809b8e1382")
public class IOS_WhileLoop2 implements Nlp {
	@InputParams({ @InputParam(name = "StaticXpath", type = "java.lang.String"),
			@InputParam(name = "TextXpath", type = "java.lang.String"),
			@InputParam(name = "ExpectedText", type = "java.lang.String")})
	@ReturnType(name = "popUpTextTitle", type = "java.util.ArrayList")

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
		
		String staticXpath = (String) attributes.get("StaticXpath");
		String textXpath = (String) attributes.get("TextXpath");
		String expectedText = (String) attributes.get("ExpectedText");
		AppiumDriver driver = (IOSDriver) nlpRequestModel.getIosDriver();
		Boolean result=false;
		ArrayList<String> popUpTextTitle=new ArrayList<>();
		String actualText="";
		
		try {
				while (driver.findElement(By.xpath(staticXpath)).isDisplayed()) {
					Thread.sleep(1000);
					actualText=driver.findElement(By.xpath(textXpath)).getText();
					Thread.sleep(1000);
		        	popUpTextTitle.add(actualText);
		        	Thread.sleep(1000);
		        	result=actualText.trim().contains(expectedText);
		            if (result==true) {
					break;
				    }
		            driver.findElement(By.xpath(staticXpath)).click();
			       }
				 nlpResponseModel.setStatus(CommonConstants.pass);
	        	  nlpResponseModel.setMessage(actualText+" "+"Contains"+" "+expectedText );
				}
				catch(NoSuchElementException e) {
					 nlpResponseModel.setStatus(CommonConstants.pass);
		        	 nlpResponseModel.setMessage(staticXpath+" "+"Is Not There In The Application Screen");
				} 
		 catch (Exception e) {
			  nlpResponseModel.setStatus(CommonConstants.fail);
        	  nlpResponseModel.setMessage(actualText+" "+"Does not contains"+" "+expectedText+e);

		}
		nlpResponseModel.getAttributes().put("popUpTextTitle", popUpTextTitle);
		return nlpResponseModel;
	}
}