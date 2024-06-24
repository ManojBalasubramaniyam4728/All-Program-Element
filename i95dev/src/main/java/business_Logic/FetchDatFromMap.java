
package business_Logic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC15066_PJT1001_PE_NLPa138737c-1686-49af-885c-f7afc74e9dca")
public class FetchDatFromMap implements Nlp {
	@InputParams({@InputParam(name = "Map", type = "java.util.Map"), @InputParam(name = "Expected Header", type = "java.lang.String")})
	@ReturnType(name = "value", type = "java.lang.String")

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
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) attributes.get("Map");
		String expectedHeader = (String) attributes.get("Expected Header");


		String value="";
		try {
			value = map.get(expectedHeader);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully fetched the value "+value );

		}catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to fetch the value");

		}
		nlpResponseModel.getAttributes().put("value", value);
		return nlpResponseModel;
	}
} 