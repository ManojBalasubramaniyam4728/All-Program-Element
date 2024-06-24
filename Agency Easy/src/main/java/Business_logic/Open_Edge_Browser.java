package Business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.stereotype.Component;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;

import io.github.bonigarcia.wdm.WebDriverManager;


@Component("LIC12844_PJT1001_PE_NLP0f7af1fa-452f-43c7-83ce-4975c339ae71")
public class Open_Edge_Browser implements Nlp {

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
			WebDriverManager.edgedriver().setup();
	            driver=new EdgeDriver();
				nlpResponseModel.setWebDriver(driver);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage(" Edge Browser Opened Successfully ");
		        }
		catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed Edge To Open Browser ");
		} 

		return nlpResponseModel;
	}
}




