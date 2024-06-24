
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

@Component("LIC1002_PJT1016_PE_NLPdcae44b7-0954-483f-b232-4384122abf33")
public class GetTheValueForKeyInTheMap implements Nlp {
	@InputParams({ @InputParam(name = "Map", type = "java.util.Map"),
			@InputParam(name = "Key", type = "java.lang.String") })
	@ReturnType(name = "Assign Step Return Value To", type = "java.lang.Object")

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
		Map<Object, Object> map = (Map<Object, Object>) attributes.get("Map");
		String key = (String) attributes.get("Key");

		// Your program element business logic goes here ...
		Object result = null;
		try {
			result = map.get(key);
			nlpResponseModel.setMessage("Get the value for key *" + key + "* in the map is " + result);
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("Failed to get the value for key *" + key + "* in the map is " + result);
			nlpResponseModel.setStatus(CommonConstants.fail);
		}

		nlpResponseModel.getAttributes().put("Assign Step Return Value To", result);
		return nlpResponseModel;
	}
}