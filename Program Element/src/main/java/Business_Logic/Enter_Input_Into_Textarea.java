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
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLPad2e119e-c091-453c-88ee-8e2fa25a12e0")
public class Enter_Input_Into_Textarea implements Nlp {
    @InputParams({@InputParam(name = "Input", type = "java.lang.String")})
   

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
        	 String Input = (String) attributes.get("Input");
        	System.setProperty("java.awt.headless", "false");
       	    StringSelection str = new StringSelection(Input);
    	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
    	    Thread.sleep(3000);
    	    
    	    System.setProperty("java.awt.headless", "false");
       	 Robot robot= new Robot();
       	 robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
       	 robot.keyPress(java.awt.event.KeyEvent.VK_V);
       	 robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
       	 robot.keyRelease(java.awt.event.KeyEvent.VK_V);
       	 nlpResponseModel.setStatus(CommonConstants.pass);
       	 nlpResponseModel.setMessage("Successfully EnterInput Into Textarea");
        }
        catch (Exception e) {
        	 nlpResponseModel.setStatus(CommonConstants.fail);
           	 nlpResponseModel.setMessage("Failed To Enter Input Into Textarea");
		}
          String string3 = "Return Value";
          nlpResponseModel.getAttributes().put("string3", string3);
          return nlpResponseModel;
      }
  } 
