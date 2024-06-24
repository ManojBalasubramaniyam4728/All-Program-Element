 package KuzaOne;
  
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

@Component("LIC14333_PJT1002_PE_NLP56965016-5268-4cf0-a70a-1f7c2e2f0f8c")
public class MOB_Get_Only_The_Numberc_From_String implements Nlp {
      
      @InputParams({@InputParam(name = "Message", type = "java.lang.String")})
      
      @ReturnType(name = "FinalValue", type = "java.lang.String")
      
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
          String message = (String) attributes.get("Message");
          String result="";
          
	   try {
		    result = message.replaceAll("[^0-9?]", "");
	                nlpResponseModel.setStatus(CommonConstants.pass);
	                nlpResponseModel.setMessage("Successfully Getted Text From "+message+" ");
          }
          catch(Exception e) {
              nlpResponseModel.setStatus(CommonConstants.fail);
	          nlpResponseModel.setMessage("Failed To Getted Text From "+message+" ");
          }
          
	      nlpResponseModel.getAttributes().put("FinalValue", result);
          return nlpResponseModel;
      }
  } 