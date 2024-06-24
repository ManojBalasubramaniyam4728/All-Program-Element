
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

import io.appium.java_client.android.AndroidDriver;

import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLP28a54fc7-f1f9-441f-9571-d191dc184c44")
public class Android_IsApkInstalled implements Nlp {
	@InputParams({ @InputParam(name = "package to check", type = "java.lang.String") })
	@ReturnType(name = "Assign Step Return Value To", type = "java.lang.Boolean")

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
		String packageToCheck = (String) attributes.get("package to check");

		// Your program element business logic goes here ...
		boolean isInstalled = false;

		try {
			AndroidDriver driver = nlpRequestModel.getAndroidDriver();
			isInstalled = driver.isAppInstalled(packageToCheck);
			if (isInstalled) {
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("The APK is installed on the device");
			} else {
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("The APK is not installed on the device");
			}
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage(e.getMessage());
		}

		nlpResponseModel.getAttributes().put("Assign Step Return Value To", isInstalled);
		return nlpResponseModel;
	}
}