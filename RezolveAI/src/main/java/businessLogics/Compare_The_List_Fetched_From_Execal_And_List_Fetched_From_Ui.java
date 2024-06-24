
package businessLogics;

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

@Component("LIC7818_PJT1001_PE_NLPb2f939cd-2bcc-40e9-a09e-64cbbeb5f7c2")
public class Compare_The_List_Fetched_From_Execal_And_List_Fetched_From_Ui implements Nlp {
    @InputParams({@InputParam(name = "lowercaseValuesTextList", type = "java.util.ArrayList"),
    	          @InputParam(name = "updatekeyValue", type = "java.util.Map")})
 

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
          List<String> lowercaseValuesTextList = (List<String>) attributes.get("lowercaseValuesTextList");
          Map<String, String> updatekeyValue = (Map<String, String>) attributes.get("updatekeyValue");
          
          try {
        		 for (Map.Entry<String, String> entry : updatekeyValue.entrySet()) {
     	            String value1 = entry.getValue();
     	            if (lowercaseValuesTextList.contains(value1.toLowerCase())) {
     	            	 nlpResponseModel.setStatus(CommonConstants.pass);
     	          	     nlpResponseModel.setMessage("The Values In Excel And Ui Are Equal ");
     	            } 
     	            else {
     	            	 nlpResponseModel.setStatus(CommonConstants.fail);
     	          	     nlpResponseModel.setMessage("The Values In Excel And Ui Are Not Equal ");
     	            }
     	         }
              }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
        	  nlpResponseModel.setMessage("While Comparing values  Exception has been occurred"+e);
		}
      
          return nlpResponseModel;
      }
  } 