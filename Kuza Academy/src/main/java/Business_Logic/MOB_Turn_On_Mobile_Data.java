
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

@Component("LIC14333_PJT1001_PE_NLPbffc1cd2-c360-4fae-a855-fb72eb9a049f")
public class MOB_Turn_On_Mobile_Data implements Nlp {
    
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
        	       Runtime.getRuntime().exec("adb shell svc data enable");
        	       nlpResponseModel.setStatus(CommonConstants.pass);
	               nlpResponseModel.setMessage("Successfully turned on the data ");
		} catch (Exception e) {
			 nlpResponseModel.setStatus(CommonConstants.pass);
             nlpResponseModel.setMessage("Failed to turned on the data"+e);
		}

          String string3 = "Return Value";
          nlpResponseModel.getAttributes().put("string3", string3);
          return nlpResponseModel;
      }
  } 