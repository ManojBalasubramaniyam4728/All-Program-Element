package business_logic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import io.appium.java_client.android.AndroidDriver;

import java.util.Map;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;


import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLPbc920153-239c-45a3-bf3e-d04cc9f37d58")
public class GetScreenShot implements Nlp {
	@InputParams({ @InputParam(name = "File path name with extension", type = "java.lang.String") })

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
		String filePath = (String) attributes.get("File path name with extension");

		try {
			AndroidDriver driver = nlpRequestModel.getAndroidDriver();
			File temp = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(temp, new File(filePath));
			nlpResponseModel.setMessage("Successfully captured the screenshot");
			nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("Failed to captured the screenshot");
			nlpResponseModel.setStatus(CommonConstants.fail);
		}
		return nlpResponseModel;
	}
}