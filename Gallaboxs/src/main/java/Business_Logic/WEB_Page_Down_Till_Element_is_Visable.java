
package Business_Logic;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

public class WEB_Page_Down_Till_Element_is_Visable implements Nlp {
    @InputParams({@InputParam(name = "element", type = "org.openqa.selenium.WebElement")
              , @InputParam(name = "maximumCount", type = "java.lang.Integer")})
    
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
          WebElement element = (WebElement) attributes.get("element");
          Integer maximumCount = (Integer) attributes.get("maximumCount");
          WebDriver driver=(WebDriver) nlpRequestModel.getWebDriver();
         try {
 					for(int i =0; i < maximumCount; i++) {
 					try {
 					if(element.isDisplayed()) {
 						break;
 					       }
 					    }
 					catch(NoSuchElementException e) {
 						Robot rb=new Robot();
 						rb.keyPress(KeyEvent.VK_PAGE_DOWN);
 						rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
 						/*Actions actionObject = new Actions(driver);
 						actionObject.sendKeys(Keys.ARROW_DOWN).build().perform();*/
 					      }
 				       }
 					 nlpResponseModel.setStatus(CommonConstants.pass);
 	                nlpResponseModel.setMessage("Successfully Page Down Till Element is Visable");
		} catch (Exception e) {
			 nlpResponseModel.setStatus(CommonConstants.fail);
             nlpResponseModel.setMessage("Failed Page Down Till Element is Visable"+e);
		}
          return nlpResponseModel;
      }
  } 