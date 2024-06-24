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
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
@Component("LIC7818_PJT1001_PE_NLP6d5e682b-129d-4f31-b9bb-20db35d8f43c")
public class Press_Two_key implements Nlp{
	
	@InputParams({@InputParam(name="PressfirstKey", type = "java.long.String"),@InputParam(name="PressSecoundKey", type = "java.long.String")})

	@Override
	public List<String> getTestParameters() throws NlpException {
		List<String> prams= new ArrayList<>();
		return prams;
	}
	
	@Override
	public StringBuilder getTestCode() throws NlpException {
		StringBuilder sb=new StringBuilder();
		return sb;
	}
	
	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
		

		NlpResponseModel nlpResponseModel=new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		
		try {
        String PressfirstKey = (String) attributes.get("PressfirstKey");
        String PressSecoundKey = (String) attributes.get("PressSecoundKey");
        System.setProperty("java.awt.headless", "false");
		Robot robot= new Robot();
		robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
		robot.keyPress(java.awt.event.KeyEvent.VK_MINUS);
		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
		robot.keyRelease(java.awt.event.KeyEvent.VK_MINUS);
		nlpResponseModel.setStatus(CommonConstants.pass);
		nlpResponseModel.setMessage("Successfully Prssed Two Key");
		nlpRequestModel.setPassMessage(PressSecoundKey);
		}
		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Press Two Key");
		}
		
       
        return nlpResponseModel;
	}
}

	

	
	

