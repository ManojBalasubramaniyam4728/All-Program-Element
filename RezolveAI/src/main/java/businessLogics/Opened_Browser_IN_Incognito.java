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

	@Component("LIC7818_PJT1001_PE_NLP6ca80b6b-95d9-4577-a831-05e5281c3a33")
	public class Opened_Browser_IN_Incognito implements Nlp {

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
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);     
				nlpResponseModel.setWebDriver(driver);
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

