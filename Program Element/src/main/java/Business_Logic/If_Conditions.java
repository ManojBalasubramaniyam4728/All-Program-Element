
package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

@Component("LIC8536_PJT1001_PE_NLP5a432972-dde3-422c-9978-c70363e77c2b")
public class If_Conditions implements Nlp {
	@InputParams({ @InputParam(name = "condition1", type = "java.lang.String"),
			@InputParam(name = "Operators", type = "java.lang.String"),
			@InputParam(name = "condition2", type = "java.lang.String") })
	@ReturnType(name = "FinalResult", type = "java.lang.String")

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
		Boolean FinalResult = true;
		Boolean containsOnlyNumbers = true;
		Integer num1 = 0;
		Integer num2 = 1;

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		String condition1 = (String) attributes.get("condition1");
		String Operators = (String) attributes.get("Operators");
		String condition2 = (String) attributes.get("condition2");

		try {

			for (char c : condition1.toCharArray()) {
				if (!Character.isDigit(c)) {
					num1 = Integer.parseInt(condition1);
					break;
				}
			}
			for (char c : condition2.toCharArray()) {
				if (!Character.isDigit(c)) {
					num2 = Integer.parseInt(condition2);
					break;
				}
			}
			 switch (Operators) {
             case "==":
            	 FinalResult= condition1 == condition2||num1==num2;
             case "<=":
            	 FinalResult =num1 <= num2;
             case ">=":
            	 FinalResult =num1 >= num2;
             case "!=":
            	 FinalResult =condition1 != condition2||num1!=num2;
             case ".contains":
            	 FinalResult =condition1.contains(condition2);
             case ".equals":
            	 FinalResult =condition1.equals(condition2);
             case ".equalsIgnoreCase":
            	 FinalResult =condition1.equalsIgnoreCase(condition2);
         }

			if (FinalResult == true) {
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("The Result Of If Condition Is"+" "+FinalResult);
			} else {
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("The Result Of If Condition Is"+" "+FinalResult);

			}
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed Execute The If Condition" + e.getMessage());
		}

		nlpResponseModel.getAttributes().put("ConditionResult", FinalResult);
		return nlpResponseModel;
	}
}