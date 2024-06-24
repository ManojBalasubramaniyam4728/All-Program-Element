package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

@Component("LIC8536_PJT1001_PE_NLP43f94296-36f7-489e-be65-4347313a1402")
public class Convert_Milli_Seconds_To_Other_Format implements Nlp {
    @InputParams({@InputParam(name = "Units", type = "java.lang.Long"), 
    	          @InputParam(name = "UntieFormat", type = "java.lang.String")})
              @ReturnType(name = "ReturnUnit", type = "java.lang.Long")

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
          Long Units = (Long) attributes.get("Units");
          String UntieFormat = (String) attributes.get("UntieFormat");
          long finalValue=0;

      try {
    	  switch (UntieFormat.toLowerCase()) {
      
      	 case "seconds": long milliseconds1 = Units;
      	finalValue = TimeUnit.MILLISECONDS.toSeconds(milliseconds1);
      	                                 break;
      	
      	 case "minutes":long milliseconds2 = Units;
      	finalValue= TimeUnit.MILLISECONDS.toMinutes(milliseconds2);
      	                                 break;
    
      	
      	 case "hours":long milliseconds3 = Units;
      	finalValue = TimeUnit.MILLISECONDS.toHours(milliseconds3);
      	                                break;
                   }
    	  nlpResponseModel.setStatus(CommonConstants.pass);
          nlpResponseModel.setMessage("Successfully converted millisecond"+" "+Units+" "+"Value to "+" "+UntieFormat+" "+"format is"+" "+finalValue);
              }
      catch (Exception e) {
    	  nlpResponseModel.setStatus(CommonConstants.fail);
          nlpResponseModel.setMessage("Fail To Convert Millisecond To Other Formate");
	}
      


         
          nlpResponseModel.getAttributes().put("ReturnUnit", finalValue);
          return nlpResponseModel;
         }
      }