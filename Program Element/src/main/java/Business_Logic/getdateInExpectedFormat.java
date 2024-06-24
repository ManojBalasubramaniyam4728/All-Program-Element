
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
  import org.springframework.stereotype.Component;

  @Component("LIC8536_PJT1001_PE_NLP93e78d1d-3b7d-48be-9935-6e17960bebb8")
  public class getdateInExpectedFormat implements Nlp {
      @InputParams({@InputParam(name = "format", type = "java.lang.String")}) 
    	 
      @ReturnType(name = "todays", type = "java.lang.String")

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
          String format = (String) attributes.get("format");
          String today=null;
try {
	
	    Date date = new Date();
	    SimpleDateFormat dateformate=new SimpleDateFormat(format);
	     today=dateformate.format(date);
	    nlpResponseModel.setStatus(CommonConstants.pass);
	    nlpResponseModel.setMessage("Expected value");
	
}
catch (Exception e) {
	  nlpResponseModel.setStatus(CommonConstants.fail);
	    nlpResponseModel.setMessage("Faied to get Expected value");
}
 
          nlpResponseModel.getAttributes().put("today", today);
          return nlpResponseModel;
      }
  } 