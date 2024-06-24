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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP67ed686c-7ac6-47bc-b194-c1a25d888cc4")
public class Get_Current_System_Date implements Nlp {
    @InputParams({@InputParam(name = "DatePattern", type = "java.lang.String")})
    @ReturnType(name = "ReturnGettedDate", type = "java.lang.String")

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
          String DatePattern = (String) attributes.get("DatePattern");
          String formattedDate=null;
          

         try {
        	 
        	    LocalDate currentDate = LocalDate.now();
        	    
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DatePattern);
               
                formattedDate = currentDate.format(formatter);
               
                nlpResponseModel.setStatus(CommonConstants.pass);
                nlpResponseModel.setMessage("Generate current date"+formattedDate);
                 
                        }
         
         catch (Exception e) {
        	 
        	     nlpResponseModel.setStatus(CommonConstants.fail);
                 nlpResponseModel.setMessage("Fail to Generate current date ");			
		                             }
       
          nlpResponseModel.getAttributes().put("ReturnGettedDate", formattedDate);
          return nlpResponseModel;
      }
  } 