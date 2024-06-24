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

@Component("LIC10506_PJT1001_PE_NLP3b5558cb-4e97-4897-871e-30b1744c3c6d")
public class Verify_List_Contain_Expected_String_Or_Not implements Nlp {
	@InputParams({ @InputParam(name = "Input", type = "java.util.List"),
			@InputParam(name = "String Value", type = "java.lang.String") })
	@ReturnType(name = "isContains", type = "java.lang.Boolean")

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
		Boolean isContains = false;
		try {
			List Input = (List) attributes.get("Input");
			String stringValue = (String) attributes.get("String Value");

			for (Object element : Input) {
			String text=element.toString();
				if (text.contains(stringValue)) {
					isContains = true;
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("String Contains in list");
				} else {
					isContains = false;
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("String Not Contains in list");
					break;

				}
			}
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to verify" + e);
		}
		nlpResponseModel.getAttributes().put("isContains", isContains);
		return nlpResponseModel;
	}
}