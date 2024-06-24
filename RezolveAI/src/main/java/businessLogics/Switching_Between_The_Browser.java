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

@Component("LIC7818_PJT1001_PE_NLPbf53dfc0-77f6-41ab-ae27-4b68c73cd0c3")
public class Switching_Between_The_Browser implements Nlp {
   
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
			robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);
			robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Switched Between The Browser");
		    } 
          
          catch (Exception e) {
			
        	  nlpResponseModel.setStatus(CommonConstants.fail);
  			nlpResponseModel.setMessage("Faild to Switch Between The Browser");
  		    } 
          
          return nlpResponseModel;
      }
  } 