package KuzaOne;


import com.tyss.optimize.common.util.CommonConstants; 
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;


@Component("LIC14333_PJT1002_PE_NLPf197c099-3bde-4dc7-b8f1-af435a4c12a9")
public class MOB_Generate_Random_Number_With_length_Number_Of_Digits implements Nlp {
	@InputParams({ @InputParam(name = "NumberOfDigits", type = "java.lang.Integer") })
	@ReturnType(name = "GeneratedNumbers", type = "java.lang.String")

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
		Integer NumberOfDigits = (Integer) attributes.get("NumberOfDigits");
		String GeneratedNumbers ="";
		try {
			Random rand = new Random();
			// Generate random Numbers with user given NumberOfDigits
			for(int i=1;i<=NumberOfDigits;i++) {
				int num = (int) (rand.nextInt(9) + 0);    
				GeneratedNumbers+=num;     
			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Generated Random Numbers");
		} 
		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Generated Random Numbers");
		}

		nlpResponseModel.getAttributes().put("GeneratedNumbers", GeneratedNumbers);
		return nlpResponseModel;
	}
}