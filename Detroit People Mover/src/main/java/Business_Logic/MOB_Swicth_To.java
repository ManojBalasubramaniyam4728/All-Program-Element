package Business_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.springframework.stereotype.Component;

@Component("LIC15384_PJT1004_PE_NLP98e5c21d-30d9-4023-b2db-be996ae00bb6")
public class MOB_Swicth_To implements Nlp {

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

		AndroidDriver driver = (AndroidDriver) nlpRequestModel.getAndroidDriver();

		try {

			driver.pressKey(new KeyEvent().withKey(AndroidKey.APP_SWITCH));
			driver.pressKey(new KeyEvent().withKey(AndroidKey.APP_SWITCH));
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Sucessefully  Switched ");
		} catch (Exception e) {
			e.printStackTrace();
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("failed to Switch " + e);
		}
		return nlpResponseModel;
	}
}
