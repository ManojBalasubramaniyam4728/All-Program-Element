
package business_Logic;

import com.amazonaws.services.simpledb.model.GetAttributesRequest;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component("LIC15066_PJT1001_PE_NLP5105df7b-bd06-4136-adc8-a744384c3349")
public class Verify_If_Element_Is_Displayed implements Nlp {
    @InputParams({@InputParam(name = "Element_To_Verify", type = "org.openqa.selenium.WebElement")})
   @ReturnType(name = "Is Displayed", type = "java.lang.Boolean")

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
          WebDriver  driver=(WebDriver)  nlpRequestModel.getWebDriver();
          String actualOrderID= null;
          WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
          JavascriptExecutor jse = (JavascriptExecutor)driver;
         Boolean  Is_Displayed= null;
           
          

          // Your program element business logic goes here ...
         
			try {
				 WebElement ele = (WebElement) attributes.get("Element_To_Verify");
				 Is_Displayed=ele.isDisplayed();
				 nlpResponseModel.setStatus(CommonConstants.pass);
		         nlpResponseModel.setMessage("Element is displayed");
				}catch (Exception e) {
					nlpResponseModel.setStatus(CommonConstants.pass);
			         nlpResponseModel.setMessage("Element is not displayed");
				}
				
          
         nlpResponseModel.getAttributes().put("Is Displayed", Is_Displayed);
          return nlpResponseModel;
      }
  } 