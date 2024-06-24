package businessLogics;





import com.tyss.optimize.common.util.CommonConstants; 
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import java.util.Map;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC7818_PJT1001_PE_NLPe8cea43f-5e06-454b-90d1-13ca9d2c3cd1")
public class Past_The_Text implements Nlp {
  

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
        	 robot.keyPress(java.awt.event.KeyEvent.VK_V);
        	 robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
        	 robot.keyRelease(java.awt.event.KeyEvent.VK_V);
        	 nlpResponseModel.setStatus(CommonConstants.pass);
        	 nlpResponseModel.setMessage("Successfully Text Is Pasted");
         }
         catch (Exception e) {
        	 nlpResponseModel.setStatus(CommonConstants.fail);
        	 nlpResponseModel.setMessage("Failed Past The Text");
		}
        	 
    
          return nlpResponseModel;
      }
  } 