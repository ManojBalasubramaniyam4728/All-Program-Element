
package clipboard;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.data.models.dto.IDriver;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component("LIC8536_PJT1001_PE_NLP9a594a25-da07-4343-9d47-0b590cccb0b8")
public class disbleAllNotification implements Nlp {
//    @InputParams({@InputParam(name = "string1", type = "java.lang.String"), 
//    	@InputParam(name = "string2", type = "java.lang.String")})
//    @ReturnType(name = "string3", type = "java.lang.String")

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
//          String string1 = (String) attributes.get("string1");
//          String string2 = (String) attributes.get("string2");

		WebDriver driver = null;
		try {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-geolocation");
			options.addArguments("disable-popup-blocking");
			options.addArguments("--disable-features=AutofillAddressEnabled");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-save-password-bubble");
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.addArguments("--disable-features=AutofillEnableAccountWalletStorage");
			options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
			options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking", "enable-automation"));
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--ignore-ssl-errors");

			
			
			
		
			IDriver idr = new com.tyss.optimize.data.models.dto.drivers.WebDriver((WebDriver) driver);
			nlpResponseModel.setDriver(idr);

			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Sucesss to disble");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to disble notification");
		}

		String string3 = "Return Value";
		nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}