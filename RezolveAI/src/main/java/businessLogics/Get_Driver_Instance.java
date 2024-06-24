package businessLogics;

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
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC7818_PJT1001_PE_NLP7a34c4b7-ae1c-4abb-a78b-463d440f67fb")
public class Get_Driver_Instance implements Nlp  {

    @ReturnType(name = "DriverInstance", type = "org.openqa.selenium.WebDriver")

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
          WebDriver driver = null;
          try {
			
        	   driver = (WebDriver) nlpRequestModel.getWebDriver();
        	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage("Successfully Geted Driver Insctance ");
		} 
		
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
        	  nlpResponseModel.setMessage("Fail To Geted Driver Insctance" + e);
          }
          WebDriver instance = driver;
          nlpResponseModel.getAttributes().put("DriverInstance", instance);
          return nlpResponseModel;
      }
  } 


