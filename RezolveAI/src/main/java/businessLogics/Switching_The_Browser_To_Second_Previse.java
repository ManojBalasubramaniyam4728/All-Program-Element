package businessLogics;


import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import java.util.Map;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

@Component("LIC7818_PJT1001_PE_NLP0fbb03f1-ee59-4498-be94-d6b6d69aeb21")
public class Switching_The_Browser_To_Second_Previse implements Nlp {
   
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
			robot.keyPress(java.awt.event.KeyEvent.VK_ALT);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
			robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
			robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);
			robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);
		
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Switching The Browser To Second Previse");
		    } 
          
          catch (Exception e) {
			
        	  nlpResponseModel.setStatus(CommonConstants.fail);
  			nlpResponseModel.setMessage("Faild to Switching The Browser To Second Previse");
  		    } 
          
          return nlpResponseModel;
      }
  } 