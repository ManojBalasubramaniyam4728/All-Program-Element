
package Business_Logic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;


import org.springframework.stereotype.Component;

@Component("LIC15384_PJT1001_PE_NLPd618c1fd-9fbc-4cbc-929e-de4ce4301ec9")
public class Wait_Till_The_VPN_Is_Fully_Connected implements Nlp {
    @InputParams({@InputParam(name = "xpath", type = "java.lang.String"),
    	@InputParam(name = "explicitWaitTime", type = "java.lang.Integer")})

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
          Integer explicitWaitTime = (Integer) attributes.get("explicitWaitTime");
          WebDriver driver=(WebDriver) nlpRequestModel.getWebDriver();
          try {
             WebDriverWait wiat =new WebDriverWait(driver, Duration.ofSeconds(explicitWaitTime));
            for(int i=1; i<=5;i++) {
              try {
              	wiat.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
      		 break;
              }
              catch (TimeoutException e) {
              	driver.navigate().refresh();
      		     }
              }
            nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Waited Till The VPN Is Fully Connect");
		} 
          catch (Exception e) {
        	nlpResponseModel.setStatus(CommonConstants.fail);
  			nlpResponseModel.setMessage("Failed To Waited Till The VPN Is Fully Connect"+e);
		  }
          return nlpResponseModel;
      }
  } 