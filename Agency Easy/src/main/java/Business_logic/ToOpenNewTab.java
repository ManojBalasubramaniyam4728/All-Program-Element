
package Business_logic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.springframework.stereotype.Component;

@Component("LIC12844_PJT1001_PE_NLPced12807-612e-47f2-aac0-bb53bb4bfeea")
public class ToOpenNewTab implements Nlp {
  

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
        	WebDriver driver=(WebDriver)nlpRequestModel.getWebDriver();
        	driver.switchTo().newWindow(WindowType.TAB);

 			nlpResponseModel.setStatus(CommonConstants.pass);
 			nlpResponseModel.setMessage("Successfully Opened New Tab");

         }
         catch (Exception e) {
        	nlpResponseModel.setStatus(CommonConstants.fail);
  			nlpResponseModel.setMessage("Failed To Opened New Tab");
         }

          return nlpResponseModel;
      }
  } 
