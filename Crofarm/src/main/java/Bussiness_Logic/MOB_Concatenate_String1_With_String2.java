package Bussiness_Logic;

import com.tyss.optimize.common.util.CommonConstants; 
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;




import org.springframework.stereotype.Component;


@Component("LIC15856_PJT1001_PE_NLP165a83f1-0fd9-416d-b147-24f358688d4e")
public class MOB_Concatenate_String1_With_String2 implements Nlp {
    @InputParams({@InputParam(name = "string1", type = "java.lang.String"),
    @InputParam(name = "string2", type = "java.lang.String")})
    @ReturnType(name = "ConcatenatedString", type = "java.lang.String")

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
          String ConcatenatedString="";
          try {
        	  ConcatenatedString=string1+string2;
        	  nlpResponseModel.setStatus(CommonConstants.pass);
  			   nlpResponseModel.setMessage("Successfully Concatenated String1 And String2");
		} 
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
 			  nlpResponseModel.setMessage("Failed To Concatenated String1 And String2");
		}

         
          nlpResponseModel.getAttributes().put("ConcatenatedString", ConcatenatedString);
          return nlpResponseModel;
      }
  } 