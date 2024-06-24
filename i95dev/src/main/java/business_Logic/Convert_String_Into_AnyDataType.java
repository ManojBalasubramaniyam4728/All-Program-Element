
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component("LIC15066_PJT1001_PE_NLPec03e19f-7257-4f4d-a453-61412af81b00")
public class Convert_String_Into_AnyDataType implements Nlp {
	String datatype="";
    @InputParams({@InputParam(name = "String Data", type = "java.lang.String")})
    
    @ReturnType(name = "actualOrderID", type = "java.lang.String")

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
          WebDriver  driver=(WebDriver)  nlpRequestModel.getWebDriver();
          String actualOrderID= null;
          WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
          JavascriptExecutor jse = (JavascriptExecutor)driver;
           
          

          // Your program element business logic goes here ...
         
			try {
				String xpath= (String) attributes.get("Locator value");
				for (int i=0;i<10;i++) {
				try{
				WebElement element = driver.findElement(By.xpath(xpath));
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
					element.isDisplayed();
				String text = element.getText();
					nlpResponseModel.setStatus(CommonConstants.pass);
		            nlpResponseModel.setMessage("Text is found upon verifying the element: "+"The text of the element is "+text);
					break;
					
				}catch (NoSuchElementException e) {
					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
						nlpResponseModel.setStatus(CommonConstants.pass);
			               nlpResponseModel.setMessage("Text is found upon verifying the element");
			               break;
			               
					} catch (TimeoutException e2 ) {
						driver.navigate().refresh();
					}
				}}}catch (Exception e) {
					// TODO: handle exception
					nlpResponseModel.setStatus(CommonConstants.fail);
		               nlpResponseModel.setMessage("Text is not found since the element is not visible"+e);
				}
				
          
         nlpResponseModel.getAttributes().put("actualOrderID", actualOrderID);
          return nlpResponseModel;
      }
  } 