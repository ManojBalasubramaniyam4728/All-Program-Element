
package Bussiness_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;



import org.springframework.stereotype.Component;

@Component("LIC15856_PJT1001_PE_NLPa6deb63c-d572-43a9-b11e-5b1fef67d050")
public class ClickOnElement implements Nlp {
    @InputParams({@InputParam(name = "xpath", type = "java.lang.String"),
             	@InputParam(name = "element", type = "org.openqa.selenium.WebElement")})
    

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
          String xpath = (String) attributes.get("xpath");
          WebElement element = (WebElement) attributes.get("element");
          WebDriver driver=(WebDriver)nlpRequestModel.getAndroidDriver();
          
           try {
        	 driver.findElement(By.xpath(xpath)).click();
			 nlpResponseModel.setStatus(CommonConstants.pass);
             nlpResponseModel.setMessage("Successfully Clicked On The locator"+xpath+"");
		}
           catch (NoSuchElementException e) {
        	   element.click();
			 nlpResponseModel.setStatus(CommonConstants.pass);
             nlpResponseModel.setMessage("Successfully Clicked On The element"+element+"");
           }
           
           catch (Exception e) {
        	   element.click();
			 nlpResponseModel.setStatus(CommonConstants.fail);
             nlpResponseModel.setMessage("Failed To Click On The element as well as Locator"+element+" "+xpath+" "+e);
           }
           
          return nlpResponseModel;
      }
  } 
