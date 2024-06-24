package Business_Logic;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.html5.Location;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.AndroidDriver;

@Component("LIC15384_PJT1004_PE_NLPc2b88baa-bfdb-46d1-b250-6355567b9be8")
public class MOB_Set_Mock_Location implements Nlp {
	@InputParams({ @InputParam(name = "latitude", type = "java.lang.Double"),
			@InputParam(name = "longitude", type = "java.lang.Double"),
			@InputParam(name = "altitude", type = "java.lang.Double") })

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
		Double latitude = (Double) attributes.get("latitude");
		Double longitude = (Double) attributes.get("longitude");
		Double altitude = (Double) attributes.get("altitude");

		try {
			AndroidDriver driver = nlpRequestModel.getAndroidDriver();
			driver.setLocation(new Location(latitude, longitude, altitude));
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Location is successfully set to " + latitude + "," + longitude + " and " + altitude);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Failed To set the location " + exceptionAsString);
		}
		return nlpResponseModel;
	}
}