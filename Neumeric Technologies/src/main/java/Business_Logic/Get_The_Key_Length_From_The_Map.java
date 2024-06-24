
package Business_Logic;

import java.util.ArrayList; 
import java.util.Collection;
import java.util.HashMap;
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

@Component("LIC15384_PJT1001_PE_NLPe0387e1c-360d-48bc-91d4-f6d63a038e1b")
public class Get_The_Key_Length_From_The_Map implements Nlp {
    @InputParams({@InputParam(name = "Map", type = "java.util.HashMap")})
    @ReturnType(name = "KeyLength", type = "java.lang.Integer")

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
          HashMap<String, String> Map = (HashMap<String, String>) attributes.get("Map");
          Integer KeyLength=0;

          try {
        	 // Get the keys as an array
              String[] keys = Map.keySet().toArray(new String[0]);
              KeyLength = keys.length;
              nlpResponseModel.setStatus(CommonConstants.pass);
 			 nlpResponseModel.setMessage("Successfully Obtained Key Length From Map"+" "+KeyLength);
		    }
        	 
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.pass);
 			 nlpResponseModel.setMessage("Failed Obtained Key Length From Map"+" "+e);
		}

          nlpResponseModel.getAttributes().put("KeyLength", KeyLength);
          return nlpResponseModel;
      }
  } 
