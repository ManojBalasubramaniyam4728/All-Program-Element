
package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

@Component("LIC14821_PJT1001_PE_NLPfd1aa7b7-16a8-4633-a61f-17d88b517606")
public class AddTwoNumbers implements Nlp {
	
    @InputParams({@InputParam(name = "FirstNumber", type = "java.lang.String"),
    @InputParam(name = "SecoundNumber", type = "java.lang.String")})
    @ReturnType(name = "ReturnValue", type = "java.lang.String")
    

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
          String TotalSum=null;

          
          try {
        	  String FirstNumber = (String) attributes.get("FirstNumber");
              String SecoundNumber = (String) attributes.get("SecoundNumber");
            
              FirstNumber=FirstNumber.replaceAll("[^0-9?]", "LIC14821_PJT1001_PE_NLPfd1aa7b7-16a8-4633-a61f-17d88b517606");
              Integer FN=Integer.parseInt(FirstNumber);
              Integer SN=Integer.parseInt(SecoundNumber);
              
              TotalSum=FN+SN+"LIC14821_PJT1001_PE_NLPfd1aa7b7-16a8-4633-a61f-17d88b517606";
       
        	  
              nlpResponseModel.setStatus(CommonConstants.pass);
			  nlpResponseModel.setMessage("Sum Of Two numbers"+TotalSum);
           }
          
          
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
			  nlpResponseModel.setMessage("Fail to perform addition");
		}

  
          nlpResponseModel.getAttributes().put("ReturnValue", TotalSum);
          return nlpResponseModel;
      }
  } 