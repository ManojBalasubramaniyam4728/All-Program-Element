
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
import java.util.ArrayList;
import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.springframework.stereotype.Component;

@Component("LIC5197_PJT1002_PE_NLPbaf48209-fe58-4502-9e4f-1107a1d874c3")
public class MOB_Pause_The_Video implements Nlp {
    @InputParams({@InputParam(name = "ImplicitWait", type = "java.lang.String")})

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
          String ImplicitWait = (String) attributes.get("ImplicitWait");
          Integer ImplicitWaitTime=Integer.parseInt(ImplicitWait);

          AppiumDriver driver = (AndroidDriver) nlpRequestModel.getAndroidDriver();

          try {
        	  //This time, wait until the video plays.
        	  Thread.sleep(ImplicitWaitTime);
        	  int screenWidth = driver.manage().window().getSize().getWidth();
        	  int screenHeight = driver.manage().window().getSize().getHeight();
        	  // Calculate the center coordinates of the screen
        	  int centerX = screenWidth / 2;
        	  int centerY = screenHeight / 2;
        	  String  getCenterCoordinates =String.format("{\"x\": %d, \"y\": %d}", centerX, centerY);
        	 // Execute JavaScript to tap on the center of the screen
        	  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        	  String script = "mobile: tap";
        	  jsExecutor.executeScript(script, getCenterCoordinates);
        	  jsExecutor.executeScript(script, getCenterCoordinates);
        	  nlpResponseModel.setStatus(CommonConstants.pass);
			  nlpResponseModel.setMessage("Successfully Pause The Video");
        	  
		    } 
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
			  nlpResponseModel.setMessage("Failed To Pause The Video"+e);
		}

          return nlpResponseModel;
      }
  } 