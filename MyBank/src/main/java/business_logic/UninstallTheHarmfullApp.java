package business_logic;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.AndroidDriver;
import java.util.Map;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLP453bed83-84b3-4bb2-b49d-8c0d741cbb9b")
public class UninstallTheHarmfullApp implements Nlp {
	// @InputParams({@InputParam(name = "string1", type = "java.lang.String"),
	// @InputParam(name = "string2", type = "java.lang.String")})
	// @ReturnType(name = "string3", type = "java.lang.String")

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
		// String string1 = (String) attributes.get("string1");
		// String string2 = (String) attributes.get("string2");

		try {
			AndroidDriver driver = nlpRequestModel.getAndroidDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			String appName = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.example.mybank:id/RecyclerViewAppG']//android.widget.TextView";
			List<WebElement> app = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.example.mybank:id/RecyclerViewAppG']//android.widget.TextView"));
			for (WebElement we : app) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appName)));
				driver.findElement(By.xpath(appName)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Uninstall']"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='OK']"))).click();
			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Uninstalled the Harmfull Application");
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Uninstalled the Harmfull Application " + e.getMessage());
		}

		// nlpResponseModel.getAttributes().put("string3", string3);
		return nlpResponseModel;
	}
}