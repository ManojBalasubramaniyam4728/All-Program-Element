package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

@Component("LIC14821_PJT1001_PE_NLP34b3b453-e3a3-4814-aaa8-02c6fcd49052")
public class MOB_Verify_String_Value_In_The_List implements Nlp {
    @InputParams({@InputParam(name = "List", type = "java.util.List"),
    	      @InputParam(name = "StringValue", type = "java.lang.String")})
    @ReturnType(name = "IsPresent", type = "java.lang.Boolean")

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
          
          List<String> textList = new ArrayList<String>();
          Boolean isPresent=false;
          try {
        	  
        	  List<String> List = (List<String>) attributes.get("List");
        	  String StringValue = (String) attributes.get("StringValue");
        	  
        	  for (String text : List) {
        		if(text.contains(StringValue)) {
        			isPresent=true;
        			 nlpResponseModel.setStatus(CommonConstants.pass);
               	  nlpResponseModel.setMessage("Successfully String Value Is Pesent In The List");
               	     break;
        	       	}
        		else {
        			 nlpResponseModel.setStatus(CommonConstants.pass);
                  	 nlpResponseModel.setMessage("String Value Not Pesent In The List");
        		}
               }
          }
          catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("String Value Not Pesent In The List"+e);
		      }
         
          nlpResponseModel.getAttributes().put("IsPresent", isPresent);
          return nlpResponseModel;
      }
  } 
