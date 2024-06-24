
package businessLogics;

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

@Component("LIC7818_PJT1001_PE_NLP9d31860e-eea6-4e5c-a1de-96756fa77700")
public class Clicking_On_Searched_Ticket_Number implements Nlp {
    @InputParams({@InputParam(name = "Xpath", type = "java.lang.String")})
 
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
          try {
			WebDriver driver=(WebDriver)nlpRequestModel.getWebDriver();
			List<WebElement> elements=driver.findElements(By.xpath(Xpath));
			for (WebElement webElement : elements) {
				String text=webElement.getText();
				if(text.contains("1"));
				Thread.sleep(3000);
				WebElement ele1=driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='"+1+"']"));
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].click();", ele1);
				break;
			      }
			 nlpResponseModel.setStatus(CommonConstants.pass);
       	     nlpResponseModel.setMessage("Successfully Clicked On Searched Tectfield");
			
		} 
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
        	   nlpResponseModel.setMessage("Failed To Clicked On Searched Tectfield");
		}
  
          return nlpResponseModel;
      }
  } 