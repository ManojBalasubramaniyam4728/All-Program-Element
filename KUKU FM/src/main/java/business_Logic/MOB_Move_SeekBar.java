
package business_Logic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.data.models.dto.drivers.WebDriver;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.android.AndroidDriver;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;


@Component("LIC12863_PJT1001_PE_NLP8d2d4f14-a47f-479d-890d-12831badd5fd")
public class MOB_Move_SeekBar implements Nlp {
    @InputParams({@InputParam(name = "element", type = "org.openqa.selenium.WebElement"), @InputParam(name = "Seconds", type = "java.lang.String")})
 
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
          WebElement seekbar = (WebElement) attributes.get("element");
          String seconds = (String) attributes.get("Seconds");
          

          try {
        	  AndroidDriver driver=nlpRequestModel.getAndroidDriver();
        	  Actions actoin=new Actions(driver);
        	  actoin.sendKeys(seekbar, seconds);
        	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage("Seek Bar Moved succesfully");
		} 
          catch (Exception e) 
          {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
        	  nlpResponseModel.setMessage("failed to move the Seek Bar"+e);
			
          }
          return nlpResponseModel;
      }
  } 