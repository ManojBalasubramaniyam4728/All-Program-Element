package Business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;

import io.github.bonigarcia.wdm.WebDriverManager;


@Component("LIC12844_PJT1001_PE_NLP5b06e36c-feb2-49d5-9b0e-8c1baa2f142b")
public class Open_Firefox_Browser implements Nlp {

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

		WebDriver driver = null;
		
		try {
			WebDriverManager.firefoxdriver().setup();
	            driver=new FirefoxDriver();
				nlpResponseModel.setWebDriver(driver);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage(" Firefox Browser Opened Successfully ");
		        }
		catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed Firefox To Open Browser ");
		} 

		return nlpResponseModel;
	}
}




