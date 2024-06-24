package Business_Logic;

import java.io.File; 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;



@Component("LIC8536_PJT1001_PE_NLP2ff3d2aa-dae0-4535-bd5d-26e866b586c1")
public class GetScreenShot implements Nlp {
	@InputParams({ @InputParam(name = "filePath", type = "java.lang.String") })

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

		try {
			String filePath = (String) attributes.get("filePath");
			
			 WebDriver driver= (WebDriver) nlpRequestModel.getAndroidDriver();
			 
			Thread.sleep(1000);
			TakesScreenshot tsc=(TakesScreenshot)driver;
			File screenshot=tsc.getScreenshotAs(OutputType.FILE);
			Thread.sleep(1000);
			File file= new  File(filePath);
			FileUtils.copyFile(screenshot, file);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully screenshot captured");
		     } 
		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to screenshot captured"+e);
		}

		return nlpResponseModel;
	}
}
