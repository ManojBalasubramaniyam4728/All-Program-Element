package Business_Logic;


import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;  
import com.tyss.optimize.nlp.util.annotation.InputParam;  
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;    
import java.util.List;    
import org.springframework.stereotype.Component;
import com.tyss.optimize.nlp.util.*;
import com.tyss.optimize.common.util.CommonConstants;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

 
@Component("LIC9512_PJT1001_PE_NLP48938b09-bc37-455a-8552-9ad29fbc04eb")
public class Wait_Until_Elemen_Is_Visible implements Nlp {
    WebDriver driver=null;
    @InputParams({@InputParam(name = "waittime", type = "java.lang.String"),
  	  @InputParam(name = "locatorValue", type = "java.lang.String")})
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
        String waittime = (String) attributes.get("waittime");
        String locatorValue = (String) attributes.get("locatorValue");
        driver =  (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
        
       
	   try {
	        
	        
            		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(waittime)));
		            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		            
	                nlpResponseModel.setStatus(CommonConstants.pass);
	                nlpResponseModel.setMessage("Successfully waited until element is visible");
        }
        catch(Exception e) {
            nlpResponseModel.setStatus(CommonConstants.fail);
	          nlpResponseModel.setMessage("Failed to wait until element is visible ");
        }
        
        
        return nlpResponseModel;
    }
} 