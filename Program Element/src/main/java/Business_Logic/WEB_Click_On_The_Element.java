package Business_Logic;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;


public class WEB_Click_On_The_Element implements Nlp {
   @InputParams({@InputParam(name = "xpath", type = "java.lang.String")})    
    
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

        String Xpath = (String) attributes.get("xpath");
        WebDriver driver=(WebDriver)nlpRequestModel.getWebDriver();
       
        try {
				driver.findElement(By.xpath(Xpath)).click();
			
			nlpResponseModel.setMessage("Successfully Clicked On The Element");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} 
        catch (Exception e) {
			nlpResponseModel.setMessage("Failed To Click On The Element"+e);
			nlpResponseModel.setStatus(CommonConstants.fail);
					}
        return nlpResponseModel;
    }
} 
