package Business_Logic;





import java.util.ArrayList;
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

import io.github.bonigarcia.wdm.WebDriverManager;


@Component("LIC8536_PJT1001_PE_NLPd8e0b0d7-fca5-46c2-ba68-889ed8b91c21")
public class Open_Browse_IN_Private implements Nlp {

	//@InputParams({@InputParam(name = "Driver Path", type = "java.lang.String")})

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
//		String driverPath = (String) attributes.get("Driver Path");
//		System.setProperty("webdriver.chrome.driver",driverPath);
		WebDriver driver = null;
		try {
		
			ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
			options.addArguments("--incognito");
			WebDriverManager.chromedriver().setup();
	          driver = new ChromeDriver(options);
	            
				IDriver idr = new com.tyss.optimize.data.models.dto.drivers.WebDriver((WebDriver) driver);
				nlpResponseModel.setDriver(idr);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("The Browser Is Successfully Opened IN Incognito");
		        }
		catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Open Browser In Incognito");
		} 

		return nlpResponseModel;
	}
}




