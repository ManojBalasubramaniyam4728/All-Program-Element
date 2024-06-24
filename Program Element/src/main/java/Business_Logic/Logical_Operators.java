
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

@Component("LIC8536_PJT1001_PE_NLP6260c22a-e3de-488c-a0da-938975cce71b")
public class Logical_Operators implements Nlp {
    @InputParams({@InputParam(name = "condition1", type = "java.lang.Boolean"),
    	          @InputParam(name = "LogicalOperators", type = "java.lang.String"),
    	          @InputParam(name = "condition2", type = "java.lang.Boolean")})
    @ReturnType(name = "FinalResult", type = "java.lang.String")

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
    	  Boolean FinalResult=true;
        
          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          Map<String, Object> attributes = nlpRequestModel.getAttributes();
          Boolean condition1 = (Boolean) attributes.get("condition1");
          String LogicalOperators = (String) attributes.get("LogicalOperators");
          Boolean condition2 = (Boolean) attributes.get("condition2");

          try {
        	 switch (LogicalOperators) {
             case "&&":
            	 FinalResult= condition1 && condition2;
             case "||":
            	 FinalResult =condition1||condition2;
             case "OR":
            	 FinalResult =condition1 || condition2;
             case "AND":
            	 FinalResult =condition1 && condition2;
             case "or":
            	 FinalResult =condition1 || condition2;
             case "and":
            	 FinalResult =condition1 && condition2;
             case "Or":
            	 FinalResult =condition1 || condition2;
             case "And":
            	 FinalResult =condition1 && condition2;
         }
        	 
        	 if(FinalResult==true) {
        		 nlpResponseModel.setStatus(CommonConstants.pass);
            	 nlpResponseModel.setMessage("The Result Of Logical Operator Is"+" "+FinalResult);
        	 }
        	 else {
        		 nlpResponseModel.setStatus(CommonConstants.pass);
            	 nlpResponseModel.setMessage("The Result Of Logical Operator Is"+" "+FinalResult);
            
        	 }
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed Execute The If Condition"+e.getMessage());
		}

          nlpResponseModel.getAttributes().put("FinalResult", FinalResult);
          return nlpResponseModel;
      }
  } 