package Business_Logic;



import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP26cb4942-2cab-4761-bcb2-ab94974ab01d")
public class Get_Number_Of_Links_Prasent_In_page implements Nlp {
	  @ReturnType(name = "TotalLinks", type = "java.lang.Integer")
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
               Integer NoOfLinks=null;
    try { 
    	WebDriver driver= (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
    	 List<WebElement> links = driver.findElements(By.tagName("a"));
        	NoOfLinks=links.size();
	                nlpResponseModel.setStatus(CommonConstants.pass);
                  nlpResponseModel.setMessage("total links are "+NoOfLinks);
                  }
catch (Exception e) {
	 nlpResponseModel.setStatus(CommonConstants.fail);
   nlpResponseModel.setMessage("Failed to check links");
}
     nlpResponseModel.getAttributes().put("TotalLinks",NoOfLinks);
        return nlpResponseModel;
    }
} 