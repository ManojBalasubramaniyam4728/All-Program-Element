package Business_Logic;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.github.bonigarcia.wdm.WebDriverManager;


@Component("LIC11364_PJT1001_PE_NLP19ee6b48-aef8-4bda-8343-c0564ade5d3e")
public class Chrome_Launch_DebuggerMode1 implements Nlp {
	@InputParams({ @InputParam(name = "CMD Command", type = "java.lang.String"),
			@InputParam(name = "Folder Directory", type = "java.lang.String"),
			@InputParam(name = "Chrome Path", type = "java.lang.String") })

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

			String cmdCommand = (String) attributes.get("CMD Command");
			String folderDirectory = (String) attributes.get("Folder Directory");
			String chromePath = (String) attributes.get("Chrome Path");

			// log.info("Executing cmd command");
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand + folderDirectory, null,
					new File(chromePath));
			Thread.sleep(2000);

			// log.info("Command executed successfully, closing cmd");
			Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

			// log.info("Cmd closed, launching chrome browser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("debuggerAddress", "localhost:2705");
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);

			
			nlpResponseModel.setWebDriver(driver);

			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Browser window is opened in successfully");

		} catch (Exception e) {
			StringWriter exception = new StringWriter();
			e.printStackTrace(new PrintWriter(exception));
			// log.error(exception.toString());
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to open the browser");
		}

		return nlpResponseModel;
	}
}
