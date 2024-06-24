package Business_Logic;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import org.springframework.stereotype.Component;

@Component("LIC3168_PJT1001_PE_NLP61d630bc-4d0f-4c47-87f3-893277dc6e1e")
public class WEB_Enter_Date_And_Time_Into_Date_TextFileds implements Nlp {
	@InputParams({ @InputParam(name = "explicitWait", type = "java.lang.Integer")})

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

		Integer explicitWait = (Integer) attributes.get("explicitWait");

		WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));

		try {
			List<String> dat=new LinkedList<>();
	        dat.add("Approval Start Date and Time");
			dat.add("Approval End Date and Time");
			dat.add("Publish Date and Time");
			dat.add("Event Start Date and Time");
			dat.add("Event End Date and Time");
			dat.add("Evaluation Start Date and Time");
			dat.add("Evaluation End Date and Time");
			dat.add("Awarded Start Date and Time");
			dat.add("Awarded End Date and Time");

			for (String t: dat) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+t+"']/..//img")));
				driver.findElement(By.xpath("//div[text()='"+t+"']/..//img")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'cell-today')]/.."))).click();
				if(t.equals("Approval Start Date and Time")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"owl-dt-timer-input\"])[2]"))).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"owl-dt-timer-input\"])[2]"))).sendKeys(LocalTime.now().plusMinutes(10).getMinute()+"");
				}
				Thread.sleep(500);
		        driver.findElement(By.xpath("//button/span[text()='Apply']")).click();	
			}	
		
			
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Entered Date And Time Into Date TextFileds");

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Enter Date And Time Into Date TextFiled " + e);
		}
		return nlpResponseModel;
	}
}
