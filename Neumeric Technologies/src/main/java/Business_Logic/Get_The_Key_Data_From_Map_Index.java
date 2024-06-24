
package Business_Logic;

import java.util.ArrayList;
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

@Component("LIC15384_PJT1001_PE_NLP85a77ef8-fd5e-49dd-b2cb-fb1b38b68cad")
public class Get_The_Key_Data_From_Map_Index implements Nlp {
    @InputParams({@InputParam(name = "Map", type = "java.util.HashMap"),
    	          @InputParam(name = "Length", type = "java.lang.Integer")})
    @ReturnType(name = "keyData", type = "java.lang.String")

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
          Integer Length = (Integer) attributes.get("Length");
          String keyData="";

         try {
        	  // Get the keys as an array
             String[] keys = Map.keySet().toArray(new String[0]);
                 keyData = keys[Length];
                 nlpResponseModel.setStatus(CommonConstants.pass);
    			 nlpResponseModel.setMessage("Successfully Obtained Key Date"+" "+keyData);
	           	}
         
             catch (Exception e) {
            	 nlpResponseModel.setStatus(CommonConstants.fail);
    			 nlpResponseModel.setMessage("Failed To Obtained Key Date"+" "+e);
		}
          nlpResponseModel.getAttributes().put("keyData", keyData);
          return nlpResponseModel;
      }
  } 