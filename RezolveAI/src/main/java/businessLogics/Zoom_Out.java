package businessLogics;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;


@Component("LIC7818_PJT1001_PE_NLP9e56bd4a-a4b9-4daf-a4eb-3c95d8e6c9ec")
public class Zoom_Out implements Nlp {
   

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
         


          try {
        	  
        	System.setProperty("java.awt.headless", "false");
			Robot robot= new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyPress(java.awt.event.KeyEvent.VK_MINUS);
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyRelease(java.awt.event.KeyEvent.VK_MINUS);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Zoomed Out");
		    } 
          
          catch (Exception e) {
			
        	  nlpResponseModel.setStatus(CommonConstants.fail);
  			nlpResponseModel.setMessage("Failed Zoomed Out");
  		    } 
          return nlpResponseModel;
      }
  } 