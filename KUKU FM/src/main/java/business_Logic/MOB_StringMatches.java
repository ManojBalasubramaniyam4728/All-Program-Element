package business_Logic;

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

  @Component("LIC12863_PJT1001_PE_NLP6b02f240-62fe-46d7-891e-ea77b29f8718")
  public class MOB_StringMatches implements Nlp {
      @InputParams({@InputParam(name = "string1", type = "java.lang.String"), @InputParam(name = "string2", type = "java.lang.String")})
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
          String string1 = (String) attributes.get("string1");
          String string2 = (String) attributes.get("string2");
          Boolean IsPresent = null;
          try {
        	 String value1=string1.trim();
        	 String value2=string2.trim();
        	  if(value1.contains(value2)) {
        		  IsPresent=true;
        		 nlpResponseModel.setStatus(CommonConstants.pass);
          		nlpResponseModel.setMessage(string1 +" matches "+ string2);
          	 }
          	else {
          		IsPresent=false;
          		nlpResponseModel.setStatus(CommonConstants.fail);
          		nlpResponseModel.setMessage(string1 +" not matches "+ string2);
          	}
		} 
          catch (Exception e) {
			nlpResponseModel.setMessage("Failed to compare");
      		nlpResponseModel.setStatus(CommonConstants.fail);
		}
          nlpResponseModel.getAttributes().put("IsPresent", IsPresent);
          return nlpResponseModel;
      }
  } 
