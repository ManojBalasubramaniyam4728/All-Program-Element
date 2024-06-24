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

@Component("LIC7818_PJT1001_PE_NLPf397f2ad-872d-42ad-ae79-a6e280812593")
public class End_The_Timer implements Nlp {
   
    @ReturnType(name = "EndTimer", type = "java.lang.String")

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
         
          Long EndTimer=null;
          
          try {
        	  EndTimer= System.currentTimeMillis();
        	  nlpResponseModel.setStatus(CommonConstants.pass);
    		 nlpResponseModel.setMessage("Successfully EndTimer is Ended");
          }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
     		 nlpResponseModel.setMessage("Fail to End The Timer");
		}

         
          nlpResponseModel.getAttributes().put("EndTimer", EndTimer);
          return nlpResponseModel;
      }
  } 