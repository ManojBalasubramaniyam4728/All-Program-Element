package businessLogics;



import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC7818_PJT1001_PE_NLPbfb64532-5f65-42ce-997b-993ce8f3866a")
public class Start_The_Timer implements Nlp {
   
    @ReturnType(name = "StartTimer", type = "java.lang.String")

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
         
          Long StartTimer=null;
          
          try {
        	  StartTimer= System.currentTimeMillis();
        	  nlpResponseModel.setStatus(CommonConstants.pass);
    		 nlpResponseModel.setMessage("Successfully StartTimer as Started");
          }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
     		 nlpResponseModel.setMessage("Fail to Start The Timer");
		}

         
          nlpResponseModel.getAttributes().put("StartTimer", StartTimer);
          return nlpResponseModel;
      }
  } 