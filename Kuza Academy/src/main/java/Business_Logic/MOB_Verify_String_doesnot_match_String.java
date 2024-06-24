package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC14333_PJT1001_PE_NLPab40658a-9b52-4109-8e85-d93f45c011fb")
public class MOB_Verify_String_doesnot_match_String implements Nlp {
    @InputParams({@InputParam(name = "string1", type = "java.lang.String"),
    	@InputParam(name = "string2", type = "java.lang.String")})
     @ReturnType(name = "FinalResult", type = "java.lang.Boolean")
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
        Boolean result=false;
        try {
      	  if(!string1.equals(string2)) {
      		    result=true;
        		nlpResponseModel.setMessage(string1 +" does not matches "+ string2);
        		nlpResponseModel.setStatus(CommonConstants.pass);
        	}
        	else {
        		result=false;
        		nlpResponseModel.setMessage(string1 +" matches "+ string2);
        		nlpResponseModel.setStatus(CommonConstants.pass);
        	}
		} catch (Exception e) {
			nlpResponseModel.setMessage("Failed to compare");
    		nlpResponseModel.setStatus(CommonConstants.fail+e);
		}
        nlpResponseModel.getAttributes().put("FinalResult", result);
        return nlpResponseModel;
    }
} 
