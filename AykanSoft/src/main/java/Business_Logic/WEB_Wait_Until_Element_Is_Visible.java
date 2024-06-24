package Business_Logic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;


@Component(value="WEB_Wait_Until_Element_Is_Visible")
public class WEB_Wait_Until_Element_Is_Visible implements Nlp {
	@InputParams({@InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
		          @InputParam(name = "elementType", type = "java.lang.String"),
                  @InputParam(name = "elementName", type = "java.lang.String"),
		          @InputParam(name = "Wait", type = "java.lang.Integer") })

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
    public static String extractLocatorMethod(String message) {
		
        
        String s1="method\":\"";
        String s2="\",\"selector\"";
        int a=s1.length();
        int startIndex = message.indexOf(s1);
        
        int endIndex = message.indexOf(s2, startIndex+a);
        return message.substring(startIndex+a, endIndex);
    }
    public static String extractLocatorValue(String message) {
       
        String s="selector\":\"";
        int a=s.length();
        int startIndex = message.indexOf(s);
        int endIndex = message.indexOf("\"}",startIndex+a);
        return message.substring(startIndex+a, endIndex);
    }

	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		
		String elementType = (String) attributes.get("elementType");
        String elementName = (String) attributes.get("elementName");
		Integer Wait = (Integer) attributes.get("Wait");

		try {
			WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
			WebElement element = (WebElement) attributes.get("element");
			new WebDriverWait(driver, Duration.ofSeconds(Wait))
			.until(ExpectedConditions.visibilityOf(element));

			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Waited Successfully Until "+elementName+"  "+elementType+" Is Visible ");

		} 
		catch (org.openqa.selenium.NoSuchElementException e) {
			WebDriver driver = (WebDriver) nlpRequestModel.getWebDriver();
		WebDriverWait wait=	new WebDriverWait(driver, Duration.ofSeconds(Wait));
			

			try {
				switch (extractLocatorMethod(e.getMessage())) {
				case "xpath" : wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(extractLocatorValue(e.getMessage()))));
				break;
				case "css selector" : wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(extractLocatorValue(e.getMessage()))));
				break;
				case "partial link text" : wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(extractLocatorValue(e.getMessage()))));
				break;
				case "link text" : wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(extractLocatorValue(e.getMessage()))));
				break;
				case "tag name" : wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(extractLocatorValue(e.getMessage()))));
				break;
				}
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Waited Successfully Until "+extractLocatorMethod(e.getMessage())+"  "+extractLocatorValue(e.getMessage())+" Element Is Visible ");
			}
			catch (Exception e2) {
				nlpResponseModel.setStatus(CommonConstants.fail);
				nlpResponseModel.setMessage("Failed to wait until element is visible"+e2);
			}
			
		}
		return nlpResponseModel;
	}
}

