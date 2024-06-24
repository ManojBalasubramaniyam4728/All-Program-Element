package Business_Logic;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.kafka.common.protocol.types.Field.Str;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;


import org.springframework.stereotype.Component;

@Component("LIC3168_PJT1001_PE_NLPa84581fb-89cf-4e7f-8f97-bdef3a5c4689")
public class Tes implements Nlp {
	@InputParams({ @InputParam(name = "Map", type = "java.util.Map")})

	@ReturnType(name = "map", type = "java.util.Map")

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
	private static String getDate(int i) {
	    String date = LocalDate.now().plusDays(i).format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        return date;
		
	}
	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		Map<String, String> map=(Map<String, String>)attributes.get("Map");
		Actions act=new Actions(driver);
		
		try {

			
			 for ( Entry<String, String> d:map.entrySet()) {
					WebElement we=driver.findElement(By.xpath("//span[text()='"+d.getKey()+"']/..//input"));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+d.getKey()+"']/..//input"))).click();
					act.moveToElement(we).build().perform();
					act.doubleClick().click().build().perform();
					Thread.sleep(1000);			
					we.sendKeys(d.getValue().toString().trim());
					}
			
			 nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Test" );
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Tsety" + e);
		}
		
		return nlpResponseModel;

	}
}
