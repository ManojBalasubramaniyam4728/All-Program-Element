package businessLogics;




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

@Component("LIC7818_PJT1001_PE_NLP710e7d99-8aab-4fa5-a3ee-55482ffc5c13")
public class Arithmetic_Calculation implements Nlp {
    @InputParams({@InputParam(name = "EndTime", type = "java.lang.String"),
    	@InputParam(name = "StartTime", type = "java.lang.String")})
    @ReturnType(name = "elapsedTime", type = "java.lang.String")

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
         
          String elapsedTime=null;
      
      try {
    	  String EndTime = (String) attributes.get("EndTime");
          String StartTime = (String) attributes.get("StartTime");
          Long ET=Long.parseLong(EndTime);
          Long ST=Long.parseLong(StartTime);
          Long elapsedTime1 = (Long) ((ET - ST) / 1000);
           elapsedTime =elapsedTime1.toString();
           nlpResponseModel.setStatus(CommonConstants.pass);
		  nlpResponseModel.setMessage("Successfully Performed Arithmetic Calculation" );
      }
      catch (Exception e) {
    	  nlpResponseModel.setStatus(CommonConstants.fail);
		  nlpResponseModel.setMessage("Fail To Performed Arithmetic Calculation" );
	}
    	  
      

          
          nlpResponseModel.getAttributes().put("elapsedTime", elapsedTime);
          return nlpResponseModel;
      }
  } 