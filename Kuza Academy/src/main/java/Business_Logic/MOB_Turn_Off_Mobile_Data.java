
package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;

import org.springframework.stereotype.Component;

@Component("LIC14333_PJT1001_PE_NLP4384a8ea-b01a-49d2-9196-f39bb68e6164")
public class MOB_Turn_Off_Mobile_Data implements Nlp {
    
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
        	    // Turn off mobile data using adb shell command
        	       Runtime.getRuntime().exec("adb shell svc data disable");
        	       nlpResponseModel.setStatus(CommonConstants.pass);
	               nlpResponseModel.setMessage("Successfully turned off the data ");
		} catch (Exception e) {
			 nlpResponseModel.setStatus(CommonConstants.pass);
             nlpResponseModel.setMessage("Failed to turned off the data"+e);
		}

          String string3 = "Return Value";
          nlpResponseModel.getAttributes().put("string3", string3);
          return nlpResponseModel;
      }
  } 