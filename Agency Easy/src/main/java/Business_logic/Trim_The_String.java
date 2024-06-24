package Business_logic;

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

  @Component("LIC12844_PJT1001_PE_NLP239ac5e4-0453-4f21-ab6b-738714b77641")
  public class Trim_The_String implements Nlp {
      @InputParams({@InputParam(name = "string1", type = "java.lang.String")})
      @ReturnType(name = "FinalValue", type = "java.lang.String")

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
     	  String value=null;
          try {
        	  value=string1.trim();
        		nlpResponseModel.setStatus(CommonConstants.pass);
          		nlpResponseModel.setMessage(string1 +" Is Trimed ");
          	 }
          catch (Exception e) {
        	 nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to trim");
      		
		}
          nlpResponseModel.getAttributes().put("FinalValue", value);
          return nlpResponseModel;
      }
  } 
