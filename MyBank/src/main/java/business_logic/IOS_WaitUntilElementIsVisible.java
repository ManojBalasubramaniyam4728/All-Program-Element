 package business_logic;
  
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.springframework.stereotype.Component;

@Component("LIC1002_PJT1016_PE_NLP0bf7e44c-f8e5-44eb-bbfd-8ed86cee10e8")
public class IOS_WaitUntilElementIsVisible implements Nlp {
      
      @InputParams({@InputParam(name = "waittime", type = "java.lang.String"),
    	           @InputParam(name = "xpath", type = "java.lang.String")})
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
          String waittime = (String) attributes.get("waittime");
          String locatorValue = (String) attributes.get("locatorValue");
          AppiumDriver driver = (AppiumDriver) nlpRequestModel.getIosDriver();
          
	   try {
		   try{
               WebElement staticElement = driver.findElement(By.xpath(locatorValue));
               if(Objects.nonNull(staticElement)) {
               
               } else {
                   nlpResponseModel.setStatus(CommonConstants.fail);
                   nlpResponseModel.setMessage(locatorValue + " " + " not found in first block");
               }
           } catch (NoSuchElementException e) {
               nlpResponseModel.setStatus(CommonConstants.fail);
               nlpResponseModel.setMessage(locatorValue + " " + " Not found");
           } catch (Exception e) {
        	   
               nlpResponseModel.setStatus(CommonConstants.fail);
               nlpResponseModel.setMessage(locatorValue + " " + " Not found");
           }
              		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(waittime)));
		            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		            
	                nlpResponseModel.setStatus(CommonConstants.pass);
	                nlpResponseModel.setMessage("Successfully waited until"+" "+locatorValue+" "+" is visible");
          }
          catch(Exception e) {
              nlpResponseModel.setStatus(CommonConstants.fail);
	          nlpResponseModel.setMessage("Failed to wait until"+" "+locatorValue+" "+"is visible ");
          }
          
          
          return nlpResponseModel;
      }
  } 