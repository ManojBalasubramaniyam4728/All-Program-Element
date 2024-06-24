
package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;


@Component("LIC11364_PJT1001_PE_NLPb73fba9a-5b7e-45de-ad2e-ffe59f914bee")
public class Wait_for_page_to_load_for_maximum_time_limit_implicitTimeOut_econds implements Nlp {
    @InputParams({@InputParam(name = "ImplicitlyWait", type = "java.lang.Integer")})
   

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
        	  Integer ImplicitlyWait = (Integer) attributes.get("ImplicitlyWait");
        	  Thread.sleep(500);
        	  WebDriver driver=(WebDriver)nlpRequestModel.getWebDriver();
        	  driver.manage().timeouts().implicitlyWait(ImplicitlyWait, TimeUnit.SECONDS);
        	  
        	 nlpResponseModel.setStatus(CommonConstants.pass);
        	 nlpResponseModel.setMessage("Successfully Waited Implicitly");
          }
          catch (Exception e) {
        	 nlpResponseModel.setStatus(CommonConstants.fail);
         	 nlpResponseModel.setMessage("Failed To Waited Implicitly "+e.getMessage());
		}
          
       
          return nlpResponseModel;
      }
  } 