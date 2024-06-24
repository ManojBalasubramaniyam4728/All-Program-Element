
package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;

import io.appium.java_client.AppiumDriver;

public class IOS_Close_The_App implements Nlp {

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
		AppiumDriver driver = (AppiumDriver) nlpRequestModel.getIosDriver();
		
		try {
             driver.close();
             nlpResponseModel.setStatus(CommonConstants.pass);
 			 nlpResponseModel.setMessage("Successfully Closed The IOS App");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Failed To Closed The IOS App"+e);
		}
		
		return nlpResponseModel;
	}
}