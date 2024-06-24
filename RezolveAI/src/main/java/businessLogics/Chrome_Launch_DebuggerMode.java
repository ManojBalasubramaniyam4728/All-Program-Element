
package businessLogics;






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
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component("LIC7818_PJT1001_PE_NLP6ae33cbb-6b31-4d62-916b-2bc00c189f80")
public class Chrome_Launch_DebuggerMode implements Nlp {
	@InputParams({ @InputParam(name = "Input", type = "java.lang.String"),
		            @InputParam(name = "chromePath", type = "java.lang.String")})

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
			String Input = (String) attributes.get("Input");
			String chromePath = (String) attributes.get("chromePath");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments(Input);
		
	

         System.setProperty("webdriver.chrome.drive",chromePath);

			WebDriver driver = new ChromeDriver(options);
			
	        nlpResponseModel.setWebDriver(driver);
			
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Browser window is opened in successfully");
		      }

		 catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to open the browser"+e);
		}

		return nlpResponseModel;
	}
}
