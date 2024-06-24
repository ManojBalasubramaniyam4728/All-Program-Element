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
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("LIC10506_PJT1001_PE_NLP3952e67f-9174-4102-971f-1c4aeed3da2d")
public class GetExpectedStringFromText implements Nlp {
	@InputParams({ @InputParam(name = "String Index", type = "java.lang.Integer"),
			@InputParam(name = "Text", type = "java.lang.String") })
	@ReturnType(name = "string3", type = "java.lang.String")

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
		String Text = (String) attributes.get("Text");
		Integer Index = (Integer) attributes.get("String Index");
		String exctectedValue = null;
		try {
			String a[] = Text.split(" ");
			exctectedValue = a[Index];
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfull extracted String From Text");

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed extracted String From Text");

		}

		String string3 = exctectedValue;
		nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}