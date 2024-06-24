
package Business_Logic;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;


import org.springframework.stereotype.Component;

@Component("LIC15384_PJT1004_PE_NLP9abb0037-1a33-4101-aba5-ce777e82e12b")
public class MOB_Get_Regional_Date_And_Time implements Nlp {
    @InputParams({@InputParam(name = "RegionalName", type = "java.lang.String"),
    	@InputParam(name = "DateAndTimeFormatter", type = "java.lang.String")})
    @ReturnType(name = "formattedDateAndTime", type = "java.lang.String")

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
          String regionalName = (String) attributes.get("RegionalName");
          String dateAndTimeFormatter = (String) attributes.get("DateAndTimeFormatter");
          String formattedDateAndTime="";

         try {
        	// Set the time zone to Regional Location  
             ZoneId regionalLocation = ZoneId.of(regionalName);
             
             // Get the current time in the Regional Location
             ZonedDateTime detroitTime = ZonedDateTime.now(regionalLocation);

             // Define the format for the time
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateAndTimeFormatter);

             // Format the time as a string
              formattedDateAndTime = detroitTime.format(formatter);

              nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage("Successfull Obtained"+" "+regionalName+" "+"Regional Date And Time Is"+" "+formattedDateAndTime);
		}
         catch (Exception e) {
           nlpResponseModel.setStatus(CommonConstants.fail);
       	   nlpResponseModel.setMessage("Failed To Obtained"+" "+regionalName+" "+"Regional Date And Time"+e);
		}

          nlpResponseModel.getAttributes().put("formattedDateAndTime", formattedDateAndTime);
          return nlpResponseModel;
      }
  } 