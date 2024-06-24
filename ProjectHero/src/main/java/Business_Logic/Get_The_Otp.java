package Business_Logic;





import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;  
import com.tyss.optimize.nlp.util.annotation.InputParam; 
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import com.tyss.optimize.common.util.CommonConstants;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;


@Component("LIC9512_PJT1001_PE_NLP97ec7ba0-f9a9-4b02-b55e-83a90481ae81") 

public class Get_The_Otp implements Nlp {
	@InputParams({@InputParam(name = "Message with OTP", type = "java.lang.String")})
	@ReturnType(name="GetedOTP",type="java.lang.String")

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
		String otp=null;
		
		try {
			String message = (String) attributes.get("Message with OTP");
		    message = message.replaceAll("[^0-9?]", "");
			   otp = message.substring(0, 6);
			
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Getted The Otp "+otp);

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Get OTP");


		}
	
        nlpResponseModel.getAttributes().put("GetedOTP", otp);
		return nlpResponseModel;
	}
} 

