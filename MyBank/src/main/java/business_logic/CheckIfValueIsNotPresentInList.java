package business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;


import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLPdd3a6776-1be3-4380-86bc-4c949d613d7b")
public class CheckIfValueIsNotPresentInList implements Nlp {
	@InputParams({ @InputParam(name = "List", type = "java.util.ArrayList"),
		@InputParam(name = "Value", type = "java.lang.String")})
	@ReturnType(name = "Assign Step Return Value To", type = "java.lang.Boolean")

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
		ArrayList list = (ArrayList) attributes.get("List");
		String value = (String) attributes.get("Value");
		
		Boolean isNotPresent =null;
		
		try {
			isNotPresent=list.contains(value);
			if (isNotPresent!=true) {
				nlpResponseModel.setMessage(value+" is not present in the "+list);
				nlpResponseModel.setStatus(CommonConstants.pass);
			} else {
				nlpResponseModel.setMessage(value+" is present in the "+list);
				nlpResponseModel.setStatus(CommonConstants.fail);
			}
		} catch (Exception e) {
			nlpResponseModel.setMessage("Failed to check if value is not present in list "+e.getMessage());
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		
		nlpResponseModel.getAttributes().put("Assign Step Return Value To", isNotPresent);
		return nlpResponseModel;
	}
}