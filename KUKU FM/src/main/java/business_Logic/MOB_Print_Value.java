package business_Logic;




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


@Component("LIC12863_PJT1001_PE_NLP549f013d-723b-4756-9696-659521593156")
public class MOB_Print_Value implements Nlp {
	  @InputParams({@InputParam(name = "Input", type = "java.lang.String")})
	

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
        String Input = (String) attributes.get("Input");
        
        try {
      	  nlpResponseModel.setStatus(CommonConstants.pass);
            nlpResponseModel.setMessage("The value is "+Input+"");
        }
        catch (Exception e) {
      	  nlpResponseModel.setStatus(CommonConstants.fail);
            nlpResponseModel.setMessage("Failed to print the value");
		}
        
        return nlpResponseModel;
    }
} 