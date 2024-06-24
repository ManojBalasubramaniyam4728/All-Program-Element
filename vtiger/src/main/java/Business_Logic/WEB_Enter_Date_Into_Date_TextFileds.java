package Business_Logic;

import java.time.Duration; 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class WEB_Enter_Date_Into_Date_TextFileds implements Nlp {

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			
			Map<String, String> dat = new LinkedHashMap<>();
			dat.put("Deadline Date", getDate(0));
			dat.put("Validity Start Date", getDate(0));
			dat.put("Evaluation Start Date", getDate(0));
			dat.put("Evaluation End Date", getDate(0));
			dat.put("Awarding Start Date", getDate(0));
			dat.put("Award By Date", getDate(0));
			dat.put("Validity End Date", getDate(0));
			dat.put("Delivery Date", getDate(1));

			for (Entry<String, String> d : dat.entrySet()) {
				 try{
		                WebElement staticElement = driver.findElement(By.xpath("//span[text()='" + d.getKey() + "']/..//input"));
		                if(Objects.nonNull(staticElement)) {
//		                    log.info("Found the element. Proceeding to while loop");
		                } else {
//		                    log.info("Element not found");
		                    nlpResponseModel.setStatus(CommonConstants.fail);
		                    nlpResponseModel.setMessage("Simple" + " " + " not found in first block");
		                }
		            } catch (NoSuchElementException e) {
//		                log.error("NoSuchElementException in IOS_WhileLoop ", e);
		                nlpResponseModel.setStatus(CommonConstants.fail);
		                nlpResponseModel.setMessage(  " Not found");
		            } catch (Exception e) {
		                nlpResponseModel.setStatus(CommonConstants.fail);
		                nlpResponseModel.setMessage(  " Not found");
		            }
				WebElement we = driver.findElement(By.xpath("//span[text()='" + d.getKey() + "']/..//input"));
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[text()='" + d.getKey() + "']/..//input"))).click();
				Actions act = new Actions(driver);
				act.moveToElement(we).build().perform();
				act.doubleClick().click().build().perform();
				Thread.sleep(1000);
				we.sendKeys(d.getValue().toString().trim());
			}
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Entered Date Into Date TextFileds");

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed To Enter Date Into Date TextFiled " + e);
		}
		return nlpResponseModel;
	}
}
