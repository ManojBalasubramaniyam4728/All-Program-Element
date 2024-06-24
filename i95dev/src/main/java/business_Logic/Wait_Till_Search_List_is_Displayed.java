package business_Logic;

import com.amazonaws.services.simpledb.model.GetAttributesRequest;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component("LIC15066_PJT1001_PE_NLP6fed13a6-cd06-4d85-b518-6c3ea02fcdb5")
public class Wait_Till_Search_List_is_Displayed implements Nlp {
	@InputParams({ @InputParam(name = "Element", type = "org.openqa.selenium.WebElement"),
			@InputParam(name = "Input", type = "java.lang.String") })
	// @ReturnType(name = "actualOrderID", type = "java.lang.String" )

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
		WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
		// String actualOrderID= null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement Element = (WebElement) attributes.get("Element");
		String Input = (String) attributes.get("Input");
		for (int i = 0; i < 10; i++) {
			try {

				try {
					Thread.sleep(2000);
					
                    WebElement element1=driver.findElement(By.xpath("//div[text()='Search']/../../div[contains(@class,'search-box-container')]"));
					Point sourceLocation = element1.getLocation();
					Dimension sourceSize = element1.getSize();

					int centerX = sourceLocation.getX() + sourceSize.getWidth() / 2;
					int centerY = sourceLocation.getY() + sourceSize.getHeight() / 2;

					Actions actions = new Actions(driver);
					actions.moveByOffset(centerX, centerY).click().build().perform();
					
					Thread.sleep(2000);
					Element.sendKeys(Input);
					driver.findElement(By.xpath("//span[text()='" + Input + "']"));
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Searched Product Is DispalyedIn The Web Page");
					break;
				} catch (NoSuchElementException e) {
					driver.navigate().refresh();
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[text()='Search']/../../div[contains(@class,'search-box-container')]")));
				}
			}

			catch (Exception e2) {
				driver.navigate().refresh();
				nlpResponseModel.setStatus(CommonConstants.fail);
				nlpResponseModel.setMessage("Searched Product Is Not Dispalyed In The Web Page" + e2);
			}
		}

		// nlpResponseModel.getAttributes().put("actualOrderID", actualOrderID);
		return nlpResponseModel;
	}
}