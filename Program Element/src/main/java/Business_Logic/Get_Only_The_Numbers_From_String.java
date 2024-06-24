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

@Component("LIC8536_PJT1001_PE_NLP90ac7eaf-e75c-4863-97ff-faa0bd882d82")
public class Get_Only_The_Numbers_From_String implements Nlp {
	@InputParams({ @InputParam(name = "String", type = "java.lang.String") })
	@ReturnType(name = "returnValue", type = "java.lang.Integer")

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

		String number = null;
		try {
			String String = (String) attributes.get("String");
			number = String.replaceAll("[^0-9?]", "").trim();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Expected value is " + number);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to get values");
		}
		nlpResponseModel.getAttributes().put("returnValue", number);
		return nlpResponseModel;
	}
}
