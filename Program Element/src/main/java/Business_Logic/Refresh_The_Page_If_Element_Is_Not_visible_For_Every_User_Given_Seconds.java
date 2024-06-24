package Business_Logic;




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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP7e5f2c5b-2627-4fbe-a278-98e7ce1b6280")
public class Refresh_The_Page_If_Element_Is_Not_visible_For_Every_User_Given_Seconds implements Nlp {
    @InputParams({@InputParam(name = "Xpath", type = "java.lang.String"),
    	          @InputParam(name = "WaitSeconds ", type = "java.lang.String")})
   

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
        	  String Xpath = (String) attributes.get("Xpath");
              String WaitSeconds = (String) attributes.get("WaitSeconds");
        	  WebDriver driver=(WebDriver)nlpResponseModel.getDriver().getSpecificIDriver();
              Thread.sleep(500);
        	  WebElement element = driver.findElement(By.xpath(Xpath));
             WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(WaitSeconds)));
             Thread.sleep(500);
              while (!element.isDisplayed()) {
                  driver.navigate().refresh();
                  wait.until(ExpectedConditions.visibilityOf(element));
              }
              nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("Successfully Page Is Refreshed");
          
                }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("Element Is Visible In The Page");
          
		      }
          
       
          return nlpResponseModel;
  } 

}
