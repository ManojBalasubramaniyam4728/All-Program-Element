package Business_Logic;

import java.util.ArrayList; 
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import io.appium.java_client.android.AndroidDriver;

@Component("LIC13397_PJT1001_PE_NLPf1b17050-8296-4615-a122-03ad845f93ce")
public class MOB_Get_Size_Of_WebElements implements Nlp {
	 @InputParams({@InputParam(name = "Xpath", type = "java.lang.String")})
	    @ReturnType(name = "ElementSize", type = "java.lang.String")

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
          AndroidDriver driver = (AndroidDriver) nlpRequestModel.getAndroidDriver();
             Integer size=0;
          try {
			 List<WebElement> elements =driver.findElements(By.xpath(Xpath));
		     size=elements.size();
		     nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Size of Web Elements is " + size);
		} 
          catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to get size of webelements" + e);
		}

          nlpResponseModel.getAttributes().put("ElementSize", size);
          return nlpResponseModel;
      }
  } 