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

@Component("LIC10506_PJT1001_PE_NLP13dbd540-20f7-401c-8ef4-351603cc0ee8")
public class Verify_List_Not_Contains_Expected_String implements Nlp {
	@InputParams({ @InputParam(name = "Input", type = "java.util.List"),
			@InputParam(name = "String Value", type = "java.lang.String") })
	@ReturnType(name = "isDispalyed", type = "java.lang.Boolean")

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
		Boolean isNotSame = false;
		try {
			List Input = (List) attributes.get("Input");
			String stringValue = (String) attributes.get("String Value");
			for (Object element : Input) {
				if (!element.equals(stringValue)) {
					isNotSame = true;
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Values are not same");
				} else {
					isNotSame = false;
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Values are same " + element);
					break;

				}
			}
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Exception occured" + e);
		}
		nlpResponseModel.getAttributes().put("string3", isNotSame);
		return nlpResponseModel;
	}
}