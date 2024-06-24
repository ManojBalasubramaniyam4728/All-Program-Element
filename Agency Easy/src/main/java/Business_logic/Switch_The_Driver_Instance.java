package Business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.data.models.dto.IDriver;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

@Component("LIC12844_PJT1001_PE_NLPf0877330-bf41-4851-82e9-6ddca9b33021")
public class Switch_The_Driver_Instance implements Nlp{
	
	@InputParams({@InputParam(name = "Driver", type = "org.openqa.selenium.WebDriver")})
  

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
        	
          WebDriver driver = (WebDriver) attributes.get("Driver");
          nlpResponseModel.setWebDriver(driver);
          nlpResponseModel.setStatus(CommonConstants.pass);
            	nlpResponseModel.setMessage("Successfully Driver Instance is Switched ");
		} 
		
         
       catch (Exception e) {
    	   nlpResponseModel.setStatus(CommonConstants.fail);
		nlpResponseModel.setMessage("Failed To Switched Driver Instance "+e);
       }
        
          return nlpResponseModel;
      }
  } 



