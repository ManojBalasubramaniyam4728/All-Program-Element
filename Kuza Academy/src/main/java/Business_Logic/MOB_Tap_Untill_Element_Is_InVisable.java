package Business_Logic;



import java.util.ArrayList; 
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC14333_PJT1001_PE_NLP38ea2fc5-722e-4a76-a0a8-6c73663fc1f7")
public class MOB_Tap_Untill_Element_Is_InVisable implements Nlp {
    @InputParams({@InputParam(name = "Xpath", type = "java.lang.String")})
    @ReturnType(name = "FinalNumber", type = "java.lang.Integer")

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
           Integer i=0;

         try {
			WebDriver driver=(WebDriver)nlpRequestModel.getAndroidDriver();
        	 for ( i = 0; i <25; i++) {
		   int num =driver.findElements(By.xpath(Xpath)).size();
		   if(num>0) {
			   driver.findElement(By.xpath(Xpath)).click();
		   }
		   else if (num==0) {
			break;
		}
			}
        	  nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("Successfully tap on element until element is Invisible ");
		}
         catch (Exception e) {
			 nlpResponseModel.setStatus(CommonConstants.fail);
             nlpResponseModel.setMessage("Failed to tap on element until element is Invisible "+e);
		}

          nlpResponseModel.getAttributes().put("FinalNumber", i);
          return nlpResponseModel;
      }
  } 