package Business_Logic;

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

@Component("LIC15384_PJT1001_PE_NLPae010e1e-daf7-4d06-8cb7-6afa07ccf02c")
public class Verify_List_Matches_Expected_String implements Nlp {
	@InputParams({ @InputParam(name = "Input", type = "java.util.List"),
			@InputParam(name = "String Value", type = "java.lang.String") })
	@ReturnType(name = "isMatches", type = "java.lang.Boolean")

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
		Boolean isMatches = false;
		try {
			List Input = (List) attributes.get("Input");
			String stringValue = (String) attributes.get("String Value");
			for (Object element : Input) {
				if (element.equals(stringValue)) {
					isMatches = true;
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Values Are Same In The List");
				} else {
					isMatches = false;
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Values Are Not Same In The List" + element);
					break;

				}
			}
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Exception occured" + e);
		}
		nlpResponseModel.getAttributes().put("isMatches", isMatches);
		return nlpResponseModel;
	}
}