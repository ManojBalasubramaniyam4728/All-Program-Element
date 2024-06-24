
package KuzaOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.AppiumBy;

import org.springframework.stereotype.Component;

@Component("LIC14333_PJT1002_PE_NLPb00caf8c-8f3a-443a-a5be-33d5d6e3d566")
public class MOB_Swipe_Down_Till_Text_Is_Visible_By_Useing_AndroidUIAutomator implements Nlp {
    @InputParams({@InputParam(name = "Text", type = "java.lang.String")})
   

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
          String Text = (String) attributes.get("Text");

          try {
        	  WebDriver driver=(WebDriver)nlpRequestModel.getAndroidDriver();
        	  driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\""+Text+"\"))"));
        	  nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("Successfully Swiped Till Text is Visable");
          }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("F-ailed To Swipe Till Text is Visable"+e);
		}

          return nlpResponseModel;
      }
  } 