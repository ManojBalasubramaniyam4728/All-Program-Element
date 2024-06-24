
package Bussiness_Logics;

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

@Component("LIC15257_PJT1002_PE_NLP0029e35d-3d8d-4d1b-b469-08f7491db544")
public class Split_And_Get_Value_From_The_Index implements Nlp {
	@InputParams({ @InputParam(name = "Input", type = "java.lang.String"),
			@InputParam(name = "SplitValue", type = "java.lang.String"),
			@InputParam(name = "IndexValue", type = "java.lang.Integer") })

	@ReturnType(name = "FinalValue", type = "java.lang.String")

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
		String Input = (String) attributes.get("Input");
		String SplitValue = (String) attributes.get("SplitValue");
		Integer IndexValue = (Integer) attributes.get("IndexValue");

		String FinalValue = "";
		try {
			String[] result = Input.split(SplitValue);
			String indexResult = result[IndexValue].trim();
			FinalValue = indexResult;
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Split And Get Value From The Index" + " " + IndexValue + " "+ "is" + " " + FinalValue);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Split And Get Value From The Index" + " " + IndexValue);
		}

		nlpResponseModel.getAttributes().put("FinalValue", FinalValue);
		return nlpResponseModel;
	}
}