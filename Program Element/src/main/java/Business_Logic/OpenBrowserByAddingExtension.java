package Business_Logic;






import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.data.models.dto.IDriver;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

@Component("LIC8536_PJT1001_PE_NLP91221f6d-2fc8-4ace-a878-7256f85be4a4")
public class OpenBrowserByAddingExtension implements Nlp {

	@InputParams({@InputParam(name = "Driver Path", type = "java.lang.String"),@InputParam(name="Extension Path", type = "java.lang.String")})

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
		String driverPath = (String) attributes.get("Driver Path");
		String extensionPath =(String)attributes.get("Extension Path");
		System.setProperty("webdriver.chrome.driver",driverPath);
		WebDriver driver = null;
		try {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			File path = new File(extensionPath);
			options.addExtensions(path);
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);     
			IDriver idr = new com.tyss.optimize.data.models.dto.drivers.WebDriver((WebDriver) driver);
			nlpResponseModel.setDriver(idr);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("The browser is successfully opened adding Extension");
		}
		catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to open browser");
		} 

		return nlpResponseModel;
	}
}


