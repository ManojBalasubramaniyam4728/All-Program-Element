package business_Logic;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

public class ClickOnTheImage implements Nlp {
    @InputParams({@InputParam(name = "Image Stream", type = "java.lang.String")})
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
          String s3ImagePath = (String) attributes.get("Image Stream");
          System.setProperty("java.awt.headless", "false");
          Screen s =new Screen();
          
         try
         {
        	Pattern AcceptAllCookies= new Pattern(s3ImagePath);
     		s.wait(AcceptAllCookies,1000);
     		s.click();
        nlpResponseModel.setStatus(CommonConstants.pass);
		nlpResponseModel.setMessage("Successfully clicked on the image");	
	       
         }
        catch(Exception e) {
        	StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
      	    nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to click on the image "+exceptionAsString);	
        }
          return nlpResponseModel;
      }
  }

