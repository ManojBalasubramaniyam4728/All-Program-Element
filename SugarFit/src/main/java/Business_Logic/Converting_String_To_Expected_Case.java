
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

@Component("LIC14821_PJT1001_PE_NLP7fa00694-1faf-463a-a4c9-c16ac33435e8")
public class Converting_String_To_Expected_Case implements Nlp {
    @InputParams({@InputParam(name = "String", type = "java.lang.String"),
    	@InputParam(name = "Case", type = "java.lang.String")})
    @ReturnType(name = "FinalStringValue", type = "java.lang.String")

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
          String String = (String) attributes.get("String");
          String Case = (String) attributes.get("Case");
          String FinalStringValue="";
          try {
        	 String caseValue=Case.toLowerCase();
        	  if(caseValue.contains("lowercase")){
        		  FinalStringValue= String.toLowerCase();
        		 nlpResponseModel.setStatus(CommonConstants.pass);
          		nlpResponseModel.setMessage("Successfully Converted To Lower Case");
          }
        	  else if (caseValue.contains("uppercase")) {
        		  FinalStringValue= String.toUpperCase();
        		  nlpResponseModel.setStatus(CommonConstants.pass);
        		nlpResponseModel.setMessage("Successfully Converted To Upper Case");
			}
          }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
  			nlpResponseModel.setMessage("Fail To Convert To Expected Case");
		}

          
          nlpResponseModel.getAttributes().put("FinalStringValue", FinalStringValue);
          return nlpResponseModel;
      }
  } 