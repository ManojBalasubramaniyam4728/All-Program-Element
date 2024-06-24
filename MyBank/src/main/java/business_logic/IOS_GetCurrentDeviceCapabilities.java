
package business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.ios.IOSDriver;

/**
 * @description This NLP will return the current device's Capabilities as an map
 * @author Henry Jones
 */

import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLPde207575-2c28-4963-83cb-cbfae9c7cf32")
public class IOS_GetCurrentDeviceCapabilities implements Nlp {

	@ReturnType(name = "Assign Step Return Value To", type = "java.util.Map")

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

		// Your program element business logic goes here ...
		Map<String, Object> capabilities = null;
		try {
			IOSDriver driver = nlpRequestModel.getIosDriver();
			capabilities = driver.getCapabilities().asMap();
			nlpResponseModel.setMessage("Get Current Device's Capabilities is " + capabilities);
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("Failed to Get Current Device's Capabilities");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}

		nlpResponseModel.getAttributes().put("Assign Step Return Value To", capabilities);
		return nlpResponseModel;
	}

}