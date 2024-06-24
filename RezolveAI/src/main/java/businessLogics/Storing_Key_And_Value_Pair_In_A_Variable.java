
package businessLogics;

import java.util.ArrayList;
import java.util.HashMap;
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

@Component("LIC7818_PJT1001_PE_NLPcd0abe17-3e88-4edc-9ab0-be5ab5d81823")
public class Storing_Key_And_Value_Pair_In_A_Variable implements Nlp {
	@InputParams({ @InputParam(name = "Key", type = "java.util.ArrayList"),
		           @InputParam(name = "Value", type = "java.util.ArrayList")})
	@ReturnType(name = "KeyValue", type = "java.util.Map")

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
		
		ArrayList<String> Key = (ArrayList<String>) attributes.get("Key");
		ArrayList<String> Value = (ArrayList<String>) attributes.get("Value");
		
		Map<String, String> keyValue = new HashMap<String, String>();
		Map<String, String> updatekeyValue = new HashMap<String, String>();
		
		try {
			Thread.sleep(2000);
			for (int i = 0; i < Key.size(); i++) {
				String keys = Key.get(i).trim();
				String values = Value.get(i).trim();
				keyValue.put(keys, values);
			}
	        // Copy non-null key-value pairs to the updated map
	        for (Map.Entry<String, String> entry : keyValue.entrySet()) {
	            if (entry.getValue() !="") {
	            	updatekeyValue.put(entry.getKey(), entry.getValue());
	            }
	        }
		nlpResponseModel.setStatus(CommonConstants.pass);
	    nlpResponseModel.setMessage("Successfully getted data from Ticket");
		} 
		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
		    nlpResponseModel.setMessage("Failed to get data from Ticket"+e);
		}

		nlpResponseModel.getAttributes().put("KeyValue", updatekeyValue);
		return nlpResponseModel;

	}
}