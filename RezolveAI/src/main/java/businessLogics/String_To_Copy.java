
  package businessLogics;

  import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
  import com.tyss.optimize.nlp.util.NlpException;
  import com.tyss.optimize.nlp.util.NlpRequestModel;
  import com.tyss.optimize.nlp.util.NlpResponseModel;
  import com.tyss.optimize.nlp.util.annotation.InputParam;
  import com.tyss.optimize.nlp.util.annotation.InputParams;
  import java.util.Map;
  import java.awt.Toolkit;
  import java.awt.datatransfer.StringSelection;
  import java.util.ArrayList;
  import java.util.List;
  import org.springframework.stereotype.Component;

  @Component("LIC7818_PJT1001_PE_NLP04ac9904-375a-4de4-95c1-e07e2c4911cc")
  public class String_To_Copy implements Nlp {
      @InputParams({@InputParam(name = "EnterString", type = "java.lang.String")})
      

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
          String EnterString = (String) attributes.get("EnterString");
       //   String string2 = (String) attributes.get("string2");

         try{
        	 System.setProperty("java.awt.headless", "false");
        	 StringSelection str = new StringSelection(EnterString);
     	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
     	   nlpResponseModel.setStatus(CommonConstants.pass);
           nlpResponseModel.setMessage("Successfully copied");
         }
         catch (Exception e) {
        	 nlpResponseModel.setStatus(CommonConstants.fail);
             nlpResponseModel.setMessage("Failed to copy");
			
		}
          return nlpResponseModel;
      }
  } 