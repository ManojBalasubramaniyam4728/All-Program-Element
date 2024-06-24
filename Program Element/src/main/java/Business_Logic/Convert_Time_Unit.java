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
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
  import java.util.List;
  import org.springframework.stereotype.Component;

  @Component("LIC8536_PJT1001_PE_NLP207fa91d-65f1-4bf5-baa4-a38668a5d0d7")
  public class Convert_Time_Unit implements Nlp {
      @InputParams({@InputParam(name = "From Unit", type = "java.lang.String"), 
    	  @InputParam(name = "To Unit", type = "java.lang.String"),
    	  @InputParam(name = "From value", type = "java.lang.String")})
      @ReturnType(name = "returnValue", type = "java.lang.String")

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
          String From = (String) attributes.get("From Unit");
          String to = (String) attributes.get("To Unit");
          String FromValue = (String) attributes.get("From value");
          Long Value=Long.parseLong(FromValue);
       Double returnValue=null;
try {
      if(From.equalsIgnoreCase("milli")) {
           // milli to second
          if(to.equalsIgnoreCase("sec")) {
        	  returnValue= (double) TimeUnit.MILLISECONDS.toSeconds(Value);
        	  }
        //milli to min
          else if(to.equalsIgnoreCase("min")) {
        	  returnValue = (double) TimeUnit.MILLISECONDS.toMinutes(Value);
          	  }
        //milli to hrs
          else if(to.equalsIgnoreCase("hrs")) {
        	  returnValue = (double) TimeUnit.MILLISECONDS.toHours(Value);		
          		}
        	}
      else if(From.equalsIgnoreCase("Sec")) {
          	// sec to milli
          	if(to.equalsIgnoreCase("Milli")) {
          	  returnValue = (double) TimeUnit.SECONDS.toMillis(Value);
          		}
          	//sec to min
          else if(to.equalsIgnoreCase("min")) {
        	  returnValue= (double) TimeUnit.SECONDS.toMinutes(Value);
              	}
          //sec to hrs
          else if(to.equalsIgnoreCase("hrs")) {
        	  returnValue= (double) TimeUnit.SECONDS.toHours(Value);          		
          	    }
         	}
      else if(From.equalsIgnoreCase("Min")) {
    	//min to millisec
    	    if(to.equalsIgnoreCase("Milli")) {		
    	    	returnValue = (double) TimeUnit.MINUTES.toMillis(Value);
          		}
    	  //min to sec
          	else if(to.equalsIgnoreCase("Sec")) {
          		 returnValue = (double) TimeUnit.MINUTES.toSeconds(Value);
           		}
    	  //min to hrs
          	else if(to.equalsIgnoreCase("hrs")) {
          		returnValue= (double) TimeUnit.MINUTES.toHours(Value);
              
          		}
         	}
    	else if(From.equalsIgnoreCase("hrs")) {
       	//hrs to millisec
          	if(to.equalsIgnoreCase("Milli")) {
           		returnValue= (double) TimeUnit.HOURS.toMillis(Value);
           		}
          //hrs to sec
          	else if(to.equalsIgnoreCase("Sec")) {
          		returnValue= (double) TimeUnit.HOURS.toSeconds(Value);
             	}
          //hrs to min
          	else if(to.equalsIgnoreCase("min")) {
          		returnValue= (double) TimeUnit.HOURS.toMinutes(Value);
          			}
          	}
      nlpResponseModel.setStatus(CommonConstants.pass);
      nlpResponseModel.setMessage(FromValue+" "+From+" "+"is equals to "+returnValue+" "+to);
}

      catch(Exception e) {
    	  nlpResponseModel.setStatus(CommonConstants.pass);
          nlpResponseModel.setMessage("Failed to convert"+" "+From+" "+to); 
      }

          nlpResponseModel.getAttributes().put("returnValue", returnValue.toString());
          return nlpResponseModel;
      }
  } 
