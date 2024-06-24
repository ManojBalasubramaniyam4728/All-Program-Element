
package Business_Logic;

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

@Component("LIC13397_PJT1001_PE_NLP071003a9-cce0-4afa-a96c-014ed53adaf5")
public class MOB_Fetch_Numbers_From_String implements Nlp {
    @InputParams({@InputParam(name = "Enter a String", type = "java.lang.String")})
    @ReturnType(name = "string3", type = "java.lang.String")

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
          String stringValue = (String) attributes.get("Enter a String");
          String numberValue = null;

          try {
        	 numberValue = stringValue.replaceAll("[^0-9?]", "").trim().toString();
        	  nlpResponseModel.setMessage(CommonConstants.pass);
        	  nlpResponseModel.setMessage("successfully fetched numbers from string");
          }
          catch (Exception e) {
        	  nlpResponseModel.setMessage(CommonConstants.fail);
        	  nlpResponseModel.setMessage("failed to  fetch numbers from string");
		}
         
          nlpResponseModel.getAttributes().put("string3", numberValue);
          return nlpResponseModel;
      }
  } 