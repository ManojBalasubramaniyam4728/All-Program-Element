package Business_Logic;

import com.tyss.optimize.common.util.CommonConstants; 
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("LIC10506_PJT1001_PE_NLP199363a3-d13c-4b9a-9a96-54a8e7e2b4c7")
public class Verify_String_doesnot_match_String implements Nlp {
    @InputParams({@InputParam(name = "string1", type = "java.lang.String"), @InputParam(name = "string2", type = "java.lang.String")})
   // @ReturnType(name = "string3", type = "java.lang.String")

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
        String string1 = (String) attributes.get("string1");
        String string2 = (String) attributes.get("string2");
        try {
      	  if(!string1.equals(string2)) {
      		  
        		nlpResponseModel.setMessage(string1 +" does not matches "+ string2);
        		nlpResponseModel.setStatus(CommonConstants.pass);
        	}
        	else {
        		nlpResponseModel.setMessage(string1 +" matches "+ string2);
        		nlpResponseModel.setStatus(CommonConstants.fail);
        	}
		} catch (Exception e) {
			nlpResponseModel.setMessage("Failed to compare");
    		nlpResponseModel.setStatus(CommonConstants.fail);
		}
    	
        return nlpResponseModel;
    }
} 
