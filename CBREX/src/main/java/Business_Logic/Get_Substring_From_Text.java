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

@Component("LIC10506_PJT1001_PE_NLPfb159106-8531-446c-bcda-4ce68963601a")
public class Get_Substring_From_Text implements Nlp {
    @InputParams({
    	@InputParam(name = "Text", type = "java.lang.String"),
    	@InputParam(name = "InitalIndex", type = "java.lang.String"),
    	@InputParam(name = "FinalIndex", type = "java.lang.String")})
    @ReturnType(name = "Value", type = "java.lang.String")

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
          String result=null;
          try {
        	  
          String Text = (String) attributes.get("Text");
          String InitalIndex = (String) attributes.get("InitalIndex");
          String FinalIndex = (String) attributes.get("FinalIndex");
          Integer II=Integer.parseInt(InitalIndex);
          Integer FI=Integer.parseInt(FinalIndex);
          
          result=Text.substring(II, FI);
          
          nlpResponseModel.setStatus(CommonConstants.pass);
          nlpResponseModel.setMessage("Successfully Converted Into Substring");
          }
          catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Conver Into Substring" );
		              }

          
          nlpResponseModel.getAttributes().put("Value", result);
          return nlpResponseModel;
      }
  } 
